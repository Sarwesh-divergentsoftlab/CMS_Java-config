package com.divergentsl.cms;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Home {
	@Autowired
	AnnotationConfigApplicationContext context;
	@Autowired
	LoginDoctor ldo;
	@Autowired
	LoginAdmin lao;
	@Autowired
	Doctor d;
		public void home()throws Exception
		{
			System.out.println("-----Welcome to clinic management system-----");
			Scanner sc= new Scanner (System.in);
			System.out.println("press 1 : Admin");
			System.out.println("Press 2 : Doctor");
			String n =sc.next();
			
			
			
			switch(n)
			{
			case "1":
				lao.checkAdmin();
				//LoginAdmin a=(LoginAdmin)context.getBean("loginAdmin");
				//a.checkAdmin();
				
				break;
			case "2":
				//LoginDoctor d=(LoginDoctor)context.getBean("loginDoctor");
				String nameId= ldo.checkDoctor();
				
				if(nameId==null)
				{
					System.out.println("invalid password\n try again\n");
				}
				else d.doctorPanel(nameId);
				break;
			default:
				System.out.print("enter valid input\n");
			
			}
			sc.close();
			
		}



	}

