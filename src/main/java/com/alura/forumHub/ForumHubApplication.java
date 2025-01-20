package com.alura.forumHub;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude= {UserDetailsServiceAutoConfiguration.class})
public class ForumHubApplication {

	public static void main(String[] args) {

		SpringApplication.run(ForumHubApplication.class, args);
	}

}
