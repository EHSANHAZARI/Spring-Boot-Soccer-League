package com.example.topleagues.producer.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.topleagues.producer.domain.Message;

// Sender or Producer 
@Service
public class RabbitMQSender {

	private RabbitTemplate rabbitTemplate;

	@Value("${spring.rabbitmq.exchange}")
	private String exchange;
	
	

	@Autowired
	public RabbitMQSender(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	// exchange put the message in the appropriate queue
	public void send(Message message) {
		rabbitTemplate.convertAndSend(exchange,message.getDepartment(), message.getMessage());
	}

}
