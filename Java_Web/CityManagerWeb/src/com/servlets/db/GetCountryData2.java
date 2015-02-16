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

import com.expressionlanguage.models.Country;
import com.servlets.contextListener.DBManagerSetup;
import com.servlets.db.helpers.DBWorldQueries;
import com.servlets.models.DBManager;

/**
 * Servlet implementation class GetCountryData
 */
@WebServlet("/getcountrydata2.do")
public class GetCountryData2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public GetCountryData2() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String target = "";
		HttpSession s = request.getSession();
		String dest = getServletContext().getContextPath() + request.getParameter("suff");
		String dest2 = request.getParameter("suff2");
		ArrayList<Country> allCountries = new ArrayList<Country>();
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
				
				//build a list of country objects using the query
				
				String query = DBWorldQueries.getCountriesByName2();
				try
				{
					ResultSet rs = dbm.ExecuteResultSet(query);
					while (rs.next())
					{
						Country c = new Country();
						c.setCapital(rs.getString("Capital"));
						c.setCode(rs.getString("Code"));
						c.setCode2(rs.getString("Code2"));
						c.setContinent(rs.getString("Continent"));
						c.setGnp(rs.getDouble("GNP"));
						c.setGnpOld(rs.getDouble("GNPOld"));
						c.setGovernmentForm(rs.getString("GovernmentForm"));
						c.setHeadOfState(rs.getString("HeadOfState"));
						c.setIndepYear(rs.getInt("IndepYear"));
						c.setLifeExpectancy(rs.getDouble("LifeExpectancy"));
						c.setLocalName(rs.getString("LocalName"));
						c.setName(rs.getString("Name"));
						c.setPopulation(rs.getInt("Population"));
						c.setRegion(rs.getString("Region"));
						c.setSurfaceArea(rs.getDouble("SurfaceArea"));
						allCountries.add(c);
					}
				}
				catch (Exception ex)
				{
					//log it
					throw new IOException("Query could not be executed for get all countries by name");
				}
			s.setAttribute("countryData", allCountries);
			target = "listCountries.jsp";
			if(dest2 != null)
			{
				dest += dest2;
			}
		}
		else
		{
			target = String.format("index.jsp");
		}
		response.sendRedirect(dest + target);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
