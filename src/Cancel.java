/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sumeeth
 */
import javax.servlet.http.*;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
public class Cancel extends HttpServlet {
    PreparedStatement ps,ps2;
	int t1;
	int s1;
	int t2;
	int s2;
	int rs1;
	int rs2;
	int count;
	public void service( HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		res.setContentType("text/html");
		PrintWriter out=res.getWriter();
		try
		{
		 Class.forName("oracle.jdbc.driver.OracleDriver");
		 Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.21.28:1521:orcl","scott","tiger");
		 int custno=Integer.parseInt(req.getParameter("custno"));
                 String custname=req.getParameter("custname");
		 int noofpersons=Integer.parseInt(req.getParameter("noofpersons"));
                 int noofrooms=Integer.parseInt(req.getParameter("noofrooms"));
		 
		 
		 Statement st=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		 ResultSet rs=st.executeQuery("select * from custdetails");
		 
		 //Statement st2=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
		 //ResultSet rs2=st.executeQuery("select name,tno from reserve1 where name='name'");
		 //rs2.next();
		 //String name2=rs2.getString(1);
		 //int tno2=rs2.getInt(2);
                                    out.println("succesfully cancelled");
		 out.println("<html><body ><font size='4'>");
			/* while(rs.next())
			{
			  t1=rs.getInt(1);
			  s1=rs.getInt(2);
			  
			  rs.next();
			  
			 t2=rs.getInt(1);
			  s2=rs.getInt(2);
			  rs1=100-s1;
			  rs2=100-s2;
			 if(tno==t1)// || seats==s1)
			 {
			  s1=rs1+seats;
			  ps=con.prepareStatement("update itdetails set seats=? where tno=?" );
			  ps.setInt(1,s1);
			  ps.setInt(2,tno);
			 count=ps.executeUpdate();
  			out.println("tickets cancelled");
			  return;
			}
			else if(tno==t2)// || seats==rs2)
			{
			  s2=s2+seats;
			  ps=con.prepareStatement("update itdetails set seats=? where tno=?" );
			  ps.setInt(1,s2);
			  ps.setInt(2,tno);
			  count=ps.executeUpdate();
			  return;
			 }
			else
			{
				out.println("Enter Correct no of seats");
				return;
			}
			 
			}*/
			int count=ps.executeUpdate();
			//Deletes record
			ps2=con.prepareStatement("delete * from custdetails where custno=? and custname=?");
			ps2.setString(2,custname);
			ps2.setInt(1, custno);
			ps2.executeUpdate();
			
		 if(count==1)
		 {
		 out.println(custname+"booking cancelled");
		 out.println("<br><a href='cancel.html'>Back</a>");
		 out.println("<a href='enquiry.html'>Home</a>");
		 }
		 else
		 {
			 out.println("<br><a href='cancel.html'>Back</a>");
			 out.println("<a href='enquiry.html'>Home</a>");
		 }
		 
		 out.println("</font></body></html>");
		 
		}
		catch(NumberFormatException e)
		{
			  e.printStackTrace();
			//out.println("");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

}
    
}
