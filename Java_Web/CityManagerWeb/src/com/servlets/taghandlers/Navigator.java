package com.servlets.taghandlers;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.*;

import com.expressionlanguage.models.NavigationDetails;
import com.servlets.contextListener.DBManagerSetup;

import java.io.IOException;
import java.util.*;

public class Navigator extends SimpleTagSupport{
	private ArrayList<NavigationDetails> links;
	
	private String suff;
	
	/**
	 * Mutator for City List.
	 * @param value the list of Cities to iterate
	 */
	public void setSuff(String value)
	{
		suff = new java.io.File(value).getParent().replace('\\', '/') + "/";
	}
	
	private void CreateNavigationLinks(){
		links = new ArrayList<NavigationDetails>();
		
		NavigationDetails nd = new NavigationDetails();
		nd.setLink("index.jsp");
		nd.setText("Home");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink("login.jsp");
		nd.setText("Login");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink("listCities.jsp");
		nd.setText("View Cities");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink("listCountries.jsp");
		nd.setText("View Countries");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink(DBManagerSetup.SERVER_CONTEXT_PATH +"/signout.do?suff="+ suff);///pages/jstl/customtags/basetld/
		nd.setText("Sign Out");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink(DBManagerSetup.SERVER_CONTEXT_PATH + "/invalidatesessionandremovecookies.do?suff="+ suff);
		nd.setText("Clear All User Data");
		links.add(nd);
		
		nd = new NavigationDetails();
		nd.setLink(DBManagerSetup.SERVER_CONTEXT_PATH + "/index_servlets.html");
		nd.setText("Main Page");
		links.add(nd);
	}

	public void doTag() throws JspException, IOException{
		//create the links
		CreateNavigationLinks();
		//iterate the links to the page
		for (NavigationDetails nd : links)
		{
			getJspContext().setAttribute("navdetails", nd);
			getJspBody().invoke(null);
		}
	}
}
