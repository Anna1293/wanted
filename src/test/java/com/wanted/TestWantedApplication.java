package com.wanted;

import org.springframework.boot.SpringApplication;

public class TestWantedApplication {

	public static void main(String[] args) {
		SpringApplication.from(WantedApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
