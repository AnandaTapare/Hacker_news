package com.hacker.news.story.exceptionhandler;

import java.util.HashSet;
import java.util.Set;

public class ErrorResponse {
	private int code;
	private Set<String> errors;

	/**
	 * @param code
	 * @param message
	 */
	public ErrorResponse(int code, Set<String> errors) {
		super();
		this.code = code;
		this.errors = errors;
	}

	public ErrorResponse() {

	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

	/**
	 * @return the errors
	 */
	public Set<String> getErrors() {
		return errors;
	}

	/**
	 * Add error
	 * 
	 * @param error the error to add
	 */
	public void addError(String error) {
		if (this.errors == null) {
			this.errors = new HashSet<>();
		}
		this.errors.add(error);
	}

	/**
	 * Add errors
	 * 
	 * @param errors the errors to add
	 */
	public void addErrors(Set<String> errors) {
		if (this.errors == null) {
			this.errors = new HashSet<>();
		}
		this.errors.addAll(errors);
	}
}