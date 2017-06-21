/**
 * 
 */
package br.com.test.model.service;

import java.util.List;

import br.com.test.model.beans.Employee;

/**
 * @author guitimoteo
 *
 */
public interface EmployeeService {
	public void addEmployee(Employee e);
	public void updateEmployee(Employee e);
	public List<Employee> listEmployees();
	public void delete(int id);
	public Employee getEmployeeById(int id);
}
