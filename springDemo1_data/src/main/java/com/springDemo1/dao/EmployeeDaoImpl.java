/**
 * 
 */
package com.springDemo1.dao;

import java.util.List;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
	
	@Transactional 
	public List<Employee> getEmployees(){
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		logger.info("Querying list of employees from the database");
		
		Query<Employee> theQuery = currentSession.createQuery("from Employee", Employee.class);
		
		List<Employee> employeeList = theQuery.getResultList();
		
		return employeeList;
	}
	
	@Transactional
	public Employee getEmployeeById(int id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Employee theEmployee = currentSession.get(Employee.class, id);
		
		return theEmployee;

		
	}
	
	
	@Transactional
	public void updateEmployee(Employee employee) {
		
		Session currentSession = sessionFactory.getCurrentSession();
			
		currentSession.update(employee);
			
		
	}
	
	
	@Transactional
	public void deleteEmployee(Employee employee) {
		
		Session currentSession = sessionFactory.getCurrentSession();
			
		currentSession.delete(employee);
			
		
	}
	
}
