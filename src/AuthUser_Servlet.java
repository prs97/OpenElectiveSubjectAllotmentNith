

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthUser_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String name=request.getParameter("name");
	String pass=request.getParameter("roll");
	if(name.equals("rajat")&&pass.equals("bansal"))
			{
		response.sendRedirect("admin.html");
			}
	else
	{
		response.sendRedirect("alert2.html");
	}
	}

}
