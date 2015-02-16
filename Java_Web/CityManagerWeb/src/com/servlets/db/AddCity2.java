package com.servlets.db;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expressionlanguage.models.City;
import com.servlets.contextListener.DBManagerSetup;
import com.servlets.db.helpers.DBWorldQueries;
import com.servlets.models.DBManager;

/**
 * Servlet implementation class AddCity
 */
@WebServlet("/addnewcity2.do")
public class AddCity2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCity2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//add a city
		String name = request.getParameter("cityName");
		String countryCode = request.getParameter("cityCountryCode");
		String district = request.getParameter("cityDistrict");
		String population = request.getParameter("cityPopulation");
		//String baseURL = getServletContext().getInitParameter("baseURL");
		//String target = "";
		String dest =  request.getParameter("suff");
		String dest2 = request.getParameter("suff2");
		if (name == null || name.equals("")
				|| countryCode == null || countryCode.equals("")
				|| district == null || district.equals("")
				|| population == null || population.equals(""))
		{
			//redirect to add a new city
			response.sendRedirect( dest + dest2 + "addCity.jsp");
			return;
		}
		
		try
		{
			/**
			 * Add a new city
			 */
			City c = new City();
			c.setCountryCode(countryCode);
			c.setDistrict(district);
			c.setPopulation(Integer.parseInt(population));
			c.setName(name);
			c.setId(-1);
		
			//get the cities and direct on
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
				
				String query = DBWorldQueries.insertCity(c);
				try
				{
					dbm.ExecuteNonQuery(query);
				}
				catch (Exception ex)
				{
					//log it
					throw new IOException("Query could not be executed for get all codes");
				}
				//make the city data null
				HttpSession s = request.getSession();
				s.setAttribute("cityData", null);
				
				//re-get the city data and forward on to the listCities again
				//response.sendRedirect(baseURL + "/getcitydata.do");
				
				response.sendRedirect(String.format(getServletContext().getContextPath() + "/getcitydata2.do?suff=%s&suff2=%s",dest,dest2));
			}
			else
			{
				throw new Exception ("No database connection.");
			}
		}
		catch (Exception ex)
		{
			//log it.
			//response.sendRedirect(baseURL + "/errorHandler.jsp");
		}
	}

}
