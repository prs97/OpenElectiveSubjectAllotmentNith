import java.sql.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
public class Final_Servlet extends HttpServlet {
	int math,chemistry,physics;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("second class");
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
			PreparedStatement ps=con.prepareStatement("select * from SEAT");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			math=rs.getInt("MATH");
		
			System.out.println(math);
			physics=rs.getInt("PHYSICS");
			chemistry=rs.getInt("CHEMISTRY");
		}
		System.out.println("math seat is="+math);
		if(math>0)
		{
			int m=math;
			PreparedStatement ps1=con.prepareStatement("select * from NITHMAINDB");
			ResultSet rs1=ps1.executeQuery();
			System.out.println("first if");
			while(rs1.next())
			{
				System.out.println("second if");
		int first=rs1.getInt("FIRST");
		int second=rs1.getInt("SECOND");
	//	System.out.println("third if");
				if((first==0&&second==0)&&(rs1.getString("THIRDCHOICE").equals("maths")))
				{
					//System.out.println("second in");
					if(math==0)
					{
					}
					else
					{
						//System.out.println("inside else");
					PreparedStatement stmt1=con.prepareStatement("update NITHMAINDB set THIRD=? where ROLL=?");
					 stmt1.setInt(1,1 );
						stmt1.setString(2,rs1.getString("ROLL"));	
					stmt1.executeUpdate();
				//	math--;
					String s="insert into ELECTIVEDB(ROLL,ELECTIVE)values(?,?)";
					PreparedStatement ps3=con.prepareStatement(s);
					ps3.setString(1,rs1.getString("ROLL"));
					ps3.setString(2,rs1.getString("THIRDCHOICE"));
					//ps1.setInt(3,0);
					int j=ps3.executeUpdate();
					math--;
				}
				}
			}
			PreparedStatement stmt1=con.prepareStatement("update SEAT set MATH=? ");
			 stmt1.setInt(1,math );
				//stmt1.setInt(2, COUNT);
				int i=stmt1.executeUpdate();
			//System.out.println("inside second");
		}
			//	System.out.println("for physics")
		if(physics>0)
		{
			int m=math;
			PreparedStatement ps1=con.prepareStatement("select * from NITHMAINDB");
			ResultSet rs1=ps1.executeQuery();
			System.out.println("first if");
			while(rs1.next())
			{
				//System.out.println("second if");
		int first=rs1.getInt("FIRST");
		int second=rs1.getInt("SECOND");
	//	System.out.println("third if");
				if((first==0&&second==0)&&(rs1.getString("THIRDCHOICE").equals("physics")))
				{
					//System.out.println("second in");
					if(physics==0)
					{
					}
					else
					{
						//System.out.println("inside else");
					PreparedStatement stmt1=con.prepareStatement("update NITHMAINDB set THIRD=? where ROLL=?");
					 stmt1.setInt(1,1 );
						stmt1.setString(2,rs1.getString("ROLL"));	
					stmt1.executeUpdate();
				//	math--;
					String s="insert into ELECTIVEDB(ROLL,ELECTIVE)values(?,?)";
					PreparedStatement ps3=con.prepareStatement(s);
					ps3.setString(1,rs1.getString("ROLL"));
					ps3.setString(2,rs1.getString("THIRDCHOICE"));
					//ps1.setInt(3,0);
					int j=ps3.executeUpdate();
					physics--;
				}
				}
			}
			PreparedStatement stmt1=con.prepareStatement("update SEAT set PHYSICS=? ");
			 stmt1.setInt(1,physics );
				//stmt1.setInt(2, COUNT);
				int i=stmt1.executeUpdate();
			//System.out.println("inside second");
		}
		//for chemistry
		
		if(chemistry>0)
		{
			int m=math;
			PreparedStatement ps1=con.prepareStatement("select * from NITHMAINDB");
			ResultSet rs1=ps1.executeQuery();
			System.out.println("first if");
			while(rs1.next())
			{
				System.out.println("second if");
		int first=rs1.getInt("FIRST");
		int second=rs1.getInt("SECOND");
	//	System.out.println("third if");
				if((first==0&&second==0)&&(rs1.getString("THIRDCHOICE").equals("chemistry")))
				{
					//System.out.println("second in");
					if(chemistry==0)
					{
					}
					else
					{
						//System.out.println("inside else");
					PreparedStatement stmt1=con.prepareStatement("update NITHMAINDB set THIRD=? where ROLL=?");
					 stmt1.setInt(1,1 );
						stmt1.setString(2,rs1.getString("ROLL"));	
					stmt1.executeUpdate();
				//	math--;
					String s="insert into ELECTIVEDB(ROLL,ELECTIVE)values(?,?)";
					PreparedStatement ps3=con.prepareStatement(s);
					ps3.setString(1,rs1.getString("ROLL"));
					ps3.setString(2,rs1.getString("THIRDCHOICE"));
					//ps1.setInt(3,0);
					int j=ps3.executeUpdate();
					chemistry--;
				}
				}
			}
			PreparedStatement stmt1=con.prepareStatement("update SEAT set CHEMISTRY=? ");
			 stmt1.setInt(1,chemistry );
				//stmt1.setInt(2, COUNT);
				int i=stmt1.executeUpdate();
			//System.out.println("inside second");
		}
		response.sendRedirect("alet3.html");
	}
		catch(Exception e)
		{
			System.out.println(e);
		}

}
}
