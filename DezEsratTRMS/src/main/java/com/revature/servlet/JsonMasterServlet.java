package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonMasterServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 755532680551401594L;
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("This is Json Master doGet");
		JsonRequestHelper.process(req,res);
		
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		System.out.println("This is Json Master doPost");
		JsonRequestHelper.process(req,res);
		
	}

}
