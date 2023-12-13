package com.blog.app.configu;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.blog.app.security.InvalidAuthenticaionEntryPoint;
import com.blog.app.security.filter.SecurityFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigu {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private SecurityFilter securityFilter;
	
	@Autowired
	private InvalidAuthenticaionEntryPoint authenticationEntryPoint;
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
			DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
			provider.setPasswordEncoder(passwordEncoder);
			provider.setUserDetailsService(userDetailsService);
			return provider;
	}
	
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authentication) throws Exception {
		  return authentication.getAuthenticationManager();
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		security.csrf().disable();
		
		security.authorizeRequests()
		        .antMatchers("/api/auth/**","/api/users/checkUsernameAvailability/**","/api/users/checkEmailAvailability/**","/swagger-ui/**","/swagger-ui").permitAll()
		        .antMatchers("/api/company/**").hasAuthority("ADMIN")
		        .antMatchers("/api/users","/api/users/{username}/giveAdmin","/api/user/{username}/takeAdmin").hasAuthority("ADMIN")
		        .anyRequest()
		        .authenticated()
		        .and()
		        .exceptionHandling()
		        .authenticationEntryPoint(authenticationEntryPoint)
		        .and()
		        .sessionManagement()
		        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		        .and()
		        .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class);
		
		        return security.build();
	}
	 @Bean
	    public WebSecurityCustomizer webSecurityCustomizer() {
	        return (web) -> web.ignoring().antMatchers("/v3/api-docs/**");
	    }
}
