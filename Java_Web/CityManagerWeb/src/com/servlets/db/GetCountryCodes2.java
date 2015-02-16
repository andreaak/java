package com.servlets.db;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expressionlanguage.models.WebUser;
import com.servlets.contextListener.DBManagerSetup;
import com.servlets.db.helpers.DBWorldQueries;
import com.servlets.models.DBManager;


/**
 * Servlet implementation class GetCountryCodes
 */
@WebServlet("/getcountrycodes2.do")
public class GetCountryCodes2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCountryCodes2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String target = "";
		//String baseURL = getServletContext().getInitParameter("baseURL");
		String dest = getServletContext().getContextPath() + request.getParameter("suff");
		String dest2 = request.getParameter("suff2");
		
		HttpSession s = request.getSession();
		//make sure user is part of the admin schema or get out.
		if (s.getAttribute("authorized_user") == null)
		{
			
		}
		else
		{
			WebUser wu = (WebUser)s.getAttribute("authorized_user");
			if (wu.getAuthLevel() < 2)
			{
				response.sendRedirect(dest + "login.jsp");
				return;
			}
		}
		
		//get the country codes
		if (getServletContext().getAttribute(DBManagerSetup.ATTRIBUTE_NAME) != null)
		{
			DBManager dbm = (DBManager)getServletContext().getAttribute(DBManagerSetup.ATTRIBUTE_NAME);
			if (!dbm.isConnected())
			{
				if (!dbm.openConnection()) 
				{
					//log it
					throw new IOException("Could not connect to database and open connection");
				}
			}
			
			//build a list of Country Codes
			ArrayList<String> allCountryCodes = new ArrayList<String>();
			String query = DBWorldQueries.getCountryCodes();
			try
			{
				ResultSet rs = dbm.ExecuteResultSet(query);
				while (rs.next())
				{
					String c = rs.getString("Code");
					allCountryCodes.add(c);
				}
				s.setAttribute("countryCodes", allCountryCodes);
			}
			catch (Exception ex)
			{
				//log it
				throw new IOException("Query could not be executed for get all codes");
			}
			//response.sendRedirect(baseURL + "/Protected/addCity.jsp");
			target = "addCity.jsp";
			if(dest2 != null)
			{
				dest += dest2;
			}
		}
		else
		{
			target = "login.jsp";
			//response.sendRedirect(baseURL + "/loginServer.jsp");
		}
		response.sendRedirect(dest + target);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
