package com.innovator.resort.Exception;

public class UserAlreadyExistsException extends RuntimeException 
{
	private String firstName;
	private String lastName;
	
	
	public UserAlreadyExistsException(String firstName, String lastName)
	{
		super(String.format("Admin records with %s %s already present", firstName, lastName));
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}
}
