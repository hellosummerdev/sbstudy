package com.sbstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //데이터소스를 자동으로 등록한다하는 걸 제외(디비 연동 안됐을때)
@SpringBootApplication
public class SbstudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbstudyApplication.class, args);
	}

}
