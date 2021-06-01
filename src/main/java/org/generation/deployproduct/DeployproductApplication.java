package org.generation.deployproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
public class DeployproductApplication {

	public static void main(String[] args) {
		SpringApplication.run(DeployproductApplication.class, args);
	}

}

@RestController
class HelloController {
	@GetMapping("/")
	String hello() {
		return "Hello World";
	}
}