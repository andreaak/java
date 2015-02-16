package com.expressionlanguage.implicitobjects;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Requ
 */
@WebServlet("/requestScope.do")
public class RequestScope extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public RequestScope() {
        super();
    } 
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("uid", "reqAttribUser");
		request.setAttribute("pwd", "reqAttribUserPwd");
		RequestDispatcher rd = request.getRequestDispatcher("/pages/expressions/implicitobjects/RequestScope.jsp");
		rd.forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/pages/expressions/implicitobjects/RequestScope.jsp?uid=reqUser&pwd=reqUserPwd");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
