package com.perfios.exception;

public class CustomException extends Exception {

	public CustomException() {
		super("No appointment maps to this id, please check ! ");
	}
	
}
