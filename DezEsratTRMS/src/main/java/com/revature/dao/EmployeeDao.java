package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;

public interface EmployeeDao {
	
	public List<Employee> getAllEmployees() throws SQLException;
	
	//public void insertNewEmployee(Employee e) throws SQLException;
	public void insertNewEployee(String firstName, String lastName, String address, String email, String phone, String userName, String passWord, String empType) throws SQLException;
	
	public Employee getEmployeeById(int empId) throws SQLException;
	
	public Employee getEmployeeByUserName(String userName) throws SQLException;

}
