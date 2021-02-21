package com.staxrt.tutorial.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

//https://roytuts.com/spring-jms-and-activemq-integration-publishsubscribe-domain/

@Component
public class MessagePublisher {

	@Autowired
	private JmsTemplate jmsTemplate;

	public void sendMessage(final String message) {
		jmsTemplate.convertAndSend(message);
	}

}