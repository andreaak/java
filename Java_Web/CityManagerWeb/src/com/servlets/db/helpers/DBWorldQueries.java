package com.servlets.db.helpers;

import com.expressionlanguage.models.City;

public class DBWorldQueries {
	public static String getCitiesByDistrictByPopulation()
	{
		return "select * from city " 
				+ "where CountryCode = 'USA' " +
				"order by Name, District ASC, Population DESC";
	}
	
	public static String getCountriesByName()
	{
		return "select Code, Name, Population "
				+ "from country " 
			    + "order by Name";
	}
	
	public static String getCountriesByName2()
	{
		return "select * "
				+ "from country " 
			    + "order by Name";
	}
	
	public static String getCountryCodes()
	{
		return "SELECT DISTINCT Code "
				+ "FROM country " 
				+ "ORDER BY Code";
	}
	
	public static String insertCity(City c)
	{
		/*
		 * INSERT INTO city
			(Name, CountryCode, District, Population)
			VALUES
			('Z_CITY', 'USA', 'Z_STATE', 234234)
		 */
		return String.format("INSERT INTO city "
				+ "(Name, CountryCode, District, Population) "
				+ "VALUES ('%s', '%s', '%s', '%d')"
					, c.getName()
					, c.getCountryCode()
					, c.getDistrict()
					, c.getPopulation());
	}
	
	public static String getWebUserByUsernameAndPassword(String userName, String password)
	{
		return String.format("SELECT * FROM userinfo "
						+ "where UserName = '%s' "
						+ "and Password = '%s' "
						, userName, password);
	}
}
