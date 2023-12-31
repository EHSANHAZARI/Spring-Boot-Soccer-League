package com.example.topleagues.security.jwt.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.topleagues.security.jwt.exception.RefreshTokenException;

@RestControllerAdvice
public class TokenControllerAdvice {

	@ExceptionHandler(value = RefreshTokenException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorMessage handleTokenRefreshException(RefreshTokenException ex, WebRequest request) {
		return new ErrorMessage(HttpStatus.FORBIDDEN.value(), new Date(), ex.getMessage(),
				request.getDescription(false));
	}
}
