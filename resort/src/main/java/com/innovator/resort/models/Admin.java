package com.innovator.resort.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "TB_ADMIN",
	   uniqueConstraints = {@UniqueConstraint(columnNames = {"first_name", "last_name"})})
public class Admin 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long adminId;
	
	@Column(name = "first_name" , nullable = false)
	private String firstName;
	
	@Column(name = "last_name" , nullable = false)
	private String lastName;
	
	@Column(name = "age", nullable = false)
	private int age;

	@Column(name = "gender", nullable = false)
	private String gender;

	@Column(name = "city", nullable = false)
	private String city;


/**
 *	Setters method
 *	to initialize the properties
 */
	

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public void setAge(int age) 
	{
		this.age = age;
	}
	
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	public void setCity(String city) 
	{
		this.city = city;
	}
	
/**
 *	Getters method
 *	to retrieve the data
 */

	public long getAdminId() 
	{
		return adminId;
	}

	public String getFirstName() 
	{
		return firstName;
	}

	public String getLastName() 
	{
		return lastName;
	}

	public int getAge()
	{
		return age;
	}

	public String getGender() 
	{
		return gender;
	}

	public String getCity()
	{
		return city;
	}
	
/**
 *	Overriding toString()
 *	to customize the output whenever the reference is called 
 */
	@Override
	public String toString() 
	{
		return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender + ", city=" + city + "]";
	}
}

/*
 	JSON
 	
 	{
      "firstName" : "vinayak",
  	  "lastName" : "banavi",
  	  "age" : 26,
  	  "gender" : "male",
  	  "city" : "bengaluru"
	}
*/