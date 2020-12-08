package com.revature.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.beans.Employee;
import com.revature.beans.Form;
import com.revature.services.EmployeeService;

public class EmpLoginController {
	
	static EmployeeService eServ= new EmployeeService();
	public static Employee currentEmp;
	public static Form currentForm;
	public static List<Form>fList=new ArrayList();
	
	
	public static String login(HttpServletRequest req) {
		if(!req.getMethod().equals("POST")) {//no one can directly get our html resours page it will check equals method 
			return "resources/html/login.html";// if it is not equals to post method it will redirect to login page
			//login is our lending page
		}
		
		String userName=req.getParameter("userName");
		String passWord=req.getParameter("passWord");
		System.out.println("userName :" +userName+"PassWord: " + passWord);
		Employee emp=eServ.logGetEmp(userName, passWord);
		if(emp==null) {
			return "invalid.employee";//redirect to invalid ?
		}else {
			//.employee is servlet end point ,Exp: <url-pattern>*.employee</url-pattern>
			currentEmp=emp;
			req.getSession().setAttribute("currentEmp", emp);
			if(emp.getEmpType()=="requester") {
				return "home.requester";
			}
			
			return "home.employee";//redirect to home?
			
		}
		
		

}
}
