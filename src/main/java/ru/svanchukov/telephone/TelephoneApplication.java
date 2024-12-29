package ru.svanchukov.telephone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "ru.svanchukov.telephone")
public class TelephoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelephoneApplication.class, args);
	}

}
