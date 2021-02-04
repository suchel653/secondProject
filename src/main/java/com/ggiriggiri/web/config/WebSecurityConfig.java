package com.ggiriggiri.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
public class WebSecurityConfig {

	@Configuration
	public class CustomerSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private DataSource dataSource;
		
		@Autowired
		private AuthenticationSuccessHandler successHandler;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
//				.antMatcher("/customer/**")
				.authorizeRequests()
					.antMatchers("/customer/login","/customer/join","/customer/checkMail",
							"/customer/checkDuplicate","/customer/study/list","/customer/project/list",
							"/customer/study/","/customer/project/")
					.permitAll()
					.antMatchers("/admin/**").hasRole("ADMIN")
					.antMatchers("/customer/**").hasAnyRole("MEMBER","ADMIN")
				.and()
				.formLogin()
					.loginPage("/customer/login")
					.loginProcessingUrl("/customer/login")
					.defaultSuccessUrl("/index")
					.successHandler(successHandler)
				.and()
				.logout()
		            .logoutUrl("/customer/logout")
		            .logoutSuccessUrl("/index")
		            .invalidateHttpSession(true)
	            .and()
				.csrf()
					.disable();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			auth
				.jdbcAuthentication()
				.dataSource(dataSource)
					.usersByUsernameQuery("select email id, password, 1 enabled from Member where email=?")
					.authoritiesByUsernameQuery("select m.email id, r.name roleId "
												+ "from Member m"
												+ " join Role r on r.id = m.roleId"
												+ " where email=?")
					
					.passwordEncoder(new BCryptPasswordEncoder());
		}
	}

	

}
