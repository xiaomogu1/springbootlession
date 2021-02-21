package com.staxrt.tutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.staxrt.tutorial.jms.MessagePublisher;

/**
 * The type Application.
 *
 * @author Givantha Kalansuriya
 */
@SpringBootApplication
public class Application  { // implements CommandLineRunner

//	@Autowired
//	private MessagePublisher messagePublisher;
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//		messagePublisher.sendMessage("This is a message that will be posted into Topic.");
//		
//	}
}
