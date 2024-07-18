package com.api.system_transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.api.system_transaction", "com.api.email_service"})
public class SystemTransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(SystemTransactionApplication.class, args);
	}

}
