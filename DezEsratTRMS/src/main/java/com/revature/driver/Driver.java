package com.revature.driver;



import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Form;
import com.revature.dao.EmployeeDao;
import com.revature.dao.FormDao;
import com.revature.daoImpl.EmployeeDaoImpl;
import com.revature.daoImpl.FormDaoImpl;

public class Driver {
	public static void main(String[] args) {
	
//	EmployeeDaoImpl emp=new EmployeeDaoImpl();
//	try {
//		emp.insertNewEployee("dez", "Ma", "NY", "email@", "645465", "dez123", "354", "emp");
//		
//		
//	}catch (SQLException e) {
//	e.printStackTrace();
//	}
	
	
//		EmployeeDao emp=new EmployeeDaoImpl();
//		
//		//Employee el=new Employee();
//		try {
//			Employee el=emp.getEmployeeById(5);
//		
//			System.out.println(el.toString());
//			}catch (SQLException e) {
//			e.printStackTrace();
//		}
//		EmployeeDaoImpl emp=new EmployeeDaoImpl();
//		
//		try {
//			
//			List<Employee> eList = (ArrayList<Employee>) emp.getAllEmployees();
//			System.out.println(eList.toString());
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		EmployeeDao emp=new EmployeeDaoImpl();
//		Employee el=new Employee();
//		try { el = emp.getEmployeeByUserName("dez01");
//		
//			System.out.println(el.toString());
//			}catch (SQLException e) {
//			e.printStackTrace();
//		}
//	   EmployeeDao ep= new EmployeeDaoImpl();
//	   Employee el=new Employee();
//	   try {
//		  ep.getEmployeeByUserName("ej");
//		  System.out.println(el.toString());
//		   
//	   }catch (SQLException e) {
//			e.printStackTrace();
//		}
//		FormDao f = new FormDaoImpl();
//		Date eventdate =new Date(2020-11-29);
//		Date reqdate =new Date(2020-11-29);
//		Employee em=new Employee();
//		 
//		 try {
//			 f.createNewForm(em.setEmpID(1), eventdate, reqdate, "ny", 1000, "cours", "pass", 1, 1, 90);
//			 
//			 
//			 
//		 } catch (SQLException e) {
//				
//				e.printStackTrace();
//			}
//		
		
//		FormDaoImpl f = new FormDaoImpl();
//		try {
//			
//			f.createNewForm(3,"2020-12-20", "2020-12-01", "NY", 600, "Traning", "pending", 1, 1, 0);
//			
//		} catch (SQLException e) {
//		e.printStackTrace();
//		}
//		FormDaoImpl f = new FormDaoImpl();
//		try {
//			
//			f.createNewForm(6,"2020-12-30", "2020-12-01", "GA", 800, "course", "pending", 2, 2, 0);
//			
//		} catch (SQLException e) {
//		e.printStackTrace();
//		}
//		
	
//		FormDao fdao=new FormDaoImpl();
//		
//		//Employee el=new Employee();
//		try {
//			Form fo=fdao.getFormByID(3);
//		
//			System.out.println(fo.toString());
//			}catch (SQLException e) {
//			e.printStackTrace();
//		}
//	
		EmployeeDao emp=new EmployeeDaoImpl();
		Employee el=new Employee();
		try { el = emp.getEmployeeLogin("354", "abj123");
		
			System.out.println(el.toString());
			}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

  }

