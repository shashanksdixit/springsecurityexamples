package io.sd.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.sd.persistance.User;

public class JwtTokenUtil {
	public String generateAccessToken(User user) {
		SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes(StandardCharsets.UTF_8));
		String jwt = Jwts.builder().setIssuer("ThisApp").setSubject("JWT Token")
				.claim("username", user.getUsername())
				.claim("authorities", populateAuthorities(user.getAuthorities()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + 1800000)) // 30 mins
				.signWith(key).compact();
		return jwt;

	}
	
	private String populateAuthorities(Collection<? extends GrantedAuthority> collection) {
		Set<String> authoritiesSet = new HashSet<>();
        for (GrantedAuthority authority : collection) {
        	authoritiesSet.add(authority.getAuthority());
        }
        return String.join(",", authoritiesSet);
	}
}
