package com.revature.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;

public class EmployeeController {
	
	
	public static void getSessionEmployee(HttpServletRequest req,HttpServletResponse res) throws JsonProcessingException, IOException{
		//create session for employee 
	
	Employee emp=(Employee) req.getSession().getAttribute("currentEmployee");//
	res.getWriter().write(new ObjectMapper().writeValueAsString(emp));// store variable emp
	//write something inside the json as emp and add that to response.
	}

}
