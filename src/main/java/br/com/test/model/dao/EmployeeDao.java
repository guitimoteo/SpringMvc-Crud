package br.com.test.model.dao;

import java.util.List;

import br.com.test.model.beans.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee e);
	public void updateEmployee(Employee e);
	public List<Employee> listEmployees();
	public void delete(int id);
	public Employee findById(int id);
	
	
}
