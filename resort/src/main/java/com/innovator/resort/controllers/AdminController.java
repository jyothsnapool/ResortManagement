package com.innovator.resort.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.innovator.resort.Exception.ResourceNotFoundException;
import com.innovator.resort.Exception.UserAlreadyExistsException;
import com.innovator.resort.models.Admin;
import com.innovator.resort.repositories.AdminRepository;


@RestController
public class AdminController
{
	@Autowired
	private AdminRepository repo;

/**
 *	logger
 *	logger.info() can be used directly as spring boot application itself configures
 * 	all other loggers need to be configured
 */
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
/**
 *  save            : Save the admin details in the database.
 *  				: while saving checks the database for records with same firstName and lastName
 *  				: if present throws exception.
 *  input format    : JSon (Admin Object)
 *  return          : Saved Admin records
 */
	
	@PostMapping("admin/save")
	public Admin save(@RequestBody Admin admin)
	{
//		if user is not found the repository will send the optional object
		Optional<Admin> user = Optional.ofNullable(repo.findByFirstNameAndLastName(admin.getFirstName(), admin.getLastName()));
		
		logger.info("Create request for : " + admin);
		
		if(user.isPresent())
		{
			logger.warn("User already exist with first_name : " + admin.getFirstName() + " and last_name : " + admin.getLastName());
			throw new UserAlreadyExistsException(admin.getFirstName(), admin.getLastName());
		}
		else
		{			
			logger.info("Saved Admin records successfully : " + admin);
			return repo.save(admin);
		}
	}
	
/**
 *  readAll         : Retrieve all the admin details from the database.
 *  input           : no input
 *  return          : All the Admin records
 */
	@GetMapping("admins")
	public Iterable<Admin> findAll()
	{
		logger.info("All the Admin records retrieved");
		return repo.findAll();
	}
	
/**
 *  read admin by id : Retrieve the admin details for the given id from the database.
 *  		         : Handles the Exception if Admin records not available
 *  input            : admin id
 *  return           : Single admin records
 */

	@GetMapping("admin/{id}")
	public Admin findById(@PathVariable("id") Long adminId)
	{		
		logger.info("Read request for Admin Id : " + adminId);
		Admin admin = repo.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("Admin", "Id", adminId));
		
		logger.info("Records retrieved for Admin Id : " + adminId);
		return admin;
	}
	
/**
 *  update           : updates the existing details of the Existing admin.
 *  				 : updates the given fields if certain fields were null retains the existing details.
 *  		         : Handles the Exception if admin records not available.      
 *  input            : admin id, Json 
 *  return           : Success Message/ Updated details
 */

	@PutMapping("admin/update/{id}")
	public Admin update(@PathVariable("id") long adminId,@RequestBody Admin admin)
	{ 
		logger.info("Update request recieved for Admin Id : " + adminId);
		Admin current = repo.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("Admin", "Id", adminId));
		
		logger.info("Admin Records updated for Id : " + adminId);
		current.setFirstName(admin.getFirstName() != null ? admin.getFirstName() : current.getFirstName());
		current.setLastName(admin.getLastName() != null ? admin.getLastName() : current.getLastName());
		current.setGender(admin.getGender() != null ? admin.getGender() : current.getGender());
		current.setAge(admin.getAge() != 0 ? admin.getAge() : current.getAge());
		current.setCity(admin.getCity() != null ? admin.getCity() : current.getCity());
		
		return repo.save(current);
	}
	
/**
 *  delete 			 :       
 *  input            : Admin id
 *  return           : Status of removal
 */
	
	@DeleteMapping("admin/delete/{id}")
	public void delete(@PathVariable("id") long adminId)
	{
		logger.info("Delete request for Admin Id : " + adminId);
		Optional<Admin> admin = repo.findById(adminId);
		
		if(admin.isPresent())
		{
			logger.info("Deleted Admin records with Id : " + adminId);
			repo.deleteById(adminId);
		}
		else
		{
			logger.info("No Admin records found with Id : " + adminId);
			throw new ResourceNotFoundException("Admin", "Id", adminId);
		}
		
	}

}
