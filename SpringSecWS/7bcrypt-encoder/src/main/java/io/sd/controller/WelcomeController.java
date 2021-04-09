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
	
}
