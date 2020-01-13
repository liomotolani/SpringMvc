/**
 * 
 */
package com.springdemo.employee.service;

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
}
