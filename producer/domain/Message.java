package com.example.topleagues.producer.domain;

import org.springframework.stereotype.Component;

@Component
public class Message {

	public String message;

	public String department;

	public Message() {
		super();
	}

	public Message(String message, String department) {
		super();
		this.message = message;
		this.department = department;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + ", department=" + department + "]";
	}

}
