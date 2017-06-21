package br.com.test.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.test.model.beans.Employee;
import br.com.test.model.service.EmployeeService;

@Controller
@EnableTransactionManagement
//@RequestMapping(path="Employee")
public class EmployeeController {

	
	EmployeeService employeeService;
	
	@Autowired(required = true)
	@Qualifier(value="employeeService")
	public void setEmployeeService(EmployeeService ps){
		this.employeeService = ps;
	}
	
	@RequestMapping(value="/add", method =RequestMethod.POST)
	public String add(@ModelAttribute("employee") Employee e) {
		
		if(e == null)
			throw new NullPointerException();
		System.out.println(e.getName());
		if(e.getId()==0){
			this.employeeService.addEmployee(e);
			}
		else{
			this.employeeService.updateEmployee(e);
			}
		return "redirect:/list";

	}

	@RequestMapping(value="edit/{id}")
	public String edit(@PathVariable("id") int id, Model model) {
		model.addAttribute("employee", this.employeeService.getEmployeeById(id));
		model.addAttribute("listEmployees", this.employeeService.listEmployees());
		System.out.println("edit name employee: " + this.employeeService.getEmployeeById(id).getName());
		return "employee";
	}

	@RequestMapping(method=RequestMethod.GET, value="/list")
	public String list(Model model) {
		model.addAttribute("employee", new Employee());
		model.addAttribute("listEmployees", this.employeeService.listEmployees());
		return "employee";
	}

	@RequestMapping( value="/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		this.employeeService.delete(id);
		return "redirect:/list";
	}

}
