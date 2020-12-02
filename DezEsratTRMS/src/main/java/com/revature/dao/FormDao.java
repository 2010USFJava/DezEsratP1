package com.revature.dao;

import java.sql.Date;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.beans.Form;

public interface FormDao {
	
	
	public void createNewForm (int empID,String eventDate, String reqDate, String location, int reqAmount, String eventDescription,String status,int eventID, int gradeID, int finalGrade) throws SQLException;
	
	public Form getFormByID(int formID) throws SQLException;
	
	

}
