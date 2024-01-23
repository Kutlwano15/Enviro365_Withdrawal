package com.enviro.assessment.grad001.kutlwanomoseki.enviro365withdrawals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.enviro.assessment.grad001.kutlwanomoseki.model")

public class Enviro365WithdrawalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Enviro365WithdrawalsApplication.class, args);
	}

}
