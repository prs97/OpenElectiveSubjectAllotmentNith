import javax.servlet.*;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.sql.*;
public class Registration_servlet extends HttpServlet {
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	{
		System.out.println("rajat");
		String name,roll,branch,sem,cgpi,firstChoice,secondChoice,thirdChoice,fourthChoice,fivethChoice,gmail;
		name=req.getParameter("name");
		roll=req.getParameter("roll");
		branch=req.getParameter("branch");
		sem=req.getParameter("sem");
		cgpi=req.getParameter("cgpi");
		firstChoice=req.getParameter("firstChoice");
		secondChoice=req.getParameter("secondChoice");
		thirdChoice=req.getParameter("thirdChoice");
		fourthChoice=req.getParameter("fourthChoice");
		fivethChoice=req.getParameter("fivethChoice");
		gmail=req.getParameter("gmail");
		System.out.println(name+roll+branch+sem+cgpi+firstChoice+secondChoice+thirdChoice+fourthChoice+fivethChoice);
		HttpSession hs=req.getSession();
		hs.setAttribute("name", name);
		hs.setAttribute("roll", roll);
		hs.setAttribute("branch", branch);
		hs.setAttribute("sem", sem);
		hs.setAttribute("cgpi", cgpi);
		hs.setAttribute("firstChoice", firstChoice);
		hs.setAttribute("secondChoice", secondChoice);
		hs.setAttribute("thirdChoice", thirdChoice);
		hs.setAttribute("fourthChoice", fourthChoice);
		hs.setAttribute("fivethChoice", fivethChoice);
		hs.setAttribute("gmail", gmail);
		int a=0,b=0,c=0,d=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");

String s1="select * from NITH1DB";
PreparedStatement ps1=con.prepareStatement(s1);
ResultSet rs1=ps1.executeQuery();
while(rs1.next())
{
	a++;
	if(rs1.getString("ROLL").equals(roll))
	{
		
	}
	else
	{
		b++;
	}
	c=a;
	d=b;
}
if(c==d)
{
	RequestDispatcher rd=req.getRequestDispatcher("valid");
	rd.forward(req,res);
		}
else
{
	PrintWriter pw=res.getWriter();
	res.setContentType("text/html");
res.sendRedirect("alert.html");
}
		}
		catch(Exception e)
		{
			
		}
		
	}

}
