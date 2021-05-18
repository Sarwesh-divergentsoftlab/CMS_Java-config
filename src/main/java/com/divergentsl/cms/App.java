package com.divergentsl.cms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{	
	public static void main(String args[]) throws Exception
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Home h = context.getBean(Home.class);
		h.home();
	}	
	
}


