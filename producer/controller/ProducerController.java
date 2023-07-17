package com.example.topleagues.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.topleagues.producer.domain.Message;
import com.example.topleagues.producer.service.RabbitMQSender;

@RestController
@RequestMapping(value = "/api/v1")
public class ProducerController {

	@Autowired
	private RabbitMQSender rabbitMQSender;

	@Value("${app.message}")
	private String msg;

	@PostMapping("/message")
	public String sendMessage(@RequestBody Message message) {
		rabbitMQSender.send(message);
		System.out.println(message);
		return msg;
	}

}
