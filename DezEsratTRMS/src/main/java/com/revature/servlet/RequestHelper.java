package com.revature.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.revature.controller.EmpLoginController;
import com.revature.controller.EmpRegisterController;
import com.revature.controller.EmployeeController;
import com.revature.controller.FormController;
import com.revature.controller.HomeController;

public class RequestHelper {
	
	public static String process(HttpServletRequest req) throws  JsonMappingException, IOException {
		System.out.println(req.getRequestURI()); //URI= what resource am I going to 
		
		switch(req.getRequestURI()) {
		case "/DezEsratTRMS/register.employee":
			System.out.println("in employee register rhelper");
			return EmpRegisterController.employeeRegister(req);
			
		case "/DezEsratTRMS/login.employee":
			System.out.println("in employee login rhelper");
			return EmpLoginController.login(req); //login method in my login controller
			
		case "/DezEsratTRMS/reqhome.employee":
			System.out.println("in requester home rhelper");
			return HomeController.requesterHome(req);	
			
		case "/DezEsratTRMS/home.employee":
			System.out.println("in employee home rhelper");
			return HomeController.employeeHome(req); //employeeHome method in my home controller
		
			
		case "/DezEsratTRMS/new.form":
			System.out.println("in employee form rhelper");
			return FormController.createNewForm(req);		
		
		case "/DezEsratTRMS/info.form":
			System.out.println("in employee form rhelper");
			return FormController.employeeForm(req);
			
		case "/DezEsratTRMS/update.form":
			System.out.println("in form form rhelper");
			return FormController.updateStatus(req);
		case "/DezEsratTRMS/deny.form":
			System.out.println("in form form rhelper");
			return FormController.denyStatus(req);
		
		default:
			System.out.println("in default case");
			return "resources/html/unsuccesslogin.html";
			
		}
		
		
		
		
	}
	
	

}
