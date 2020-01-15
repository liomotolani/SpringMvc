/**
 * 
 */
package com.springDemo1.employee.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.springDemo1.employee.service.EmployeeService;
import com.springDemo1.entities.Employee;

/**
 * @author user
 *
 */
@ContextConfiguration("classpath:/springDemo1-service-context.xml")
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

	@Mock
	private EmployeeService employeeService;
	
	@Before
	public void setUp() throws Exception {
		
		employeeService = mock(EmployeeService.class);
	}

	@Test
	public void employeeExitsTest() {
		assertNotNull(EmployeeService.class);
	}
	
	@Test
	public void addEmployeeTest() {
		
		Employee employee = new Employee("Peter","Kunle","jknumab@me.com");
		
		doNothing().when(employeeService).addEmployee(isA(Employee.class));
		employeeService.addEmployee(employee);
		
		verify(employeeService,times(1)).addEmployee(employee);
	}
	
	@Test 
	public void getEmployeeTest() {
		
		Employee tempEmployee = new Employee("Kunle", "Ade","kunleade@gmail.com");
		
		Employee tempEmployee1 = new Employee("lekan", "ola","lekunaola@gmail.com");
		
		Employee tempEmployee2 = new Employee("wale", "deola","waledeola@gmail.com");
		
		List<Employee> allEmployees =  new ArrayList<>();
		
		allEmployees.add(tempEmployee);
		
		allEmployees.add(tempEmployee1);
		
		allEmployees.add(tempEmployee2);
		
		when(employeeService.getEmployees()).thenReturn(allEmployees);
		
		verify(employeeService, times(1)).getEmployees();
	}
}
