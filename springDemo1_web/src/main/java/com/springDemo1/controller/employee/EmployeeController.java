package com.springDemo1.controller.employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springDemo1.employee.service.EmployeeService;
import com.springDemo1.entities.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeServiceImpl;
	
	
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee temployee) {
		
		employeeServiceImpl.addEmployee(temployee);
		
		return temployee;
	}
	
	
	@GetMapping("/allEmployee")
	public List<Employee> fetchAllEmployee(){
		
		return employeeServiceImpl.getEmployees();
	}
	
	@GetMapping("/employee/{id}")
	public Employee fetchEmployee(@PathVariable int id) {
		
		return employeeServiceImpl.getEmployeeById(id);
		
	}
	
	@PutMapping("/updateEmployee/{employeeId}")
	public Employee updateEmployee( @PathVariable int employeeId,@RequestBody Employee employee) {
		
//		employee.setId(employeeId);
		
		employeeServiceImpl.updateEmployee(employee);
		
		return employee;
	}
	
	@DeleteMapping("/employee/{id}")
	public void deleteEmployee(@PathVariable int id) {
		
		employeeServiceImpl.deleteEmployee(id);
		
		
	}
}
