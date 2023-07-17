package com.example.topleagues.security.jwt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class RefreshTokenException extends RuntimeException {

	private static final long serialVersionUID = 4835231599623182087L;

	public RefreshTokenException(String token, String message) {
		super(String.format("Failed for [%s]: %s", token, message));
	}
}
