package view_controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DeviceDAO {
	
	public static int saveDevice(String port,String device_name,String device_type){
		int status2=0;
		try{
			Connection con=Driver.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into device(port,product_name,product_type) values(?,?,?)");
			ps.setString(1,port);
			ps.setString(2,device_name);
			ps.setString(3,device_type);
			
			status2=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status2;
	}

	public static int update(String port,String device_name,String device_type,int id){
		int status2=0;
		try{
			Connection con=Driver.getConnection();
			PreparedStatement ps=con.prepareStatement("update device set port=?, product_name=?, product_type=? where id=?");
			ps.setString(1,port);
			ps.setString(2,device_name);
			ps.setString(3,device_type);
			ps.setInt(4,id);
			
			status2=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status2;
	}
	
	public static int delete(int id){
		int status2=0;
		try{
			Connection con=Driver.getConnection();
			PreparedStatement ps=con.prepareStatement("delete device where id=?");
			
			ps.setInt(1,id);
			
			status2=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status2;
	}

	
	

}
