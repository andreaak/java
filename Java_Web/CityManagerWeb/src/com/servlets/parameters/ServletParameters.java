package com.servlets.parameters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainMenuResponder
 */
@WebServlet("/servletParameters.do")
public class ServletParameters extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletParameters() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
	PrintWriter out = response.getWriter();
	out.println("<html><body>"
			+ "<h1 align='center'>Results from GET MainMenuResponder received...</h1>"
			+"</body></html>"
			);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	
		//get the form parameter that was posted -- the parameter name is the name of the option select
		String userChoice = request.getParameter("menuChoice");
		String[] userOptions = request.getParameterValues("adminoptions");
		StringBuilder params = new StringBuilder("");
		String queryStringParams = "";
		if (userOptions != null)
		{
			boolean isFirst = true;
			for (int i = 0; i < userOptions.length; i++)
			{
				if (!isFirst)
				{
					params.append("&");
				}
				else
				{
					params.append("?");
				}
				
				if (userOptions[i].equalsIgnoreCase("useDB"))
				{
					params.append("useDB=1");
				}
				else if (userOptions[i].equalsIgnoreCase("sendEmail"))
				{
					params.append("sendEmail=1");
				}
				isFirst = false;
			}
			queryStringParams = params.toString();
		}
		
		
		//instead of posting data, transfer to the correct option
		/*
		out.println("<html><body><h1>Main Menu Handler</h1>" 
					+ "<p>User Choice: " + userChoice + "</p></body></html>");
		*/
		
		if (userChoice.equals("11")) 
		{
			response.sendRedirect("Parameters/ListCities.html" + queryStringParams);
		}
		else if (userChoice.equals("21"))
		{
			response.sendRedirect("Parameters/AddCity.html" + queryStringParams);
		}
		else if (userChoice.equals("31"))
		{
			response.sendRedirect("Parameters/DeleteCity.html" + queryStringParams);
		}
		else
		{
			//invalid response
			response.sendRedirect("Parameters/index.html");
		}
	}

}
