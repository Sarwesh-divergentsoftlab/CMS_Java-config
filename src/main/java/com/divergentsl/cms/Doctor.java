package com.divergentsl.cms;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Doctor {
		
	@Autowired	
	  ApplicationContext context;
	@Autowired  
	LoginDoctor ldo;
	    
	@Autowired
	Appointment appointment;

	public void doctorPanel(String dname) throws SQLException {
		
		
		Scanner sc=new Scanner(System.in);
		 System.out.println("\n----Login as : " + dname + "----");
		    System.out.println("----Doctor Panel----");
		    System.out.println("1. List of patients");
		    System.out.println("2. Add prescription and notes for a patient");
		    System.out.println("3. See booked appointments for him");
		    System.out.println("4. Check patient history and his prescription");
		    System.out.println("5. Create Invoice of patient");
		    System.out.println("6. Logout");
		    System.out.println("	Enter Your Choice: \n");
		    String choice=sc.next();
		  
		  
		    switch(choice)
		    {
		    case "1":
		    	appointment.listPatient(dname);
		    	break;
		    
		    case "2":
		    	appointment.addPrescription();
		    	break;
		    case "3":
		    	appointment.assignedAppointment(dname);
		    	break;
		    case "4":
		    	appointment.patientHistory();
		    	break;
		    case "5":
		    	appointment.generateInvoice();
		    	break;
		    case "6":
		    	
		    	System.out.println("\nlogout successful\n");
		    	ldo.checkDoctor();
		    	break;
		    	
		    default:
		    	System.out.print("enter valid input\n");
		    	doctorPanel(dname);
		    }
	sc.close();
	} 

}
