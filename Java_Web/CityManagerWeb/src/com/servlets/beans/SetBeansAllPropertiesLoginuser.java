package com.servlets.beans;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetBeansAllPropertiesLoginuser
 */
@WebServlet("/setBeansAllPropertiesLoginUser.do")
public class SetBeansAllPropertiesLoginuser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SetBeansAllPropertiesLoginuser() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uid = request.getParameter("uid");
		String pwd = request.getParameter("pwd");
		//login...
		int authLevel = 1;
		
		String base = "/pages/expressions/usebeans/setBeansAllPropertiesWithParameters.jsp";
		// wrong mapping String params = String.format("?uid=%s&pwd=%s&al=%d"
		//					, uid, pwd, authLevel);
		String params = String.format("?userId=%s&password=%s&authLevel=%d"
				, uid, pwd, authLevel);
				
		String dest = String.format("%s%s"
						,base
						,params);
		RequestDispatcher rd = request.getRequestDispatcher(dest);
		rd.forward(request, response);
	}

}
