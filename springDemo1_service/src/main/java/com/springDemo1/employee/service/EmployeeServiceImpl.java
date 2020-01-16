/**
 * 
 */
package com.springDemo1.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springDemo1.dao.EmployeeDao;
import com.springDemo1.entities.Employee;

/**
 * @author user
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao employeeDaoImpl;
	
	public void addEmployee(Employee employee) {
		
		employeeDaoImpl.addEmployee(employee);
	}
	
	
	public List<Employee> getEmployees(){
		
		return employeeDaoImpl.getEmployees();
	}
	
	public Employee getEmployeeById(int employeeId) {
		
		 return employeeDaoImpl.getEmployeeById(employeeId);
	}
	
	public void updateEmployee(Employee employee) {
		
		employeeDaoImpl.updateEmployee(employee);
	}
	
	public void deleteEmployee(Employee employee) {
		
		employeeDaoImpl.deleteEmployee(employee);
	}
}
