package com.verizon.proxyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.verizon.*")
public class ProxyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyServiceApplication.class, args);
	}

}
