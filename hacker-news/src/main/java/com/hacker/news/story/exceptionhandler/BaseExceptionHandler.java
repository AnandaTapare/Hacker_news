package com.hacker.news.story.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class BaseExceptionHandler {
	


	private static final String UNEXPECTED_ERROR = "Unexpected error occurred, Please contact system administrator.";

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public ErrorResponse handleThrowable(final Throwable ex) {
		final ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errorResponse.addError(UNEXPECTED_ERROR);
		return errorResponse;
	}
}
