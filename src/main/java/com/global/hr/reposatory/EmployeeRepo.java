package com.global.hr.reposatory;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Long> {
	List<Employee> findByName(String name);
	
	//List<Employee> findByNameStartingWithAndSalaryGreaterThanEqual(String name,Double salary);
	
	List<Employee> findByNameAndSalary(String name, Double Salary);
	
	@Query(value = "SELECT * FROM EMPLOYEE WHERE SALARY >= :EMPSALARY AND NAME LIKE :EMPNAME")
	List<Employee> findBysalaryAndName(@Param("EMPNAME") String name, 
			@Param("EMPSALARY") Double salary);

}
