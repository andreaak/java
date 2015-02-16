package com.servlets.sessions;

import java.io.IOException;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/loginuser.do")
public class LoginUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		
		HttpSession s = request.getSession();
		s.setAttribute("uid", uid);
		s.setAttribute("pwd", pwd);
		
		String destination = "showUserCredentials.jsp";
		if (request.getParameter("noSession") != null)
		{
			String noSession = request.getParameter("noSession");
			if (noSession.equalsIgnoreCase("ON"))
			{
				destination = "showUserCredentials2.jsp";
			}
		}
		destination = "pages/session/" + destination;
		//if use request dispatcher place a / in front of url
		//RequestDispatcher rd = request.getRequestDispatcher("/" + destination);
		//rd.forward(request, response);
		response.sendRedirect(response.encodeRedirectURL(destination));
	}

}
