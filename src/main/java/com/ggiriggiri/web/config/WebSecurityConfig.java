package com.ggiriggiri.web.config;



import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
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
