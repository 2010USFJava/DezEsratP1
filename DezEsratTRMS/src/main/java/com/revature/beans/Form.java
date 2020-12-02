package com.revature.beans;



public class Form {
	private int formID;
	private int empID;
	private String eventDate; 
	private String reqDate;
	private String location;
	private int reqAmount;
	private String eventDescription;
	private String status;
	private int eventID;
	private int gradeID;
	private int finalGrade;
	
	public Form() {
		
	}
//	public Form(int formID, int empID,String eventDate,String reqDate,String location,int reqAmount,String eventDescription,
//			int eventID, int gradeID, int finalGrade) {
//		
//		
//		
//		
//	}


	public Form(int formID, int empID, String eventDate, String reqDate, String location, int reqAmount,
			String eventDescription, String status, int eventID, int gradeID, int finalGrade) {
		super();
		this.formID = formID;
		this.empID = empID;
		this.eventDate = eventDate;
		this.reqDate = reqDate;
		this.location = location;
		this.reqAmount = reqAmount;
		this.eventDescription = eventDescription;
		this.status = status;
		this.eventID = eventID;
		this.gradeID = gradeID;
		this.finalGrade = finalGrade;
	}
	
	
	public int getFormID() {
		return formID;
	}

	public void setFormID(int formID) {
		this.formID = formID;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getReqDate() {
		return reqDate;
	}

	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getReqAmount() {
		return reqAmount;
	}

	public void setReqAmount(int reqAmount) {
		this.reqAmount = reqAmount;
	}

	public String getEventDescription() {
		return eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEventID() {
		return eventID;
	}

	public void setEventID(int eventID) {
		this.eventID = eventID;
	}

	public int getGradeID() {
		return gradeID;
	}

	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}

	public int getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(int finalGrade) {
		this.finalGrade = finalGrade;
	}

	@Override
	public String toString() {
		return "Form [formID=" + formID + ", empID=" + empID + ", eventDate=" + eventDate + ", reqDate=" + reqDate
				+ ", location=" + location + ", reqAmount=" + reqAmount + ", eventDescription=" + eventDescription
				+ ", status=" + status + ", eventID=" + eventID + ", gradeID=" + gradeID + ", finalGrade=" + finalGrade
				+ "]";
	}

	
	

	
	
	

}
