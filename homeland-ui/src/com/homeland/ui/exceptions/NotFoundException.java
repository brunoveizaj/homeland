package com.homeland.ui.exceptions;


public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NotFoundException(String message)
	{
		super(message);
	}
}
