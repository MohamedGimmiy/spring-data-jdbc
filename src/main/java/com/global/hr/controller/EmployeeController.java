package com.global.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.entity.Employee;
import com.global.hr.reposatory.EmployeeRepo;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	@GetMapping("/count")
	public long countEmp() {
		return employeeRepo.count();
	}
	
	@GetMapping("/{id}")
	public Employee findById(@PathVariable Long id) {
		return employeeRepo.findById(id).get();
	}
	@GetMapping
	public List<Employee> findAll() {
		return (List<Employee>) employeeRepo.findAll();
	}
	
	@GetMapping("/insert")
	public Employee addEmployee() {
		return employeeRepo.save(new Employee(null,"hamdy",3000.0));
	}
	
	@GetMapping("/update")
	public Employee updateEmp() {
		return employeeRepo.save(new Employee(20L,"mido",10000.0));
	}
	
	@GetMapping("/filter/{name}/{salary}")
	public List<Employee> filter(@PathVariable String name,@PathVariable Double salary) {
		return employeeRepo.findBysalaryAndName(name,salary);
	}
	
	@GetMapping("/delete/{id}")
	public void deleteEmp(@PathVariable("id") Long id) {
		System.out.println("Deleted");
		 employeeRepo.deleteById(id);
	}
	
}
