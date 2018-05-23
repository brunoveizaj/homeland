package com.homeland.exceptions;


public class EntityExistsException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public EntityExistsException(String message)
	{
		super(message);
	}
}
