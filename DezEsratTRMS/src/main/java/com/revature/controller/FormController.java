package com.revature.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;
import com.revature.beans.Form;
import com.revature.daoImpl.EmployeeDaoImpl;
import com.revature.daoImpl.FormDaoImpl;
import com.revature.services.EmployeeService;
import com.revature.services.FormService;

public class FormController {
	static FormService fser=new FormService();
	static EmployeeService eser=new EmployeeService();
	
//	public static void getSessionForm(HttpServletRequest req,HttpServletResponse res) throws JsonProcessingException, IOException{
//		//create session for employee then later on i can use on javaScripts
//	
//	  Form f=(Form) req.getSession().getAttribute("currentForm");//
//	  res.getWriter().write(new ObjectMapper().writeValueAsString(f));// store variable emp
//	//write something inside the json as emp and add that to response.
//	}
	
	
	//I think we need create form , update form stuff(edited 12/7/2020)
	
	

	
	public static String employeeForm(HttpServletRequest req) {
		return "resources/html/form.html";		
	}
	public static String createNewForm(HttpServletRequest req ) {
		//String formID=req.getParameter("formID");
		//int empID = EmpLoginController.currentEmp.getEmpID();
        String eventDate = req.getParameter("eventDate");
        String reqDate = req.getParameter("reqDate");
        String location = req.getParameter("location");
        String reqAmount = req.getParameter("reqAmount");
        String eventDescription = req.getParameter("eventDescription");
        //String status = req.getParameter("status");
        String eventID = req.getParameter("eventID");
        String gradeID = req.getParameter("gradeID");
        String finalGrade = req.getParameter("finalGrade");

        Form f = new Form(1,1,eventDate, reqDate, location, Integer.parseInt(reqAmount), eventDescription, "pending",Integer.parseInt(eventID),Integer.parseInt(gradeID),Integer.parseInt(finalGrade));
        EmpLoginController.currentForm=f;
        System.out.println("In Form Controller" + f);
        fser.createNewForm(f);
        if(EmpLoginController.currentEmp.getEmpType()=="requester") {
        	return "home.requester";
		}
		return "home.employee";//redirect to home?)
       // return "empHome.html";  ///maybe we don't need recourse
    }
	
	
	
	
	

}
