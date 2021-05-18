package com.divergentsl.cms;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Admin {
	
	@Autowired
	CRUDdoctor doctor;
	
	@Autowired
	CRUDdrug drug;
	
	@Autowired 
	CRUDlabtest labtest;
	
	@Autowired
	CRUDpatient patient;
	
	@Autowired
	LoginAdmin login;
	
	@Autowired
	Appointment apoint;
	

	public void adminPanel() throws Exception {
		Scanner sc= new Scanner(System.in);
		try {
			System.out.println("welcome to admin panel");
		
		System.out.println("press 1 : doctor manager");
		System.out.println("press 2 : patient manager");
		System.out.println("press 3 : drug manager");
		System.out.println("press 4 : labtest manager");
		System.out.println("press 5 : make appointment");
		System.out.println("press 6 : logout");
		String c=sc.next();
//		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
//		CRUDdoctor d = context.getBean(CRUDdoctor.class);
//		CRUDpatient p = context.getBean(CRUDpatient.class);
//		CRUDdrug r = context.getBean(CRUDdrug.class);
//		CRUDlabtest l = context.getBean(CRUDlabtest.class);
//		LoginAdmin login = context.getBean(LoginAdmin.class);
//		Appointment apoint = context.getBean(Appointment.class);
		
		switch(c)
		{
				case "1"://doctor manager
				 // CRUDdoctor.doctorDao();
				  doctor.doctorDao();
				  break;
					
					
					
		case "2": //patient manager
				//CRUDpatient.patientDao();
				patient.patientDao();
				break;
		
		case "3": //DRUG manager
				//CRUDdrug.drugDao();
				drug.drugDao();
				break;
			
				
				
				
		case "4": //labtest manager
				//CRUDlabtest.labtestDao();
				labtest.labtestDao();
				break;
			

		case "5"://appointment
			//Appointment.addAppointment();
			apoint.addAppointment();
				break;
		
		case "6"://logout
			//LoginAdmin.checkAdmin();
			login.checkAdmin();	
				default:
					System.out.print("Enter Valid choice");
					adminPanel();
					break;
				}
		}
		catch(SQLException ex)
		{
			ex.printStackTrace();
		}
		
		sc.close();
		
	}
}
 