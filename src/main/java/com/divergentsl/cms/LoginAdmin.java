package com.divergentsl.cms;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import com.divergentsl.cms.dao.LoginDao;






@Component
public class LoginAdmin {
	
	
	
	@Autowired
	LoginDao loginDao;
	
	@Autowired
	Admin admin;
	
	public void checkAdmin() throws Exception { 

		try {
		//	Console c= System.console();
		//	if(c==null)
		//		System.err.print("c is null");
			Scanner sc= new Scanner (System.in);
		//	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
			//LoginDao loginDao = context.getBean(LoginDao.class);
			//LoginDao ado=new LoginDao(new DatabaseManager());
			 
			System.out.println("Enter your user name: ");  
		     String user=sc.next(); 
		    System.out.println("enter password"); 
		     String pass = sc.next();
			boolean flag=loginDao.adminLogin(user, pass);
			if(flag)
			{
					System.out.println("Login successful\n");
					admin.adminPanel();
			}
			if(!flag)
			{
				System.out.println("your password or username may be incorrect\n");
				
				checkAdmin();
			}
		sc.close();
		}
		catch(SQLException ex)
			{
				ex.printStackTrace();
			}
	}

}
