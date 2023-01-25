package com.home.notes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.logging.Logger;

@SpringBootApplication
public class NotesApplication {
	private static final Logger LOGGER = Logger.getLogger(NotesApplication.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(NotesApplication.class, args);
		LOGGER.info("Notes server started on port 8080");
	}

}
