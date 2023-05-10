package com.innovator.resort.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.innovator.resort.models.Admin;


@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> 
{
	public Admin findByFirstNameAndLastName(String firstName, String lastName);
}
