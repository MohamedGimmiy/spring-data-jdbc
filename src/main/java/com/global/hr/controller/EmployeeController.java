package com.global.hr.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.global.hr.entity.Employee;
import com.global.hr.reposatory.EmployeeRepo;
import com.global.hr.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	Logger log = LoggerFactory.getLogger(EmployeeController.class);
	
	@GetMapping("/count")
	public long countEmp() {
		return employeeService.count();
	}
	
	@GetMapping("/{id}")
	//@RequestMapping(method = RequestMethod.GET,path = "/api/v1/employee")
	public ResponseEntity<Employee> findById(@PathVariable Long id) {
		log.info("logging....");
		return new  ResponseEntity<Employee>(employeeService.findById(id), HttpStatus.OK) ;
	}
	
	@GetMapping
	public List<Employee> findAll() {
		return (List<Employee>) employeeService.findAll();
	}
	
	@PostMapping
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee emp) {
		return new ResponseEntity<Employee>(employeeService.insert(emp), HttpStatus.CREATED) ;
	}
	
	@PutMapping
	public Employee updateEmp( @RequestBody Employee emp) {
		return employeeService.update(emp);
	}
	
	@GetMapping("/filter")
	public List<Employee> filter(@RequestParam String name,@RequestParam Double salary) {
		return employeeService.findBysalaryAndName(name, salary);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmp(@PathVariable("id") Long id) {
		 employeeService.deleteEmp(id);
	}
	
	@PutMapping("/salary")
	public int updateSalary(@RequestParam Double salary,@RequestParam Long id) {
		return employeeService.updateSalary(salary, id);
	}
	
}
