package br.com.test.model.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.test.model.beans.Employee;
import br.com.test.model.dao.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	EmployeeDao employeeDao;
	
	public void setEmployeeDao (EmployeeDao ed){
		this.employeeDao = ed;
	}
	@Override
	@Transactional
	public void addEmployee(Employee e){
		this.employeeDao.addEmployee(e);
	}
	@Override
	@Transactional
	public void updateEmployee(Employee e){
		this.employeeDao.updateEmployee(e);
	}
	@Override
	@Transactional
	public List<Employee> listEmployees(){
		return this.employeeDao.listEmployees();
	}
	@Override
	@Transactional
	public void delete(int id){
		this.employeeDao.delete(id);
	}
	@Override
	@Transactional
	public Employee getEmployeeById(int id) {
		System.out.println("getEmployeeById " + id);
		return this.employeeDao.findById(id);
	}
}
