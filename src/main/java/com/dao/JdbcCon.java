package com.dao;

import java.sql.*;

import com.model.Register;

public class JdbcCon {
  
	    Connection con;
	    PreparedStatement ps;
	    
	    public Connection setupConnection() {
	    	
	    	
				try {
					Class.forName("oracle.jdbc.OracleDriver");
					con = DriverManager.getConnection("jdbc:oracle:thin:@infva07161:1521:xe","system","newuser123");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	    	return con;
	    }
	
	  public int saveData(Register reg) {
		  
		  con=setupConnection();


		  int  i = 0;
	       
	       
		
			try {
				ps= con.prepareStatement("insert into JenkinsEntry values(?,?)"); 
				ps.setString(1, reg.getUsername());
				ps.setString(2, reg.getPassword());
				System.out.println(reg.getPassword()+reg.getUsername());
				 i = ps.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return i;
		  
	  }  
	    
}
