package com.servlets.css;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Images
 */
@WebServlet("/css.do")
public class CssTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CssTest() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<html>"
                    + "<head>"
                    + "<meta http-equiv=\"content-type\" content=\"text/html; charset=UTF-8\">"
                    + "<title>Ð”Ð¾ÐºÑƒÐ¼ÐµÐ½Ñ‚</title>"
                    + "<link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\">"
                    + "</head>"
                    + "<body>"
                    + "<div class=\"main\">"
                    + "<div class=\"abzac\">Secret document</div>"
                    + "<div class=\"content\">"
                    + "<div class=\"small_column\">"
                    + "<img src=\"images/java.png\" alt=\"\" width=\"119\" height=\"222\">"
                    + "</div>"
                    + "<div class=\"big_column\">"
                    + "<div \">"
                    + "<table>"
                    + "<tr>"
                    + " <th>Name</th>"
                    + "  <th>Phone</th>"
                    + "</tr>"
                    + "<tr>"
                    + "   <td>Petr</td>"
                    + "  <td>555444</td>"
                    + " </tr>"
                    + " <tr>"
                    + "  <td>Ivan</td>"
                    + " <td>111222</td>"
                    + " </tr>"
                    + "    </table>"
                    + "</div>"
                    + "<div>"
                    + "<ul>"
                    + "  <li>Text document 1</li>"
                    + " <li>Text document 1</li>"
                    + "  <li>Text document 1</li>"
                    + "</ul>  "
                    + "</div>"
                    + "</div>"
                    + "</div>"
                    + "<div class=\"footer\">Test project 2013</div>"
                    + "</div>"
                    + "</body>"
                    + "</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
