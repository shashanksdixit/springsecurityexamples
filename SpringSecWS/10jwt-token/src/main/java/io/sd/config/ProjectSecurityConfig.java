package io.sd.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import io.sd.jwt.JwtTokenUtil;
import io.sd.jwt.JwtTokenValidationFilter;
import io.sd.persistance.Customer;
import io.sd.persistance.CustomerRepository;
import io.sd.persistance.User;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class ProjectSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomerRepository customerRepository;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username ->
	        { 
	        	Customer customer = customerRepository.findByEmail(username);
	        	List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	        	authorities.add(new SimpleGrantedAuthority(customer.getRole()));
	        	UserDetails user = new User(username, customer.getPwd(), authorities);
	        	return user;
	        }
        );
    }
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		log.debug("Using Overrided configure(HttpSecurity). ");

		http = http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests(
				(requests) -> requests
						.antMatchers("/welcome").authenticated()
						.antMatchers("/secured").authenticated()
						.antMatchers("/unsecured").permitAll()
						.antMatchers("/admin").authenticated()
						.antMatchers("/write").hasAuthority("write")
						.antMatchers("/read").hasAuthority("read")
						.antMatchers("/admin").hasRole("ADMIN")
						.antMatchers("/nonadmin").hasAnyRole("ADMIN", "NONADMIN")
		).cors().and().csrf().disable();
		
		http.addFilterBefore(new JwtTokenValidationFilter(), UsernamePasswordAuthenticationFilter.class );
//		.formLogin()
//			.usernameParameter("email")
//			.passwordParameter("pwd").and()
//		.httpBasic();
	}
	
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public JwtTokenUtil jwtTokenUtil() {
		return new JwtTokenUtil();
	}
	
    @Override @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


}
