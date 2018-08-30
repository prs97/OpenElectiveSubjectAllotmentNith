
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Show_Servlet extends HttpServlet {
	int i=0;
	String roll,elective,name,cgpi;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
			
			PrintWriter pw=response.getWriter();
			response.setContentType("text/html");
			pw.println("<html><head><title>'open Elective'</title></head><body>");
			pw.println("<table border='10px ' cellspacing='2px' bgcolor='black' cellpadding='10' class='main' align='center'>");
			pw.println("<caption><b><h2>Open Elective List</h2></b></caption>");
			pw.println("<tr bgcolor='mistyrose'><td><h3>Name</h3></td><td><h3>ROLL NO</h3></td><td><h3>CGPI</h3></td><td><h3>Alloted Open Elective</h3></td></tr>");
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			PreparedStatement ps5=con.prepareStatement("select * from VALUE");
			ResultSet rs5=ps5.executeQuery();
			while(rs5.next())
			{
				i++;
			}
			if(i==1)
			{
				
				
				PreparedStatement ps=con.prepareStatement("select * from ELECTIVEDB");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					elective=rs.getString("ELECTIVE");
					roll=rs.getString("ROLL");
				//	System.out.println("okk");
					PreparedStatement ps1=con.prepareStatement("select * from NITHMAINDB");
					ResultSet rs1=ps1.executeQuery();
					while(rs1.next())
					{
						if(rs1.getString("ROLL").equals(roll))
						{
						 name=rs1.getString("NAME");
						 cgpi=rs1.getString("CGPI");
						 
						}
					}
			pw.println("<tr bgcolor='white'><td>"+name+"</td><td>"+roll+"</td><td>"+cgpi+"</td><td>"+elective+"</td></tr>");		
				
				
				}
				pw.println("</table></body></html>");
				
				
			}
			else
			{
				response.sendRedirect("ShowAlert.html");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
