package io.sd.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to Spring Security";
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
		return "You have 'write' access";
	}

	@GetMapping("/read")
	public String read() {
		return "You have 'read' access";
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
