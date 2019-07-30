package com.mobapp.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mobapp.demo.entity.Employee;
import com.mobapp.demo.entity.Login;
import com.mobapp.demo.service.EmpService;

import antlr.collections.List;

@CrossOrigin(origins="http://localhost:4200")

@RestController
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@PostMapping("/login")
	public int login(@RequestBody Login login) {
		return empService.check(login);
	}
	
	@PostMapping("/logins/{email}/{password}")
	public int logins(@RequestBody String email,@RequestBody String password)
	{
		return empService.check(email, password);
	}

	@GetMapping("/viewallemployees")
	public Iterable<Employee> getAll() {
		return empService.getEmp();
	}
	
	
	
	@GetMapping("/viewemployeebyid/{email}")
	public Optional<Employee> getEmp(@PathVariable String email) {
		return empService.getById(email);
	}
	
	@PostMapping("/addemployee")
	public void addEmp(@RequestBody Employee e) {
		empService.insert(e);
	}
	
	@DeleteMapping("/deleteemployee/{email}")
	public void delEmp(@PathVariable String email) {
		empService.deleteById(email);
	}
	
	@PutMapping("/updateemployee/{email}")
	public void updateEmp(@PathVariable String email, @RequestBody Employee e) {
		empService.updateById(email, e);
	}
	
}
