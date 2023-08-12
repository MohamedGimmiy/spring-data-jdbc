package com.global.hr.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("employee")
public class Employee {
	
	@Id
	@Column("id")
	private Long id;
	
	@Column("name")
	private String name;
	
	@Column("salary")
	private Double salary;
	
	@Transient
	private Boolean isCreated;
	
	public Boolean getIsCreated() {
		return isCreated;
	}
	public void setIsCreated(Boolean isCreated) {
		this.isCreated = isCreated;
	}
	public Long getId() {
		return id;
	}
	public Employee() {
		super();
	}
	public Employee(Long id, String name, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
}
