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
@WebFilter("/pages/filters/protected/*")
public class AuthorizationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthorizationFilter() {
        //do nothing
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		//do nothing
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//verify user is logged in
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		//validate using session
		HttpSession s = req.getSession();
		WebUser wu = (WebUser)s.getAttribute("authorized_user");
		
		if (wu == null)
		{
			String target = request.getServletContext().getContextPath() + "/pages/filters/login.jsp";
			res.sendRedirect(target);
		}
		else
		{
			// pass the request along the filter chain
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		//do nothing
	}

}
