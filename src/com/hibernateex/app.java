package com.hibernateex;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class app {
	
	//private static SessionFactory factory;
	
	public static void main(String[] args) {
		

		ManageEmployee ME = new ManageEmployee();
		//Employee em1=new Employee(null,"nam",null , 0);
		Employee em1=new Employee();
		em1.setFirstName("tri");
		em1.setLastName("tri nguyen cao 2");
		em1.setSalary(467);
		em1.setId(6);
		
		
		
		ME.update(em1);
		//ME.delete(em1);
		//ME.listEmployees();
		//ME.getUserByID(5);

		 //ME.listEmployees();
		//ME.deleteUser(1);
		//ME.addUser("tri123", "nguyen", 300);
		//ME.updateUser(3, "nam123", "tran", 700);
		
		
		try
		  {
			ME.listEmployees();
		  }
		   catch(Exception ex)
		  {
		   ex.printStackTrace(System.out);
		  }
	}

}
