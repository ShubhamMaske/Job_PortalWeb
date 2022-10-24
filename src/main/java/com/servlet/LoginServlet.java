package com.servlet;
import java.io.IOException;

import com.dao.UserDao;
import com.database.DBConnect;
import com.entity.User;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/login")

public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String mail=req.getParameter("em");
			String pass=req.getParameter("ps");
			User u=new User();
			HttpSession session=req.getSession();
			
			if("admin@gmail.com".equals(mail)&& "admin@099".equals(pass)) {
				session.setAttribute("userobj", u);
				u.setRole("admin");
				resp.sendRedirect("admin.jsp");
			}
			else {
				UserDao dao =new UserDao(DBConnect.getConn());
				User user = dao.login(mail, pass);
				
				if(user!=null) {
					session.setAttribute("userobj", user);
					resp.sendRedirect("home.jsp");
				}
				else {
					session.setAttribute("succMsg", "Invalid Email and Password");
					resp.sendRedirect("login.jsp");
				}
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
