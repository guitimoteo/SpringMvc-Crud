package br.com.test.model.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table(name="Employees")
@Entity
@Component
public class Employee {

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int id;
private String name; 
private String designation;
private float salary;
/**
 * @return the id
 */
public int getId() {
	return id;
}
/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the designation
 */
public String getDesignation() {
	return designation;
}
/**
 * @param designation the designation to set
 */
public void setDesignation(String designation) {
	this.designation = designation;
}
/**
 * @return the salary
 */
public float getSalary() {
	return salary;
}
/**
 * @param salary the salary to set
 */
public void setSalary(float salary) {
	this.salary = salary;
}

}
