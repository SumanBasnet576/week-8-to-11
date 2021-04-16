package view_controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import view_controller.Driver;

public class UserDAO {
	
	
	public static ResultSet login(String username,String password){
		ResultSet status=null;
		try{
			Connection con=Driver.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			status=ps.executeQuery();
			con.close();
			return status;
			
		}catch(Exception e){System.out.println(e);}
		
		return null;
		
	}
	
	
	public static int register(String username,String password,String full_name,String email){
		int status=0;
		try{
			Connection con=Driver.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into user(username,password,full_name,email) values(?,?,?,?)");
			ps.setString(1,username);
			ps.setString(2,password);
			ps.setString(3,full_name);
			ps.setString(4,email);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}
