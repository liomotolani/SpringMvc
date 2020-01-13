/**
 * 
 */
package com.springDemo1.dao;

import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springDemo1.entities.Employee;

/**
 * @author Omotolani
 *
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Logger logger = Logger.getLogger(EmployeeDaoImpl.class.getName());
	
	
	@Transactional 
//	It starts the transaction and commit the transaction
	public void addEmployee(Employee employee) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		logger.info("Saving employee to the database" +  employee.toString());
		currentSession.save(employee);
		
	}
}
