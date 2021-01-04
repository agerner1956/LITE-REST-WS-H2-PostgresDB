package com.lifeimage.lite.ws.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.lifeimage.lite.ws.server.security.JWTAuthorizationFilter;
import com.lifeimage.lite.ws.server.utils.Constants;

@SpringBootApplication
public class TransactionTrackingApplication extends SpringBootServletInitializer {
	private static final Logger logger = LoggerFactory.getLogger(SpringBootApplication.class);
	public static void main(String[] args) {
		logger.debug(Constants.messageStarted);
		SpringApplication.run(TransactionTrackingApplication.class, args);
		
		
	}
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers(HttpMethod.POST, "/user").permitAll()
				.anyRequest().authenticated();
		}
	} 

}
