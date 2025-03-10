package com.TextSnap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TextSnapApplication {

	public static void main(String[] args) {
		 String port = System.getenv("PORT"); // Get port from environment
		    if (port == null || port.isEmpty()) {
		        port = "8080"; // Default to 8080 if not set
		    }
		    System.setProperty("server.port", port); // Set the server port dynamically
		SpringApplication.run(TextSnapApplication.class, args);
	}

}
