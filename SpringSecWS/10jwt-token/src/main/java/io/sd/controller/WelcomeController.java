package io.sd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Spring Security";
	}
	
	@GetMapping("/")
	public String none() {
		return "Welcome to Spring Security root app";
	}
	
	@GetMapping("/secured")
	public String securedMethod() {
		return "Accessed secured method";
	}

	@GetMapping("/unsecured")
	public String unsecuredMethod() {
		return "Accessed unsecured method";
	}

	@GetMapping("/write")
	public String write() {
		return "One write access required to write()";
	}

	@GetMapping("/read")
	public String read() {
		return "One read access required to read()";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "User logged in has admin access";
	}

	@GetMapping("/nonadmin")
	public String nonadmin() {
		return "Admin or non-admin can access this method.";
	}
		
}
