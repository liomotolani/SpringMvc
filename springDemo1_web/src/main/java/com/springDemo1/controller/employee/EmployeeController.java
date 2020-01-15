package com.springDemo1.controller.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.WebApplicationContext;

import com.springDemo1.employee.service.EmployeeService;
import com.springDemo1.entities.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeServiceImpl;
	
	
	
	@PostMapping("/addEmployee")
	public String addEmployee(@ModelAttribute("employee") Employee temployee) {
		
		employeeServiceImpl.addEmployee(temployee);
		
		return "list-employees";
	}
	
	@GetMapping("/showForm")
	public String showFormForAdd(Model theModel) {
		Employee theEmployee = new Employee();
		
		theModel.addAttribute("employee", theEmployee);
		
		return "employee-form";
	}

}
