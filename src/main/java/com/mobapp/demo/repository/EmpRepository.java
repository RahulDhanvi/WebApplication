package com.mobapp.demo.repository;


//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mobapp.demo.entity.Employee;

//import antlr.collections.List;

public interface EmpRepository extends CrudRepository<Employee, String>{
	
//	//@Query("select distinct(college) from Employee")
//	public List  findByCollege();
	
}
