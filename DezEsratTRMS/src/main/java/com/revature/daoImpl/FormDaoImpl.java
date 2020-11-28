package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.beans.Employee;
import com.revature.beans.Form;
import com.revature.dao.FormDao;
import com.revature.util.ConnFactory;

public class FormDaoImpl implements FormDao{
	
	public static ConnFactory cf=ConnFactory.getInstance();

	@Override
	public void createNewForm(Employee e, Date eventDate, Date reqDate, String location, int reqAmount,
			String eventDescription, String status, int eventID, int gradeID, int finalGrade) throws SQLException {
		Connection conn=cf.getConnection();
		String sql="insert into form values (DEFUALT, ?,?,?,?,?,?,?,?,?,?,)";
		  PreparedStatement ps= conn.prepareStatement(sql);
		    ps.setInt(1, e.getEmpID());
			ps.setDate(2, eventDate);
			ps.setDate(3, reqDate);
			ps.setString(4, location);
			ps.setInt(5, reqAmount);
			ps.setString(6, eventDescription);
			ps.setString(7, status);
			ps.setInt(8, eventID);
			ps.setInt(9, gradeID);
			ps.setInt(10, finalGrade);
			ps.executeUpdate();
		
		
		
		
		
		
		
	}

	@Override
	public Form getFormByID(int formID) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
