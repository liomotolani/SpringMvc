/**
 * 
 */
package com.springDemo1.entitiesTest;

import static org.junit.Assert.*;

import java.util.logging.Logger;

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
}
