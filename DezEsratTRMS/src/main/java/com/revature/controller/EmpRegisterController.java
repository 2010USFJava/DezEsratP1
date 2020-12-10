package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.daoImpl.EmployeeDaoImpl;

public class EmpRegisterController {
	
	
	public static String employeeRegister(HttpServletRequest req) throws JsonParseException, JsonMappingException, IOException {
		
	if (!req.getMethod().equals("POST")) {
	     return "resources/html/register.html";
		}
//		String empID = req.getParameter("empID");
//        String firstName = req.getParameter("firstName");
//        String lastName = req.getParameter("lastName");
//        String address = req.getParameter("address");
//        String email = req.getParameter("email");
//        String phone = req.getParameter("phone");
//        String userName = req.getParameter("username");
//        String passWord = req.getParameter("password");
//        String empType = req.getParameter("empType");


		Employee emp=null;
	        ObjectMapper mapper= new ObjectMapper();
	        
	       emp= mapper.readValue(req.getInputStream(),Employee.class);
	        System.out.println(emp);
	       EmployeeDaoImpl edi= new EmployeeDaoImpl();
	        try {
	            edi.insertNewEployee(emp.getFirstName(), emp.getLastName(), emp.getAddress(), emp.getEmail(), emp.getPhone(), emp.getUserName(), emp.getPassWord(), emp.getEmpType());
	         
	        } catch (SQLException e) {
	           
	            e.printStackTrace();
	        }
        
        //return "/html/Login.html";
        return "resources/html/register.html";
		
	
	
	
  }
}
