/**
 * 
 */
package com.springDemo1.entitiesTest;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.springDemo1.dao.EmployeeDao;
import com.springDemo1.db.DbConnectionManagerTest;
import com.springDemo1.entities.Employee;

/**
 * @author user
 *
 */

@ContextConfiguration(locations="classpath:/springDemo-data-context.xml")
@RunWith(SpringRunner.class)
public class EmployeeDaoImplTest {

	private Logger logger = Logger.getLogger(DbConnectionManagerTest.class.getName());

	
	
	@Autowired
	private EmployeeDao employeeDaoImpl;
	
	@Autowired
	private ComboPooledDataSource dataSource;
	
	@Before
	public void setUp() throws Exception{
		
		
		
		String username = "springdemouser";
		
		String password = "spring_Demo";
		
		String jdbcDriver = "com.mysql.cj.jdbc.Driver";
		
		String DBUrl = "jdbc:mysql://localhost:3306/springdemodb?useSSL=false&serverTimezone=UTC";
		
		Connection conn = null;
		
		QueryRunner queryRunner = new QueryRunner(dataSource);
		
		 try {
		
		DbUtils.loadDriver(jdbcDriver);
		
		conn = DriverManager.getConnection(DBUrl,username,password);
		
		queryRunner.update("drop database springdemodb");
		
		queryRunner.update("create database springdemodb");
		
		queryRunner.update("use springdemodb");
		
		queryRunner.update("create table `employee`(\r\n" + 
				"	\r\n" + 
				"	`id` int(11) not null auto_increment,\r\n" + 
				"	`first_name` varchar(45) default null,\r\n" + 
				"	`last_name` varchar(45) default null,\r\n" + 
				"	`email` varchar(45) default null,\r\n" + 
				"	\r\n" + 
				"	 primary key(`id`)\r\n" + 
				"	\r\n" + 
				")ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;");
		 }catch(Exception e) {
			 logger.throwing(EmployeeDaoImplTest.class.getName(), "setUp method", e.getCause());
			 
			 e.printStackTrace();
		 }
		finally {
			
			DbUtils.close(conn);
		}
	}
	
	
	
	@Test
	public void dbManagerClassesInitializedTest() {
		
		assertNotNull(employeeDaoImpl);
		assertNotNull(dataSource);
	}
	
	@Test
	public void addEmployeeToDatabaseTest() {
		
		try {
			
			logger.info("Creating new employee object");
			
			Employee tempEmployee = new Employee("Kunle", "Adeola","kunleadeola@gmail.com");
			
			logger.info("Storing employee to the database");
			employeeDaoImpl.addEmployee(tempEmployee);
			
			logger.info("Successfully saving employee to the database");
			
		}catch(Exception e) {
			
			
			e.printStackTrace();
			logger.warning("Error saving employee to the database");
		}
	}
	
	
	@Test
	public void getEmployeeListTest() {
		
		List<Employee> allEmployee=  fetchListOfEmployeeFromDataBase();		
		
		assertNotNull(allEmployee.get(0));
		
		assertNotNull(allEmployee.get(1));
		
		assertNotNull(allEmployee.get(2));
		
		assertNotNull(allEmployee.get(3));
		
		
	}



	
	
	@Test
	public void getEmployeeByIdTest() {
		
		
		
		List<Employee> allEmployee =  fetchListOfEmployeeFromDataBase();
		
		
		int employeeId = allEmployee.get(0).getId();
		
		Employee employee = employeeDaoImpl.getEmployeeById(employeeId);
		
		String firstName = employee.getFirstName();
		
		String lastName = employee.getLastName();
		
		String email = employee.getEmail();
		
		
		
		assertEquals(firstName,employee.getFirstName());
		
		assertEquals(lastName,employee.getLastName());
		
		assertEquals(email,employee.getEmail());
		
		
		
	}
	
	@Test
	public void updateEmployeeTest() {
		
		//get an employee from the database
		List<Employee> allEmployee =  fetchListOfEmployeeFromDataBase();
		
		Employee employee = allEmployee.get(0);
		
		//update the employee
		String firstName = "John";
		
		employee.setFirstName(firstName);
		
		employeeDaoImpl.updateEmployee(employee);
		
	}
	
	
	@Test
	public void deleteEmployeeTest() {
		
		
		List<Employee> allEmployee =  fetchListOfEmployeeFromDataBase();
		
		Employee employee = allEmployee.get(0);
		
		assertNotNull(employee);
		
		employeeDaoImpl.deleteEmployee(employee.getId());
	}
	
	
	
private List<Employee> fetchListOfEmployeeFromDataBase() {
		
		Employee tempEmployee = new Employee("Kunle", "Ade","kunleade@gmail.com");
		
		Employee tempEmployee1 = new Employee("lekan", "ola","lekunaola@gmail.com");
		
		Employee tempEmployee2 = new Employee("wale", "deola","waledeola@gmail.com");
		
		Employee tempEmployee3 = new Employee("adigun", "Adeola","adigunadeola@gmail.com");
		
		employeeDaoImpl.addEmployee(tempEmployee);
		
		employeeDaoImpl.addEmployee(tempEmployee1);
		
		employeeDaoImpl.addEmployee(tempEmployee2);
		
		employeeDaoImpl.addEmployee(tempEmployee3);
		
		List<Employee> allEmployee = employeeDaoImpl.getEmployees();
		
		
		return allEmployee;
	}
	
	
	
}
