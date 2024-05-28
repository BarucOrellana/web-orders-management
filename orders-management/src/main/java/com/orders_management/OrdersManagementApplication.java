package com.orders_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class OrdersManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersManagementApplication.class, args);
	}

}
