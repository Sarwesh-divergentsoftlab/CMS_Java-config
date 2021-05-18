package com.divergentsl.cms;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.dao.AppointmentDao;
import com.divergentsl.cms.dao.PatientDao;




@Component
public class Appointment  {
	
	ApplicationContext context;
	@Autowired
	Appointment appoint ;
	  
	@Autowired
	PatientDao patientDao ;
  
	@Autowired
	AppointmentDao appDao;
	
	public void listPatient(String dname)throws SQLException {

		Scanner sc= new Scanner (System.in);
			ResultSet rsretrive =patientDao.showPatient();
			
			
			while(rsretrive.next())
			{
				System.out.println(rsretrive.getString(1)+" "+rsretrive.getString(2)+" "+rsretrive.getString(3)+" "+rsretrive.getString(4)+" "+rsretrive.getString(5));
			}
			sc.close();
		
	}
	
	public void assignedAppointment(String dId)throws SQLException
	{
		Scanner sc= new Scanner (System.in);
		  	
			ResultSet rsretrive =appDao.showAssignedAppointment(dId);
			
			
			while(rsretrive.next())
			{
				System.out.println(rsretrive.getString(1)+" "+rsretrive.getString(2)+" "+rsretrive.getString(3)+" "+rsretrive.getString(4)+" "+rsretrive.getString(5));
			}
			sc.close();
	}
	
	public  void addPrescription() throws SQLException
	{
		 
		Scanner sc = new Scanner(System.in);
		System.out.println("enter patient id to prescribe");
		String pid=sc.next();
		System.out.print("type prescription for patient");
		String pres=sc.next();
		int rowinsert= appDao.addPrescription(pid,pres);
		
		if(rowinsert>0)
		{
			System.out.println("prescription added");
		}
		sc.close();
	}
	
	public  void patientHistory()throws SQLException
	{
		Scanner sc= new Scanner (System.in);
		System.out.print("enter patient id to see full description");
		String pId=sc.next();
			ResultSet rsretrive =appDao.patHistory(pId);
			
			
			while(rsretrive.next())
			{
				System.out.println(rsretrive.getString(1)+" "+rsretrive.getString(2)+" "+rsretrive.getString(3)+" "+rsretrive.getString(4)+" "+rsretrive.getString(5)+" "+rsretrive.getString(6)+" "+rsretrive.getString(7)+" "+rsretrive.getString(8)+" "+rsretrive.getString(9));
			}
			sc.close();
	}
	
	public  void addAppointment()
	{
		try {
		  
			Scanner sc=new Scanner(System.in);
		System.out.println("enter patient id");
		String pid = sc.next();
		System.out.println("enter doctor id");
		String did= sc.next();
		System.out.println("enter problem");
		String problem=sc.next();
		System.out.println("enter appointment date");
		String date=sc.next();
		System.out.println("enter time");
		String time=sc.next();
			
		int rowinsert= appDao.addAppointment(pid,did,problem,date,time);
		
		if(rowinsert>0)
		{
			System.out.println("Appointment added");
		}
		sc.close();
		}catch(SQLException se)
		{
			System.out.println("please enter unique appointment id");
			addAppointment();
		}
		
		}
		public void generateInvoice()throws SQLException
		{ 
			ResultSet rsretrive =appDao.invoice();
			while(rsretrive.next())
			{
				System.out.println(rsretrive.getString(1)+" "+rsretrive.getString(2)+" "+rsretrive.getString(3)+" "+rsretrive.getString(4)+" "+rsretrive.getString(5)+" "+rsretrive.getString(6)+" "+rsretrive.getString(7)+" "+rsretrive.getString(8)+" "+rsretrive.getString(9)+" "+rsretrive.getString(10)+" "+rsretrive.getString(11)+" "+rsretrive.getString(12)+" "+rsretrive.getString(13)+" \n\n");
			}
		}

}
