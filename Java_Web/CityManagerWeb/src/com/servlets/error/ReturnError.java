package com.servlets.error;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SendError
 */
@WebServlet("/returnError.do")
public class ReturnError extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnError() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet CalcServlet</title>");
        out.println("</head>");
        out.println("<body>");
                
        try {


            double one = Double.valueOf(request.getParameter("one"));
            double two = Double.valueOf(request.getParameter("two"));
            //String opearation = request.getParameter("operation");

            HttpSession session = request.getSession(true);
            
            //request.getServletContext().setAttribute("obj", new TestObject("TestName"));

            
            //OperationType operType = OperationType.valueOf(opearation.toUpperCase());

            double result = one + two;
            
            ArrayList<String> listOperations;

            Object ob = session.getAttribute("formula");
            if (session.isNew() || ob == null) {
                listOperations = new ArrayList<String>();
            } 
            else { 
            	listOperations = (ArrayList<String>) ob;
            }

            listOperations.add(one + " " + "+" + " " + two + " = " + result);
            session.setAttribute("formula", listOperations);

            out.println("<h1>ID = : " + session.getId() + "</h1>");
         
            out.println("<h3>Operation list (All:" + listOperations.size() + ") </h3>");

            for (String oper : listOperations) {
                out.println("<h3>" + oper + "</h3>");
            }
      

        } catch (Exception ex) {       
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);

        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
