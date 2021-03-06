package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		Connection conn=cf.getConnection();
		String sql="select * from form where ('formID')=?";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setInt(1, formID);
		ResultSet rs=ps.executeQuery();
		Form f=null;
		while(rs.next()) {
			f=new Form(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11));
		}
		return f;
	}

	@Override
	public List<Form> getAllEmpForms(int empID) throws SQLException {
		List<Form>fList=new ArrayList<Form>();
		Connection conn=cf.getConnection();
		String sql="select * from form";
		PreparedStatement ps= conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			fList.add(new Form(rs.getInt(1),rs.getInt(2),rs.getDate(3),rs.getDate(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
		}
		
		return fList;
	}

	
}
