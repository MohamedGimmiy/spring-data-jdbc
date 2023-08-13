package com.global.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.global.hr.entity.Employee;
import com.global.hr.reposatory.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	public long count() {
		return employeeRepo.count();
	}
	
	public Employee findById(Long id) {
		return employeeRepo.findById(id).get();
	}
	
	public List<Employee> findAll() {
		return (List<Employee>) employeeRepo.findAll();
	}
	
	public Employee insert(Employee emp) {
		return employeeRepo.save(emp);
	}
	
	public Employee update(Employee emp) {
		return employeeRepo.save(emp);
	}
	
	public List<Employee> findByName(String name) {
		return employeeRepo.findByName(name);
	}
	
	//List<Employee> findByNameStartingWithAndSalaryGreaterThanEqual(String name,Double salary);
	
	public List<Employee> findByNameAndSalary(String name, Double Salary){
		return employeeRepo.findByNameAndSalary(name, Salary);
	}
	
	public List<Employee> findBysalaryAndName(String name, 
			 Double salary){
		return employeeRepo.findBysalaryAndName(name, salary);
	}
	
	public void deleteEmp(Long id) {
		 employeeRepo.deleteById(id);
	}
	
	public int updateSalary(Double salary, Long id) {
		return employeeRepo.updateSalary(salary, id);
	}
}
