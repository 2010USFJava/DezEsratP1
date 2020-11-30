package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.daoImpl.EmployeeDaoImpl;

public class EmployeeService {
	
	EmployeeDao empDao= new EmployeeDaoImpl();
	
	public boolean loginVerify(String userName, String passWord) {
		List<Employee> eList = new ArrayList<Employee>();
		try {
			eList = empDao.getAllEmployees();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		boolean verify=false;
		for(Employee e: eList) {
			if(e.getUserName().equals(userName) && e.getPassWord().equals(passWord)) {
				verify=true;
			}
			
		}
		
		return verify;
	}
	
	
	
	
  public Employee logGetEmp(String userName, String passWord) {
		
		if(loginVerify(userName, passWord)) {
			try {
				
				return empDao.getEmployeeByUserName(userName);
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		return null;
 }

   public void insertNewEployee(Employee em) {
	   try {
			empDao.insertNewEployee(em.getFirstName(), em.getLastName(), em.getAddress(), em.getEmail(), em.getPhone(),em.getUserName(), em.getPassWord(),em.getEmpType());
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	   
   }



}