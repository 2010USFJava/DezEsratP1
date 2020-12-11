package com.revature.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Form;
import com.revature.controller.EmpLoginController;
import com.revature.controller.EmployeeController;
import com.revature.controller.FormController;
import com.revature.controller.HomeController;
import com.revature.services.EmployeeService;
import com.revature.services.FormService;


public class JsonRequestHelper {
	static FormService fs=new FormService();
	static EmployeeService eServ= new EmployeeService();
	//static List<Form>fList=new ArrayList();
	
	public static void process(HttpServletRequest req, HttpServletResponse res) throws JsonProcessingException, IOException{
		switch(req.getRequestURI()) {
		case "/DezEsratTRMS/getsession.json":
			EmployeeController.getSessionEmployee(req, res);
			break;
			
		case "/DezEsratTRMS/empHome.json":   
			HomeController.employeeHome(req);
			
			//fs.getAllEmpForms(EmpLoginController.currentEmp.getEmpID());
			res.getWriter().write(new ObjectMapper().writeValueAsString(fs.getAllFormByEmpType(EmpLoginController.currentEmp.getEmpType())));

			break;
		case "/DezEsratTRMS/requesterHome.json":   
			HomeController.requesterHome(req);
		
			//fs.getByStatus(EmpLoginController.currentForm.getStatus());
			res.getWriter().write(new ObjectMapper().writeValueAsString(fs.getAllEmpForms(EmpLoginController.currentEmp.getEmpID())));

			break;	
		case "/DezEsratTRMS/logout.json":
			System.out.println("in logout json rhelper");
			EmployeeController.logoutSession(req, res);
			break;

			
		default:
//			SuperVillain vill = new SuperVillain("?","?", 0);
//			res.getWriter().write(new ObjectMapper().writeValueAsString(vill));
			System.out.println("This is default case");
		}
		
	}

	

}
