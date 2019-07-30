package com.mobapp.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mobapp.demo.entity.Employee;
import com.mobapp.demo.entity.Login;
import com.mobapp.demo.repository.EmpRepository;


@Service
public class EmpService {
	@Autowired
	private EmpRepository empRepository;
	
	public Iterable<Employee> getEmp(){
		return empRepository.findAll();
	}
	
	
	
	
	public Optional<Employee> getById(String email) {
		return empRepository.findById(email);
	}
	
	public void insert(Employee e) {
		empRepository.save(e);
		
	}
	
	public void deleteById(String email) {
		 empRepository.deleteById(email);
	}
	
	public void updateById(String email,Employee e) {
		e.setEmail(email);
		empRepository.save(e);
	}
	
	public int check(String email, String pass) {
		Optional<Employee> emp;
		Employee e2;
		
		try {
		emp = empRepository.findById(email);
		e2 = emp.get();
		}
		catch (Exception e) {
			return 0;
		}
		
		if(e2.getPassword().equals(pass))
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
	
	public int check(Login login) {
		Optional<Employee> emp;
		Employee e2;
		
		try {
		emp = empRepository.findById(login.getEmail());
		e2 = emp.get();
		}
		catch (Exception e) {
			return 0;
		}
		
		if(e2.getPassword().equals(login.getPassword()))
		{
			return 1;
		}
		else
		{
			return -1;
		}
	}
}
