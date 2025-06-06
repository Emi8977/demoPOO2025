package com.example.seg_proy_Luna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.seg_proy_Luna.repositories")
@EntityScan(basePackages = "com.example.seg_proy_Luna.entities")
public class SegProyLunaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SegProyLunaApplication.class, args);
	}

}
