package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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
	
	//public static ConnFactory cf=ConnFactory.getInstance();
	static {
		try {
			Class.forName("org.postgresql.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	private String url="jdbc:postgresql://java2010usf.cr8wczxd9ies.us-east-2.rds.amazonaws.com:5432/postgres?currentSchema=trms";
	private  String username="esrat";
	private String password="esratjahan";

	@Override
	public void createNewForm(int empID, String eventDate, String reqDate, String location, int reqAmount,
			String eventDescription, String status, int eventID, int gradeID, int finalGrade) throws SQLException {
		//Connection conn=cf.getConnection();
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		String sql="insert into form values (DEFAULT, ?,?,?,?,?,?,?,?,?,?)";
		  PreparedStatement ps= conn.prepareStatement(sql);
		    ps.setInt(1, empID);
			ps.setString(2, eventDate);
			ps.setString(3, reqDate);
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
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		//Connection conn=cf.getConnection();
		String sql="select * from form where \"formID\"=?";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setInt(1, formID);
		ResultSet rs=ps.executeQuery();
		Form f=null;
		while(rs.next()) {
			f=new Form(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11));
		}
		return f;
	}

	@Override
	public List<Form> getAllEmpForms(int empID) throws SQLException {
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		List<Form>fList=new ArrayList<Form>();
		//Connection conn=cf.getConnection();
		String sql="select * from form where \"empID\"=?";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setInt(1, empID);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			fList.add(new Form(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
			
		}
		
		return fList;
	}
		
		
	

	@Override
	public List<Form> getByStatus(String status) throws SQLException {
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		List<Form>fList=new ArrayList<Form>();
		//Connection conn=cf.getConnection();
		String sql="select * from form where \"status\"=?";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1, status);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			fList.add(new Form(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
			
		}
		
		return fList;
	}

	@Override
	public List<Form> updateStatus(Form f, String newStatus) throws SQLException {
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		ArrayList<Form> fList = new ArrayList<Form>();
        //Connection conn = cf.getConnection();
        String sql="UPDATE Form SET \"status\"=? WHERE \"formID\" = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, newStatus);
        ps.setInt(2, f.getFormID());
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            fList.add(new Form(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getInt(10),rs.getInt(11)));
			
		}
		
		return fList;
	}

	@Override
	public void updateFormStatus(int formID, String newStatus) throws SQLException {
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		 //Connection conn = cf.getConnection();
	        String sql= "UPDATE Form SET \"status\"=? WHERE \"formID\" = ?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, newStatus);
	        ps.setInt(2, formID);
	        ps.executeUpdate();

	       
		}
	

	@Override
	public void updateReqAmt(int formID, int newReqAmt) throws SQLException {
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		//Connection conn = cf.getConnection();
        String sql= "UPDATE Form SET \"reqAmount\"=? WHERE \"formID\" = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, newReqAmt);
        ps.setInt(2, formID);
        ps.executeQuery();
       
	}

	@Override
	public void updateFinalGrd(int formID, int newFinalGrade) throws SQLException {
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		//Connection conn = cf.getConnection();
        String sql= "UPDATE Form SET \"finalGrade\"=? WHERE \"formID\" = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, newFinalGrade);
        ps.setInt(2, formID);
        ps.executeQuery();
		
	}

	
	
}
