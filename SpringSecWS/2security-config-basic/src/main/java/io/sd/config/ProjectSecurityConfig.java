package io.sd.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.debug("Using Overrided configure(HttpSecurity). ");
		http.authorizeRequests(
//				(requests) -> requests.anyRequest().authenticated()
				(requests) -> 
				requests.antMatchers("/welcome").authenticated()
										.antMatchers("/secured").authenticated()
										.antMatchers("/unsecured").permitAll()
//	requests.anyRequest().denyAll() // to deny all requests.
//	requests.anyRequest().permitAll() // to permit all requests.
				);
		http.formLogin();
		http.httpBasic();
	}

}
