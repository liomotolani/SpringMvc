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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.springDemo1.entities.Employee;
import com.springdemo.employee.service.EmployeeService;

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
}
