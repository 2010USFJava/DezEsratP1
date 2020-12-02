package com.revature.services;

import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.beans.Form;
import com.revature.dao.FormDao;
import com.revature.daoImpl.FormDaoImpl;

public class FormService {
	
	
	FormDao fdao=new FormDaoImpl();
	
	public Form  getFormByID(int formID) {
		try {
			
			return fdao.getFormByID(formID);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void createNewForm() {
		
		//work on that
	}
	
	
	
	
		
		
		
		
		
	}


