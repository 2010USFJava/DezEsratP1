package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;

public class EmployeeController {
	
	
	public static void getSessionEmployee(HttpServletRequest req,HttpServletResponse res) throws JsonProcessingException, IOException{
		//create session for employee then later on i can use on javaScripts
	
	  Employee emp=(Employee) req.getSession().getAttribute("currentEmployee");//
	  res.getWriter().write(new ObjectMapper().writeValueAsString(emp));// store variable emp
	//write something inside the json as emp and add that to response.
	}
	
	public static void logoutSession(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		 HttpSession session = req.getSession();
		
	      session.invalidate(); 
		 
	      session = req.getSession(false);
	
	        System.out.println("Session : " + session);
	        if (session == null ) {
	            res.sendRedirect("login.employee");
	        }
	}
}



