
import javax.servlet.http.*;
import javax.servlet.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;
public class Physics_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  int a=0,b=0;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		PreparedStatement ps=con.prepareStatement("select * from NITHMAINDB");
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		b++;
	}
	System.out.println("COUNTER IS"+b);
	a=5;
	rs=ps.executeQuery();
	if(b>5)
	{
		System.out.println("okk");
		int counter = 0;
	while(rs.next())
	{
		System.out.println("sdshdvs");
		if(rs.getString("FIRSTCHOICE").equals("physics"))
		{
			System.out.println("no");
		if(a==0)
		{}
		else
		{
			System.out.println("sorting working");
			PreparedStatement stmt1=con.prepareStatement("update NITHMAINDB set FIRST=? where ROLL=?");
			 stmt1.setInt(1,1 );
				stmt1.setString(2,rs.getString("ROLL"));
				stmt1.executeUpdate();
				System.out.println(stmt1.executeUpdate());
			String s="insert into ELECTIVEDB(ROLL,ELECTIVE)values(?,?)";
			PreparedStatement ps1=con.prepareStatement(s);
			ps1.setString(1,rs.getString("ROLL"));
			ps1.setString(2,rs.getString("FIRSTCHOICE"));
			//ps1.setInt(3,0);
			int j=ps1.executeUpdate();
			counter++;
			if(j!=0)
			{
			System.out.println("Succesfully Updated");
			}
			else
			{
				System.out.println("not inserterd");
			}
			a--;
		}
	}
	}
	int c=5-counter;
	PreparedStatement stmt1=con.prepareStatement("update SEAT set PHYSICS=? ");
	 stmt1.setInt(1,c );
		//stmt1.setInt(2, COUNT);
		int i=stmt1.executeUpdate();
	}
	else
	{
		int counter = 0;
		while(rs.next())
		{
			if(rs.getString("FIRSTCHOICE").equals("Physics"))
			{
				System.out.println("sorting working");
				PreparedStatement stmt1=con.prepareStatement("update NITHMAINDB set FIRST=? where ROLL=?");
				 stmt1.setInt(1,1 );
					stmt1.setString(2,rs.getString("ROLL"));
					stmt1.executeUpdate();
					System.out.println(stmt1.executeUpdate());
				String s="insert into ELECTIVEDB(ROLL,ELECTIVE)values(?,?)";
				PreparedStatement ps1=con.prepareStatement(s);
				ps1.setString(1,rs.getString("ROLL"));
				ps1.setString(2,rs.getString("FIRSTCHOICE"));
				//ps1.setInt(3,0);
				int j=ps1.executeUpdate();
				if(j!=0)
				{
				System.out.println("Succesfully Updated");
				}
				else
				{
					System.out.println("not inserterd");
				}
		//		a--;
				counter++;
			}
		}
		int c=5-counter;
		PreparedStatement stmt1=con.prepareStatement("update SEAT set PHYSICS=? ");
		 stmt1.setInt(1,c );
			int i=stmt1.executeUpdate();
		}	
	
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	RequestDispatcher rd=request.getRequestDispatcher("chemistry");
	rd.forward(request, response);
	
	}

}
