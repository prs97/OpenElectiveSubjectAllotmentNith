
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.*;
import java.util.Properties;  
import javax.mail.*;  
import javax.mail.internet.*;  
import java.io.*;
import java.sql.*;
public class Message_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String gmail,elective;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			PreparedStatement ps=con.prepareStatement("select * from ELECTIVEDB");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			elective=rs.getString("ELECTIVE");
			String roll=rs.getString("ROLL");
		//	System.out.println("okk");
			PreparedStatement ps1=con.prepareStatement("select * from NITHMAINDB");
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				if(rs1.getString("ROLL").equals(roll))
				{
				 gmail=rs1.getString("GMAIL");	
				}
			}
			
			
			//System.out.println(gmail);
			//message send starting process
			 //String to="newjava4u@gmail.com";//change accordingly  
		      
		      //Get the session object  
		     Mailer m=new Mailer();
		    m.send(gmail,elective,roll);
			
			
		}
		response.sendRedirect("MessageAlert.html");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
