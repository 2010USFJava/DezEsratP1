package com.revature.daoImpl;

import java.sql.Connection;
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
	
	public static ConnFactory cf=ConnFactory.getInstance();
	
	

	@Override
	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee>eList=new ArrayList<Employee>();
		Connection conn=cf.getConnection();
		String sql="select * from employee";
		PreparedStatement ps= conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		while (rs.next()) {
			eList.add(new Employee(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));
			
		}
		
		return eList;
	}

//	@Override
//	public void insertNewEmployee(Employee e) throws SQLException {
//		Connection conn=cf.getConnection();
//		String sql="insert into employee values(DEFAULT,?,?,?,?,?,?,?,?)";
//		PreparedStatement ps= conn.prepareStatement(sql);
//		//ps.setInt(1, e.getEmpID());
//		ps.setString(1, e.getFirstName());
//		ps.setString(2, e.getLastName());
//		ps.setString(3, e.getAddress());
//		ps.setString(4, e.getEmail());
//		ps.setString(5, e.getPhone());
//		ps.setString(6, e.getUserName());
//		ps.setString(7, e.getPassWord());
//		ps.setString(8, e.getEmpType());
//		ps.executeUpdate();
//		//LogThis.LogIt("info", "New Employee added to database for: " + e.getFirstName() +" "+ e.getLastName() );
//		
//	}

	@Override
	public Employee getEmployeeById(int empId) throws SQLException {
		Connection conn=cf.getConnection();
		String sql="select * from Employee where 'empID'=?";
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
		//String uName="";
		Connection conn=cf.getConnection();
		String sql = "select * from employee where 'userName'=?";
		PreparedStatement ps= conn.prepareCall(sql);
		ps.setString(1, userName);
		ResultSet rs = ps.executeQuery();
		Employee em = null;
		while(rs.next()) {
			
		   //uName=(rs.getString(7));
			em = new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9));
		}
		
		return em;
	}

	@Override
	public void insertNewEployee(String firstName, String lastName, String address, String email, String phone,
			String userName, String passWord, String empType) throws SQLException{
		
		Connection conn=cf.getConnection();
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
		//LogThis.LogIt("info", "New Employee added to database for: " + firstName +" "+ lastName );
		
	}
	
	
	
	
	

}
