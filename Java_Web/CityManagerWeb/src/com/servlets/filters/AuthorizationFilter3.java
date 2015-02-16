package com.servlets.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expressionlanguage.models.WebUser;

/**
 * Servlet Filter implementation class AuthorizationFilter
 */
@WebFilter({"/pages/css/protected/*", "/pages/auth/ssl/protected/*", "/pages/auth/db/protected/*"})
public class AuthorizationFilter3 implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorizationFilter3() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		HttpSession s = req.getSession();
		String path = req.getRequestURI();
		String suff = "";
		if(path.contains("/pages/auth/db/"))
		{
			suff = "/pages/auth/db/";
		}
		else if(path.contains("/pages/css/"))
		{
			suff = "/pages/css/";
		}
		else if(path.contains("/pages/auth/ssl/"))
		{
			suff = "/pages/auth/ssl/";
		}
		
		
		String dest = request.getServletContext().getContextPath() + suff;
		String loginTarget = dest + "login.jsp";
		
		String reqURI = req.getRequestURI().toLowerCase();
		
		if(reqURI.contains("cities"))
		{
			loginTarget += "?dest=protected/listCities";
		}
		else if (reqURI.contains("countries"))
		{
			loginTarget += "?dest=protected/listCountries";
		}

		if (s.getAttribute("authorized_user") == null)
		{
			res.sendRedirect(loginTarget);
			return;
		}	
		else
		{
			WebUser wu = (WebUser)s.getAttribute("authorized_user");
			if (wu.getUserId() == null || wu.getUserId() == ""|| wu.getPassword() == null || wu.getPassword() == "")
			{
				res.sendRedirect(loginTarget);
				return;
			}
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
