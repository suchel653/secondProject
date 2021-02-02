package com.ggiriggiri.web.config;

import java.io.IOException;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.ggiriggiri.web.entity.Member;
import com.ggiriggiri.web.service.MemberService;

@Component
public class GgiriGgiriAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	@Autowired
	private MemberService memberService;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws ServletException, IOException {
		HttpSession session = request.getSession();
		System.out.println("실행되라");
		if (session != null) {

			User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			String email = authUser.getUsername();
			Member m = memberService.get(email);
			session.setAttribute("id", m.getId());
			session.setAttribute("nickname", m.getNickname());
			
			System.out.println(session.getAttribute("id"));
			Set<String> authorities = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

			SavedRequest savedRequest = (SavedRequest) session.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
			if (savedRequest != null) {
				String returnURL = savedRequest.getRedirectUrl();
				redirectStrategy.sendRedirect(request, response, returnURL);
			} else if (authorities.contains("ROLE_ADMIN")) {
				redirectStrategy.sendRedirect(request, response, "/admin/index");
			} else if (authorities.contains("ROLE_MEMBER")) {
				redirectStrategy.sendRedirect(request, response, "/index");
			} else {

				super.onAuthenticationSuccess(request, response, authentication);
			}

		}
	}
}
