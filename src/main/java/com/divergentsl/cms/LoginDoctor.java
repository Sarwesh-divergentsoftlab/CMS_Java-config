package com.divergentsl.cms;


import java.sql.SQLException;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.dao.LoginDao;



@Component
public class LoginDoctor {
	@Autowired
	LoginDao ldo;
	public String checkDoctor()
	{

		try {
			Scanner sc= new Scanner(System.in);
			
			
			 
			System.out.println("Enter your user name: ");  
		     String user=sc.next(); 
		    System.out.println("enter password"); 
		     String pass = sc.next();
		     boolean flag= ldo.doctorLogin(user,pass);
				
				if(flag)
				{
					System.out.print("Login successful");
					return user;
				
					
				}
		}
		catch(SQLException ex)
			{
				ex.printStackTrace();
			}
	return null;	
	}

}
