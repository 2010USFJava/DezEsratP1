package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.Form;
import com.revature.dao.FormDao;
import com.revature.daoImpl.FormDaoImpl;

public class FormService {
	
	
	FormDao fdao=new FormDaoImpl();
	Employee e= new Employee();
	
	public Form  getFormByID(int formID) {
		try {
			
			return fdao.getFormByID(formID);
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public void createNewForm( Form f) {
		try {
			fdao.createNewForm(f.getEmpID(), f.getEventDate(), f.getReqDate(), f.getLocation(), f.getReqAmount(), f.getEventDescription(), f.getStatus(), f.getEventID(), f.getGradeID(), f.getFinalGrade());
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public List<Form>getAllEmpForms(int empID){
		List<Form>fList=new ArrayList<Form>();
		try {
			fList=fdao.getAllEmpForms(empID);
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return fList; 
	}
	
 public List<Form>getByStatus(String status){
			List<Form>fList=new ArrayList<Form>();
			//List<Form>pendingList=null;
			
			try {
//				if(status.equals("pending")) {
//					fList=fdao.getByStatus("pending");
//					}
//				if(status.equals("Approved By DirectSuoervisor")) {
//					fList=fdao.getByStatus("Approved By DirectSuoervisor");
//					}
//				if(status.equals("Approved By DepartmentHead")) {
//					fList=fdao.getByStatus("Approved By DepartmentHead");
//					}
				
				fList=fdao.getByStatus(status);
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return fList; 
  }

    public List<Form>getAllFormByEmpType(String empType){
    	List<Form> fStList=new ArrayList<Form>();
    	try {
			if (empType.equals("BenCo")) {
				fStList = fdao.getByStatus("Approved By DepartmentHead");
			}
			if (empType.equals("DepartmentHead") && empType.equals("BenCo")) {
				fStList = fdao.getByStatus("Approved By DirectSupervisor");
			}
			if (empType.equals("DirectSupervisor")) {
				fStList = fdao.getByStatus("pending");
			}
    	} catch (SQLException e) {
			e.printStackTrace();
		}
    	return fStList;
    }
		
	
	public void updateFormStatus(int formID, String newStatus) {
		
		
		try {
			fdao.updateFormStatus(formID, newStatus);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateReqAmt(int formID, int newReqAmt) {
		

		try {
			fdao.updateReqAmt(formID, newReqAmt);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void updateFinalGrd(int formID, int newFinalGrade) {
		
		try {
			fdao.updateFinalGrd(formID, newFinalGrade);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
		
		
		
		
	}


