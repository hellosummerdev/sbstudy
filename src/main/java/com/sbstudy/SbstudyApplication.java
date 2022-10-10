package com.sbstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SbstudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbstudyApplication.class, args);
	}

}
