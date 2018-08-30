
import javax.servlet.*;
import javax.servlet.http.*;

import java.sql.*;
public class Validation_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	{
HttpSession hs=req.getSession();
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
		String s="insert into NITH1DB(COUNT,NAME,ROLL,BRANCH,SEM,CGPI,FIRSTCHOICE,SECONDCHOICE,THIRDCHOICE,FOURTHCHOICE,FIVETHCHOICE,FIRST,SECOND,THIRD,FOUR,FIVE,GMAIL)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(s);
		ps.setInt(1,0);
		ps.setString(2,(String)hs.getAttribute("name"));
		ps.setString(3, (String)hs.getAttribute("roll"));
		ps.setString(4, (String)hs.getAttribute("branch"));
		ps.setString(5, (String)hs.getAttribute("sem"));
		ps.setFloat(6, Float.parseFloat((String)hs.getAttribute("cgpi")));
		//System.out.println("jdjsd");
		ps.setString(7, (String)hs.getAttribute("firstChoice"));
		ps.setString(8, (String)hs.getAttribute("secondChoice"));
		ps.setString(9, (String)hs.getAttribute("thirdChoice"));
		ps.setString(10, (String)hs.getAttribute("fourthChoice"));
		ps.setString(11, (String)hs.getAttribute("fivethChoice"));
		ps.setInt(12, 0);
		ps.setInt(13, 0);
		ps.setInt(14, 0);
		ps.setInt(15, 0);
		ps.setInt(16,0);
		ps.setString(17, (String)hs.getAttribute("gmail"));

		int i=ps.executeUpdate();
				if(i!=0)
		{
	//	JOptionPane.showMessageDialog(null, "Successfully registerd");
			//		RequestDispatcher rd=req.getRequestDispatcher("upd");
				//	rd.forward(req, res);
			res.sendRedirect("confirm2.html");
			System.out.println("Succesfully registered");
}
		else
		{
			System.out.println("Succesfully not registered");	
		//	JOptionPane.showMessageDialog(null, "Not Registerd!!Try Again");
		}

	}
	catch(Exception e)
	{
System.out.println( e);
		
	}
}

}