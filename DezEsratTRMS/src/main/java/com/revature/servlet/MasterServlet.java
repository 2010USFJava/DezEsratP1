package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MasterServlet extends HttpServlet {
	

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("in doGet");
		req.getRequestDispatcher(RequestHelper.process(req)).forward(req,res); //.process is another method in request helper
		//it will go request dispatcher ...
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("in doPost");
		//req.getRequestDispatcher(RequestHelper.process(req)).forward(req,res);
		
		
		  //will directed you which or where to go
		//if it is multiple login like employee BanCo ,how it should be work?????
		System.out.println("URI: " + req.getRequestURI());
		String nextServlet = "";
		
		if(req.getRequestURI().contains("employee")) {
			nextServlet = "login.employee";			
		
		} 
		System.out.println("Next servlet: " + nextServlet);
		RequestDispatcher rd = req.getRequestDispatcher(nextServlet);
		rd.forward(req, res);
	}
}
