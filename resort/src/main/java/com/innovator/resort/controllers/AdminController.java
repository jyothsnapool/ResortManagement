package com.innovator.resort.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovator.resort.models.Admin;
import com.innovator.resort.services.AdminService;

@RestController
@RequestMapping("hotel")
public class AdminController 
{
	@Autowired
	private AdminService service;
	
	@PostMapping("admin/save")
	public Admin save(@RequestBody Admin admin)
	{
		return service.save(admin); 
	}
	
	@GetMapping("admins")
	public Iterable<Admin> findAll()
	{
		return service.findAll();
	}
	
	@GetMapping("admin/{id}")
	public Admin findById(@PathVariable("id") Long adminId)
	{		
		return service.findById(adminId);
	}
	
	@PutMapping("admin/update/{id}")
	public Admin update(@PathVariable("id") long adminId, @RequestBody Admin admin)
	{ 
		return service.update(adminId, admin);
	}
	
	@DeleteMapping("admin/delete/{id}")
	public void delete(@PathVariable("id") long adminId)
	{
		service.delete(adminId);
	}

}
