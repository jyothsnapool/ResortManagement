package com.innovator.resort.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.innovator.resort.models.Admin;
import com.innovator.resort.service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@RequestMapping("/saveadmin")
	public String saveAdmin(@RequestBody Admin admin) {
		try 
		{
			return "Admin saved successfully!";
		} 
		catch (Exception e) 
		{
			return "Error saving admin: " + e.getMessage();
		}
	}
}
