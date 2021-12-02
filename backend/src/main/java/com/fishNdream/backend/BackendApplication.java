package com.fishNdream.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.fishNdream.backend.repository.SysGainRepository;

@SpringBootApplication
public class BackendApplication {

	@Autowired
	SysGainRepository sysRepository;

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		System.setProperty("app.superadmin", "wvanmerwe3@ihg.com");

	}

	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() {
		System.setProperty("app.percentage", String.valueOf(sysRepository.getLatestGain()));
	}

}
