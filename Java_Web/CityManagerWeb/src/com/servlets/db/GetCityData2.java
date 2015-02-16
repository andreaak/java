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









import com.expressionlanguage.models.City;
import com.servlets.contextListener.DBManagerSetup;
import com.servlets.db.helpers.DBWorldQueries;
import com.servlets.models.DBManager;

/**
 * Servlet implementation class GetCityData
 */
@WebServlet("/getcitydata2.do")
public class GetCityData2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCityData2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		String target = "";
		String dest = getServletContext().getContextPath() + request.getParameter("suff");
		String dest2 = request.getParameter("suff2");
		ArrayList<City> allCities = new ArrayList<City>();
		if ( getServletContext().getAttribute(DBManagerSetup.ATTRIBUTE_NAME) != null)
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
				
				//build a list of city objects using the query
				String query = DBWorldQueries.getCitiesByDistrictByPopulation();
				try
				{
					ResultSet rs = dbm.ExecuteResultSet(query);
					while (rs.next())
					{
						City c = new City();
						c.setId(rs.getInt("ID"));
						c.setName(rs.getString("Name"));
						c.setCountryCode(rs.getString("CountryCode"));
						c.setDistrict(rs.getString("District"));
						c.setPopulation(rs.getInt("Population"));
						allCities.add(c);
					}
				}
				catch (Exception ex)
				{
					//log it
					throw new IOException("Query could not be executed for get all cities");
				}

			s.setAttribute("cityData", allCities);
			target = "listCities.jsp";
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
}
