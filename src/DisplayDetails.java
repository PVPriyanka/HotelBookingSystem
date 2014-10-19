/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;

import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class DisplayDetails extends HttpServlet{
    	
	String custname;
        int custno;
	int noofpersons;
	int noofdays;
	public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		
		out.println("<html><body bgcolor=#B041FF>");
		out.println("<center><u>DETAILS</u>");
		try
		{

                   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con=DriverManager.getConnection("jdbc:odbc:cjet","priyanka","priyanka");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.21.28:1521:orcl","scott","tiger");
			int cno=Integer.parseInt(req.getParameter("custno"));
			Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=st.executeQuery("select * from additdetails");
                        out.println("<br><table><tr><td>CUSTNO</td><td>CUSTNAME</td><td>NoOfPersons</td><td>NoOFDays</td></tr>");

			while(rs.next())
			{
                                custno=rs.getInt(1);
				custname=rs.getString(2);
				noofpersons=rs.getInt(3);
				noofdays=rs.getInt(4);
				if(cno==custno)
				{
					out.println("<tr><td>"+custname+"</td>");
					out.print("<td>"+noofpersons+"</td>");
					out.print("<td>"+noofdays+"</td>");
                                        
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

   
