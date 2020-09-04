package com.marketing.smscampaing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
// TODO Koniecznie dorobić jakąś usługę, która ładuje dane jeżeli takie nie istnieją
public class SmsCampaingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmsCampaingApplication.class, args);
	}

	@PostConstruct
	public void prepareData() {

	}

}
