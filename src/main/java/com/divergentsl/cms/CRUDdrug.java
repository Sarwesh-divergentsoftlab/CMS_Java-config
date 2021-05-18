package com.divergentsl.cms;

import java.sql.ResultSet;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.divergentsl.cms.dao.DrugDao;



@Component
public class CRUDdrug {
	
	@Autowired
	DrugDao drugDao;

	 	public void drugDao() throws Exception
	 	{

			Scanner sc=new Scanner (System.in);
			System.out.println("Enter your choice");
			System.out.println("press 1 : to add drug");
			System.out.println("press 2 : to see all drug list");
			System.out.println("press 3 : to update drug");
			String dchoice=sc.next() ;
				
				switch(dchoice)
				{
				case "1": //drug
						System.out.println("enter drug name");
						String name = sc.next();
						System.out.println("enter drug id");
						String drug_id= sc.next();
						System.out.println("enter drug price");
						String drug_price=sc.next();
						//DrugDao drugDao= new DrugDao(new DatabaseManager());		
						int rowinsert= drugDao.insertDrug(name,drug_id,drug_price);
						
						if(rowinsert>0)
						{
							System.out.println("new drug information added");
						}
						break;
				
				
				case "2": //retrive drug
						//drugDao= new DrugDao(new DatabaseManager());
						ResultSet rsretrive = drugDao.showDrug();
						while(rsretrive.next())
						{
							System.out.println(rsretrive.getString(1)+" "+rsretrive.getString(2)+" "+rsretrive.getString(3));
						}
						break;
						
				
				case "3": //update drug
						System.out.println("enter drug Id to update details");
						String id=sc.next();
						System.out.println("enter choice");
						System.out.println("press 1 : to update name");
						System.out.println("press 2 : to update drug price");
						
						String n=sc.next();
							switch(n)
							{
							case "1":
								
								System.out.println("enter updated name");
								String drugname=sc.next();
								//DrugDao drugDaon= new DrugDao(new DatabaseManager());
								int rowupdatename=drugDao.updatedrugName(drugname,id);
								if(rowupdatename>0) System.out.print("information updated");
								break;
							
							case "2":
								System.out.println("enter updated drug price");
								String price=sc.next();
								//drugDaon= new DrugDao(new DatabaseManager());
								int rowupdatespec=drugDao.updatedrugPrice(price, id);
								if(rowupdatespec>0) System.out.print("information updated");
								break;
							
							default:
								System.out.println("Enter Valid choice");
							}	
						
					
						
						break;
						
						
				default:
					System.out.print("Enter Valid choice");
				}
	
			sc.close();	
				
	 }
}
