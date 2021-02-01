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

	@Order(1)
	@Configuration
	public class CustomerSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private DataSource dataSource;
		
		@Autowired
		private AuthenticationSuccessHandler successHandle;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.antMatcher("/customer/**")
				.authorizeRequests()
					.antMatchers("/customer/login","/customer/study/list","/customer/project/list").permitAll()
					.antMatchers("/customer/**").hasRole("MEMBER")
				.and()
				.formLogin()
					.loginPage("/customer/login")
					.loginProcessingUrl("/customer/login")
					.defaultSuccessUrl("/index")
					.successHandler(successHandle)
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
					.authoritiesByUsernameQuery("select email id, 'ROLE_MEMBER' from Member where email=?")
					.passwordEncoder(new BCryptPasswordEncoder());
		}
	}

	
	@Configuration	
	public class AdminSecurityConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private DataSource dataSource;
		
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.antMatcher("/admin/**")
				.authorizeRequests()
					.antMatchers("/admin/login").permitAll()
					.antMatchers("/admin/**").hasRole("ADMIN")
					.and()
				.formLogin()
					.loginPage("/admin/login")
					.loginProcessingUrl("/admin/login")
					.defaultSuccessUrl("/admin/index")
					.and()
				.csrf()
					.disable();
		}

		@Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {

			auth
				.jdbcAuthentication()
				.dataSource(dataSource)
					.usersByUsernameQuery("select nickname,concat('{noop}',password),true from Admin where nickname=?")
					.authoritiesByUsernameQuery("select nickname,'ROLE_ADMIN' from Admin where nickname=?");

		}
	}
}
