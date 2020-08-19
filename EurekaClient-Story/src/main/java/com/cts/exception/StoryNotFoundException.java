package com.cts.exception;

public class StoryNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public StoryNotFoundException()
	{
		super();
	}
	public StoryNotFoundException(String ex)
	{
		super(ex);
	}
}
