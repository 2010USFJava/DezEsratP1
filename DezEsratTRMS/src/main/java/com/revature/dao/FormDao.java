package com.revature.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Form;

public interface FormDao {
	
	
	public void createNewForm (Employee e,Date eventDate, Date reqDate, String location, int reqAmount, String eventDescription,String status,int eventID, int gradeID, int finalGrade) throws SQLException;
	
	public Form getFormByID(int formID) throws SQLException;
	
	public List<Form> getAllEmpForms(int empID) throws SQLException;
	
	

}
