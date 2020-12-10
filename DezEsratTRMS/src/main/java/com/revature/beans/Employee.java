package com.revature.beans;

public class Employee {
	private int empID;
	private String firstName;
	private String lastName;
	private String address;
	private String email;
	private String phone;
	private String userName;
	private String passWord;
	private String empType;
	
	public Employee() {
		
	}
	public Employee( String firstName, String lastName, String address, String email, String phone,
			String userName, String passWord, String empType) {
		super();
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.userName = userName;
		this.passWord = passWord;
		this.empType = empType;
	}


	public Employee(int empID, String firstName, String lastName, String address, String email, String phone,
			String userName, String passWord, String empType) {
		super();
		this.empID = empID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.userName = userName;
		this.passWord = passWord;
		this.empType = empType;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	@Override
	public String toString() {
		return "Employee [empID=" + empID + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + ", email=" + email + ", phone=" + phone + ", userName=" + userName + ", passWord="
				+ passWord + ", empType=" + empType + "]";
	}
	
	

}
