

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

import javax.servlet.*;
public class Admin_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int i=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("ece branch");
		int a=1;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		PreparedStatement ps1=con.prepareStatement("select * from VALUE");
		ResultSet rs=ps1.executeQuery();
		while(rs.next())
		{
			i++;
		}
		System.out.println(i);
		if(i==0)
		{
		String s2="insert into VALUE(VER)values(?)";
		PreparedStatement ps2=con.prepareStatement(s2);
		ps2.setInt(1,1);
		ps2.executeUpdate();
		//RequestDispatcher rd=request.getRequestDispatcher("/check");
		//rd.forward(request,response);
		response.sendRedirect("check");
	}
		else
		{
			response.sendRedirect("alert4.html");
		}
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	//RequestDispatcher rd=request.getRequestDispatcher("check");
	//rd.forward(request,response);
	
		}

}
