package view_controller;

import java.sql.*;

public class Driver {
	
	 public static void main(String[] args) {
		 
	 }

	
		public static Connection getConnection(){
			Connection con=null;
			try{
				//Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/network_manager","root","");
			}catch(Exception e){System.out.println(e);
			
			
			}
			return con;
		

	}

}