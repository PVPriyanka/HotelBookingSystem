/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
public class DataBaseConnection {
    public void connection()
	{
		
	 try
	 {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.21.28:1521:orcl","priyanka","vyshnavi");
		//Statement st=con.createStatement();
		
		
		
 	 } 
	 catch(Exception e)
	 {
		e.printStackTrace();
	 }
	}
	
    
}
