package com.springDemo1.employee.service;

import java.util.List;

import com.springDemo1.entities.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);
	
	public List<Employee> getEmployees();
	
	public Employee getEmployeeById(int id);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(Employee employee);
	
}
