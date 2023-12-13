package com.web.app.securityConfige;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigu {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserDetailsService userDetailsServices;
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig ) throws Exception {
	
		 return authConfig.getAuthenticationManager();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider  = new DaoAuthenticationProvider();
	
		provider.setPasswordEncoder(passwordEncoder);
		provider.setUserDetailsService(userDetailsServices);
		return provider;
	}
	
	
	
	@Bean
	public SecurityFilterChain configurePath(HttpSecurity security) throws Exception{
	
		security.authorizeHttpRequests(r->{
			r.antMatchers("/home","/","/user/**")
			.permitAll().antMatchers("/admin").hasAuthority("ADMIN")
			.antMatchers("/customer").hasAuthority("CUSTOMER")
			.anyRequest()
			.authenticated();
		}).formLogin(f->{
			f.loginPage("/login").permitAll().defaultSuccessUrl("/home");
		}).logout(l->{
			l.permitAll();
		});
		
		return security.build();
	}
	
}
