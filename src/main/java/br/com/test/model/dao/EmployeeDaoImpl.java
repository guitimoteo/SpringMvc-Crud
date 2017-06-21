package br.com.test.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.test.model.beans.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private SessionFactory sessionFactory;
	
	
	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void addEmployee(Employee e) {
		Session session = sessionFactory.getCurrentSession();
		session.persist(e);
	}

	@Override
	public void updateEmployee(Employee e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(e);
		System.out.println("Person updated successfully, Person Details="+e.getName());
	}

	@Override
	public List<Employee> listEmployees() {
		Session session = sessionFactory.getCurrentSession();
		
		return session.createQuery("from Employee").list()	;
	}

	@Override
	public void delete(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee e = (Employee) session.load(Employee.class, new Integer(id));
		if(e != null)
			session.delete(e);
	}

	@Override
	public Employee findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Employee e = (Employee) session.load(Employee.class, new Integer(id));
		System.out.println("Employee loaded with success: " + e.getName());
		return e;
	}

}
