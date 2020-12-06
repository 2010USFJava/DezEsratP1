package com.revature.dao;


import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Form;

public interface FormDao {
	
	
	public void createNewForm (int empID,String eventDate, String reqDate, String location, int reqAmount, String eventDescription,String status,int eventID, int gradeID, int finalGrade) throws SQLException;
	
	public Form getFormByID(int formID) throws SQLException;
	
	public List<Form>getAllEmpForms(int empID) throws SQLException;//to see employee form
	
	
	public List <Form>getByStatus(String status)throws SQLException;//BanCo,superviser will see by status 
	
	
	public List <Form> updateStatus(Form f, String newStatus) throws SQLException;
	
	public void updateFormStatus(int formID, String newStatus)throws SQLException;
	
	//update amount request amount 
	
	public void updateReqAmt(int formID, int newReqAmt) throws SQLException;
	
	public void updateFinalGrd(int formID, int newFinalGrade) throws SQLException;
	
	

}
