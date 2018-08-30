import javax.servlet.http.*;
import javax.servlet.*;

import java.io.*;
import java.sql.*;
public class Check_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
HttpSession hs=req.getSession();
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		String s1="select * from NITH1DB ORDER BY CGPI DESC";
		PreparedStatement ps1=con.prepareStatement(s1);
		ResultSet rs1=ps1.executeQuery();
		while(rs1.next())
		{	
			int count=rs1.getInt("COUNT");
			System.out.println(rs1.getString("CGPI"));
			System.out.println(rs1.getString("name"));
			String s="insert into NITHMAINDB(NAME,ROLL,BRANCH,SEM,CGPI,FIRSTCHOICE,SECONDCHOICE,THIRDCHOICE,FOURTHCHOICE,FIVETHCHOICE,FIRST,SECOND,THIRD,FOUR,FIVE,GMAIL)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(s);
		ps.setString(1,rs1.getString("NAME"));
		ps.setString(2, rs1.getString("ROLL"));
		ps.setString(3, rs1.getString("BRANCH"));
		ps.setString(4, rs1.getString("SEM"));
		System.out.println("sbhsb");
		ps.setFloat(5, Float.parseFloat(rs1.getString("CGPI")));
		System.out.println("hsdvsgdv");
		ps.setString(6, rs1.getString("FIRSTCHOICE"));
		ps.setString(7, rs1.getString("SECONDCHOICE"));
		ps.setString(8, rs1.getString("THIRDCHOICE"));
		ps.setString(9, rs1.getString("FOURTHCHOICE"));
		ps.setString(10,rs1.getString("FIVETHCHOICE"));
		ps.setInt(11,0);
		ps.setInt(12,0);
		ps.setInt(13,0);
		ps.setInt(14,0);
		ps.setInt(15,0);
		ps.setString(16,rs1.getString("gmail"));
		//ps.setInt(12,count);
		//ps.setFloat(17, Float.parseFloat(rs1.getString("CGPI")));
		int j=ps.executeUpdate();
		System.out.println(j+"inserted");
	
		}
		String s5="insert into SEAT(MATH,PHYSICS,CHEMISTRY)values(?,?,?)";
		PreparedStatement ps5=con.prepareStatement(s5);
		ps5.setInt(1, 5);
		ps5.setInt(2, 5);
		ps5.setInt(3, 5);
		ps5.executeUpdate();
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	RequestDispatcher rd=req.getRequestDispatcher("sort");
	rd.forward(req,res);
	}
}