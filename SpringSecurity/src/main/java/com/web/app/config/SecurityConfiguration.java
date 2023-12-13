package com.web.app.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    // ======= Authentication  In Memory =======
//	
//	@Bean
//	public UserDetailsService userDetailsServices() {
//		UserDetails user1 = User.withDefaultPasswordEncoder()
//				.username("Kamal")
//				.password("Kaml")
//				.roles("Admin")
//				.build();
//		UserDetails user2 = User.withDefaultPasswordEncoder()
//				.username("ROhit")
//				.password("roh")
//				.roles("Owner")
//				.build();
//		return new InMemoryUserDetailsManager(user1,user2);
//	}
//	
//	// ======= Authorization  In Memory =======
//	@Bean
//	public SecurityFilterChain configurePath(HttpSecurity security) throws Exception{
//		security.authorizeHttpRequests(r->{
//			r.antMatchers("/home","/")
//			.permitAll()
//			.anyRequest()
//			.authenticated();
//		}).formLogin(f->{
//			f.loginPage("/login").permitAll();
//		}).logout(l->{
//			l.permitAll();
//		});
//		return security.build();
//	}
	
	
	// ================ JDBC AUthentication ==================
	@Bean
	public BCryptPasswordEncoder  passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserDetailsService userDetailsServices(DataSource datasource) {
		UserDetails user1 = User.withUsername("Rohit")
				.password("$2a$10$zIvIItqCAdMBlQAjA58vGOjZD0tzx5KKrsy1z7x09MEuwy.TJJ9OK")
				.authorities("ADMIN")
				.build();
		UserDetails user2 = User.withUsername("Ram")
				.password("$2a$10$zIvIItqCAdMBlQAjA58vGOjZD0tzx5KKrsy1z7x09MEuwy.TJJ9OK")
				.authorities("CUSTOMER")
				.build();
		JdbcUserDetailsManager  users = new JdbcUserDetailsManager(datasource);
		users.createUser(user1);
		users.createUser(user2);
		return  users;
	}
	
//	 ========== JDBC Authorization =======
		@Bean
		public SecurityFilterChain configurePath(HttpSecurity security) throws Exception{
			security.authorizeHttpRequests(r->{
				r.antMatchers("/home","/")
				.permitAll().antMatchers("/admin").hasAuthority("ADMIN")
				.antMatchers("/customer").hasAuthority("CUSTOMER")
				.anyRequest()
				.authenticated();
			}).formLogin(f->{
				f.loginPage("/login").permitAll();
			}).logout(l->{
				l.permitAll();
			});
			return security.build();
		}
	
}
