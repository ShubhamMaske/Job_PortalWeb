package com.servlet;

import java.io.IOException;

import com.dao.UserDao;
import com.database.DBConnect;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/Update_profile")
public class UpdateUserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String name= req.getParameter("name");
			String qualification=req.getParameter("qua");
			String email=req.getParameter("email");
			String ps=req.getParameter("ps");
			UserDao dao = new UserDao(DBConnect.getConn());
			
			User u = new User();
			u.setId(id);
			u.setName(name);
			u.setQualification(qualification);
			u.setPasword(ps);
			u.setEmail(email);
			
			boolean f = dao.updateUser(u);
			HttpSession session = req.getSession();
			if(f) {
				session.setAttribute("succMsg", "Profile Update Successfully");
				resp.sendRedirect("home.jsp");
			}else {
				session.setAttribute("succMsg", "Something wrong on server");
				resp.sendRedirect("home.jsp");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	

}
