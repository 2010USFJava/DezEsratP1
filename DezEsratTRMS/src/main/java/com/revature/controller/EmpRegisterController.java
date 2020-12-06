package com.revature.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.revature.beans.Employee;
import com.revature.daoImpl.EmployeeDaoImpl;

public class EmpRegisterController {
	
	
	public static String employeeRegister(HttpServletRequest req) {
		
		if (req.getMethod().equals("GET")) {
		     return "resources/html/register.html";
		}
		String empID = req.getParameter("empID");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String address = req.getParameter("address");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        String empType = req.getParameter("empType");


        Employee emp = new Employee(Integer.parseInt(empID), firstName, lastName, address, email, phone, userName, passWord, empType);
        System.out.println("In Register Controller" + emp);
        EmployeeDaoImpl edi = new EmployeeDaoImpl();
        System.out.println("REGISTER CONTROLLER" + emp);
        try {
			edi.insertNewEployee(firstName, lastName, address, email, phone, userName, passWord, empType);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
        return "/html/Login.html";
		
	
	
	
  }
}
