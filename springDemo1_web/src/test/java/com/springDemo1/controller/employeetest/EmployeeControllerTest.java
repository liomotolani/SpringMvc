package com.springDemo1.controller.employeetest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.springDemo1.controller.employee.EmployeeController;
import com.springDemo1.employee.service.EmployeeService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration("file:src/main/webapp/WEB-INF/spring-mvc-crud-demo-servlet.xml")
@RunWith(SpringRunner.class)
public class EmployeeControllerTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private EmployeeService employeeServiceImpl;
	
	
	@Before
	public void setUp() throws Exception{
		
		MockitoAnnotations.initMocks(this);
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(EmployeeController.class).build();
	}
	
	
	@Test
	public void getFormRequestTest() {
		try {
			mockMvc.perform(post("/showForm"))
				   .andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		assertNotNull(employeeServiceImpl);
	}

}
