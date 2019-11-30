package hoa.api.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ServiceDriver {
	
	/**
	 * Driver - @SpringBootApplication bean marks this as main
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ServiceDriver.class, args);
	}

}
