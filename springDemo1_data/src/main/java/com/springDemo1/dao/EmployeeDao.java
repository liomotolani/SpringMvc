/**
 * 
 */
package com.springDemo1.dao;

import java.util.List;

import com.springDemo1.entities.Employee;

/**
 * @author user
 *
 */
public interface EmployeeDao {

	public void addEmployee(Employee employee);
	
	public List<Employee> getEmployees();
	
	public Employee getEmployeeById(int id);
	
	public void updateEmployee(Employee employee);
	
	public void deleteEmployee(int id);
}
