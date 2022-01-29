package de.djgummikuh.minimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan(basePackages = {"de.ips.creactivities"})
public class MinimalExample {

	public static void main(String[] args) {
		SpringApplication.run(MinimalExample.class, args);
	}

}
