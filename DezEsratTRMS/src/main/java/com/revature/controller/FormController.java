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
		int empID = EmpLoginController.currentEmp.getEmpID();
		System.out.println(empID);
        String eventDate = req.getParameter("eventDate");
        System.out.println(eventDate);
        String reqDate = req.getParameter("reqDate");
        System.out.println(reqDate);
        String location = req.getParameter("location");
        System.out.println(location);
        int reqAmount = Integer.parseInt(req.getParameter("reqAmount"));
        System.out.println(reqAmount);
        String eventDescription = req.getParameter("eventDescription");
        System.out.println(eventDescription);
        //String status = req.getParameter("status");
        int eventID = Integer.parseInt(req.getParameter("eventID"));
        System.out.println(eventID);
       int gradeID = Integer.parseInt(req.getParameter("gradeID"));
       System.out.println(gradeID);
       int  finalGrade =Integer.parseInt(req.getParameter("finalGrade"));
       System.out.println(finalGrade);

        Form f = new Form(1, empID, eventDate, reqDate, location, reqAmount, eventDescription, "pending",eventID,gradeID,finalGrade);
        EmpLoginController.currentForm=f;
        System.out.println("In Form Controller" + f);
        fser.createNewForm(f);
        if(EmpLoginController.currentEmp.getEmpType().equals("requester")) {
        	return "resources/html/requesterHome.html";
		}else {
//			if(EmpLoginController.currentEmp.getEmpType().equals("BenCo")) {
//				EmpLoginController.fList=fser.getByStatus("Approved By DepartmentHead");
//				return "resources/html/empHome.html";
//			}
//			if(EmpLoginController.currentEmp.getEmpType().equals("DepartmentHead")) {
//				EmpLoginController.fList=fser.getByStatus("Approved By DirectSuoervisor");
//				return "resources/html/empHome.html";
//			}
//			if(EmpLoginController.currentEmp.getEmpType().equals("DirectSuoervisor")) {
//				EmpLoginController.fList=fser.getByStatus("pending");
//				return "resources/html/empHome.html";
//			}
			return "resources/html/empHome.html";//redirect to home?)
		}
		
       // return "empHome.html";  ///maybe we don't need recourse
    }
	
//	public static String subFinalGrade(HttpServletRequest req) {
//		return "resources/html/submitGrade.html";		
//	}
	
	public static String updateStatus(HttpServletRequest req) {
		
		 
		
		if(EmpLoginController.currentEmp.getEmpType().equals("requester")) {
			int  finalGrade =Integer.parseInt(req.getParameter("finalGrade"));
			int formID=Integer.parseInt(req.getParameter("formID"));
			
			fser.updateFinalGrd(formID,finalGrade );
			fser.updateFormStatus(formID, "Awarded");
			
			return "resources/html/submitGrade.html";
			
		}else if(EmpLoginController.currentEmp.getEmpType().equals("BenCo")) {
			int formID=Integer.parseInt(req.getParameter("formID"));
			fser.updateFormStatus(formID, "Approved");
			
        	return "resources/html/requestApprove.html";
		}else if(EmpLoginController.currentEmp.getEmpType().equals("DirectSupervisor")) {
			int formID=Integer.parseInt(req.getParameter("formID"));
			fser.updateFormStatus(formID, "Approved By DirectSuoervisor");
		
        	return "resources/html/requestApprove.html";
		}else if(EmpLoginController.currentEmp.getEmpType().equals("DepartmentHead")) {
			int formID=Integer.parseInt(req.getParameter("formID"));
			fser.updateFormStatus(formID, "Approved By DepartmentHead");
		
        	return "resources/html/requestApprove.html";
		}
		
		return null;
		
		
	}
	
	public static String denyStatus(HttpServletRequest req) {
		int formID=Integer.parseInt(req.getParameter("formID"));
		fser.updateFormStatus(formID, "denied");
		return "resources/html/requestDeny.html";
		
		
	}
	

}
