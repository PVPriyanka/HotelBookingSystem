/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

  import java.io.*;

import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
public class Add_Customer extends HttpServlet {
  
		PreparedStatement st,st2;
	public void service( HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		int t1;
		int s1;
		int t2;
		int s2;

		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		try
		{                            
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.21.28:1521:orcl","priyanka","vyshnavi");
			int custno=Integer.parseInt(req.getParameter("custno"));
			String custname=req.getParameter("custname");
			int noofpersons=Integer.parseInt(req.getParameter("noofpersons"));
			int noofdays=Integer.parseInt(req.getParameter("noofdays"));
			st=con.prepareStatement("insert into addcustomers values(?,?,?,?)");
			st.setInt(1,custno);
			st.setString(2,custname);
			st.setInt(3,noofpersons);
			st.setInt(3,noofdays);
			int count=st.executeUpdate();
            out.println("added succesfully");
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery("select * from itdetails");
                }
		catch(Exception e)
		{
			e.printStackTrace();
			out.println("item not added  ");
		}

}
}


    
  
