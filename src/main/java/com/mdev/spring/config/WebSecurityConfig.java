package com.mdev.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService customUserDetailsService;

	@Autowired
	AuthenticationSuccessHandler successHandler;

	@Autowired
	private DataSource dataSource;

	@Bean
	// @Autowired
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http
//			.csrf().disable()
//			.authorizeRequests()
//			.antMatchers("/admin/login").permitAll()
//			.antMatchers("/indexStudent").hasAnyRole("USER")
//			.antMatchers("/admin").hasAnyRole("ADMIN")
//			.and().formLogin().loginPage("/login")
//				.successHandler(successHandler)
//			.permitAll()
//			.and().logout();

		http.headers().frameOptions().sameOrigin().and().authorizeRequests()
				.antMatchers("/resources/**", "/webjars/**", "/assets/**").permitAll().antMatchers("/").permitAll()
				// Permissions for Admin Users 
				//.antMatchers("/index", "/indexTeacher","/indexStudent").hasRole("ADMIN")
				// Permissions for ACTUATOR Users
				//.antMatchers("/indexTeacher","/indexStudent").hasRole("ACTUATOR")
				// // Permissions for USER (student) Users
				//.antMatchers("/indexStudent").hasRole("USER")
				.anyRequest()
				.authenticated().and().formLogin()
				.loginPage("/login").successHandler(successHandler).permitAll().and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/login?logout")
				.deleteCookies("my-remember-me-cookie").permitAll().and().rememberMe()
				// .key("my-secure-key")
				.rememberMeCookieName("my-remember-me-cookie").tokenRepository(persistentTokenRepository())
				.tokenValiditySeconds(24 * 60 * 60).and().exceptionHandling();
	}

	PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepositoryImpl = new JdbcTokenRepositoryImpl();
		tokenRepositoryImpl.setDataSource(dataSource);
		return tokenRepositoryImpl;
	}

}
