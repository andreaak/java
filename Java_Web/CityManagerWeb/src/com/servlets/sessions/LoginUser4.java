package com.servlets.sessions;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.expressionlanguage.models.WebUser;
import com.servlets.contextListener.DBManagerSetup;
import com.servlets.db.helpers.DBWorldQueries;
import com.servlets.models.DBManager;

/**
 * Servlet implementation class LoginUser
 */
@WebServlet("/loginUser4.do")
public class LoginUser4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUser4() {
        super();
    }

    /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession s = request.getSession();
		WebUser wu = (WebUser)s.getAttribute("authorized_user");
		String url = request.getServletContext().getContextPath() + request.getParameter("suff");
		
		String loginError = url + "loginError.jsp";
		if (wu == null || wu.getUserId().equals("") || wu.getAuthLevel() < 1)
		{
			//log in the user
			String uid = "";
			String pwd = "";
			
			if (request.getParameter("uid") != null)
			{
				uid = request.getParameter("uid");
			}
			if (request.getParameter("pwd") != null)
			{
				pwd = request.getParameter("pwd");
			}
			
			if ((wu == null
					|| wu.getAuthLevel() < 1
					|| wu.getUserId() == null
					|| wu.getUserId().equals("")) && (uid != "" && pwd != ""))
			{
				//perform login
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
					
					//see if there is a matching WebUser
					String query = DBWorldQueries.getWebUserByUsernameAndPassword(uid, pwd);
					try
					{
						ResultSet rs = dbm.ExecuteResultSet(query);
						
						while (rs.next())
						{
							wu = new WebUser();
							wu.setId(rs.getInt("ID"));
							wu.setUserId(rs.getString("UserName"));
							wu.setPassword(rs.getString("Password"));
							wu.setAuthLevel(rs.getInt("AuthLevel"));
							s.setAttribute("authorized_user", wu);
						}
						
						
						//add cookie if user wants to
						if (request.getParameter("rememberMe") != null)
						{
							String rememberMe = request.getParameter("rememberMe");
							if (rememberMe.equalsIgnoreCase("ON"))
							{
								//we also want to store the information in a cookie
								//for reuse later:
								int cookieLife = 3600*24*7; //7 days
								Cookie uidCook = new Cookie("credentials_uid",uid);
								uidCook.setMaxAge(cookieLife);  //7 days
								response.addCookie(uidCook);
								Cookie pwdCook = new Cookie("credentials_pwd",pwd);
								uidCook.setMaxAge(cookieLife);  //7 days
								response.addCookie(pwdCook);
							}
						}
					}
					catch (Exception ex)
					{
						System.out.println("Exception: " + ex.getMessage());
						response.sendRedirect(loginError);
						return;
					}
				}
			}
			
			if (wu == null
					|| wu.getAuthLevel() < 1
					|| wu.getUserId() == null
					|| wu.getUserId().equals(""))
			{
				response.sendRedirect(loginError);
				return;
			}
		}
		//direct to destination
		String destination = ((request.getParameter("dest") == null
							|| request.getParameter("dest") == "")
							? url + "/index.jsp"
							: url + "/" + request.getParameter("dest") + ".jsp");
		response.sendRedirect(destination);
	}
}
