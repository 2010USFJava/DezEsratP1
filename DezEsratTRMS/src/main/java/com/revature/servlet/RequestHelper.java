package com.revature.servlet;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.EmpLoginController;

import com.revature.controller.EmployeeController;
import com.revature.controller.FormController;
import com.revature.controller.HomeController;

public class RequestHelper {
	
	public static String process(HttpServletRequest req) {
		System.out.println(req.getRequestURI()); //URI= what resource am I going to 
		
		switch(req.getRequestURI()) {
		case "/DezEsratTRMS/login.employee":
			System.out.println("in employee login rhelper");
			return EmpLoginController.login(req); //login method in my login controller
			
		case "/DezEsratTRMS/home.employee":
			System.out.println("in employee home rhelper");
			return HomeController.employeeHome(req); //employeeHome method in my home controller
		case "/DezEsratTRMS/home.requester":
			System.out.println("in requester home rhelper");
			return HomeController.requesterHome(req);	
			
		case "/DezEsratTRMS/new.form":
			System.out.println("in employee form rhelper");
			return FormController.createNewForm(req);		
		
		case "/DezEsratTRMS/info.form":
			System.out.println("in employee form rhelper");
			return FormController.employeeForm(req);
		
		default:
			System.out.println("in default case");
			return "resources/html/unsuccesslogin.html";
			
		}
		
		
		
		
	}
	
	

}
