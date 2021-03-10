package com.fujitsu.LoginAndRegister.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fujitsu.LoginAndRegister.DAO.LoginDao;

@WebServlet("/login")
public class Login extends HttpServlet {
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		LoginDao dao=new LoginDao();
		boolean result=dao.verifyUserCredentials(username, password);
		if(result)
		{
		//if(username.equals("user1@domain.com") && password.equals("password"))  {
		HttpSession session =request.getSession();
			session.setAttribute("user", username);
			response.sendRedirect("welcome.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	}

}
