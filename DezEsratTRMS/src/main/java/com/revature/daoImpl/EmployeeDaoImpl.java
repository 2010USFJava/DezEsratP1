package com.revature.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDao;
import com.revature.util.ConnFactory;
import com.revature.util.LogThis;

public class EmployeeDaoImpl implements EmployeeDao{
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
	
	//public static ConnFactory cf = ConnFactory.getInstance();
	
	//public static ConnFactory cf=ConnFactory.getInstance();
	
	

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		List<Employee>eList=new ArrayList<Employee>();
		//Connection conn=cf.getConnection();
		
		String sql="select * from employee";
		PreparedStatement ps= conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			eList.add(new Employee(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
			
		}
		
		return eList;
	}



	@Override
	public Employee getEmployeeById(int empId) throws SQLException {
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		//Connection conn=cf.getConnection();
		String sql="select * from Employee where \"empID\" = ?";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setInt(1, empId);
		ResultSet rs=ps.executeQuery();
		Employee em=null;
		while(rs.next()) {
			
			em=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
		}
		
		return em;
	}

	@Override
	public Employee getEmployeeByUserName(String userName) throws SQLException {
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		//Connection conn=cf.getConnection();
		String sql = "select * from employee where \"userName\"=?";
		PreparedStatement ps= conn.prepareStatement(sql);
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		Employee em = null;
		while(rs.next()) {
			
		  
			em = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
		}
		
		return em;
	}
	
	
	

	@Override
	public void insertNewEployee(String firstName, String lastName, String address, String email, String phone,
			String userName, String passWord, String empType) throws SQLException{
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		//Connection conn=cf.getConnection();
		String sql="insert into employee values(DEFAULT,?,?,?,?,?,?,?,?)";
	    PreparedStatement ps= conn.prepareStatement(sql);
	    ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, address);
		ps.setString(4, email);
		ps.setString(5, phone);
		ps.setString(6, userName);
		ps.setString(7, passWord);
		ps.setString(8, empType);
		ps.executeUpdate();
		LogThis.LogIt("info", "New Employee added to database for: " + firstName +" "+ lastName );
		
	}



	@Override
	public Employee getEmployeeLogin(String passWord, String userName) throws SQLException {
		Connection conn = DriverManager.getConnection(this.url, this.username, this.password);
		//Connection conn=cf.getConnection();
		String sql = "select * from employee where \"passWord\"=? AND \"userName\"=?";
		PreparedStatement ps= conn.prepareCall(sql);
		ps.setString(1, passWord);
		ps.setString(2,userName);
		ResultSet rs = ps.executeQuery();
		Employee em = null;
		while(rs.next()) {
			
		  
			em = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
		}
		
		return em;
	}
	
	
	
	

}
