package org.hebronworks.SpringAuthethicationJDBC.Resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Resources {
	
	@GetMapping("/")
	public String mainPage() {
		return new String("Welcome to my You tube channel");
	}
	
	@GetMapping("/user")
	public String userPage() {
		return new String("Welcome user,this is your page ");
	}
	
	@GetMapping("/admin")
	public String adminPage() {
		return new String("Welcome Admin,You can see all pages");
	}

}
