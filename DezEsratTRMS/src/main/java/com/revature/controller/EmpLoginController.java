package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.beans.Employee;
import com.revature.services.EmployeeService;

public class EmpLoginController {
	
	static EmployeeService eServ= new EmployeeService();
	
	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {//no one can directly get our html resours page it will check equals method 
			return "resources/html/index.html";// if it is not equals to post method it will redirect to login page
		}
		
		String userName=req.getParameter("userName");
		String passWord=req.getParameter("passWord");
		System.out.println("usaeName :" +userName+"PassWord: " + passWord);
		Employee emp=eServ.logGetEmp(userName, passWord);
		if(emp==null) {
			return "invalid.employee";
		}else {
			
			req.getSession().setAttribute("currentEmp", emp);
			
			return "home.employee";
		}
		
		

}
}
