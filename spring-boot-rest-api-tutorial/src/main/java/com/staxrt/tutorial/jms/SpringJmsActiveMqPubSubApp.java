package com.staxrt.tutorial.jms;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJmsActiveMqPubSubApp {
	
	public static void main(String[] args) {
		// https://www.devglan.com/spring-boot/spring-boot-jms-activemq-example (another possible example)
		
		//https://hub.docker.com/r/rmohr/activemq
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:EmbeddedActiveMQ.xml", "classpath:spring/activemq-jms-spring-context.xml");
		
		MessagePublisher messagePublisher = (MessagePublisher) applicationContext.getBean("messagePublisher");
		
		messagePublisher.sendMessage("This is a message that will be posted into Topic.");
	}
	
}