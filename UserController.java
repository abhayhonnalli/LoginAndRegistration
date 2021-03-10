package com.fujitsu.LoginAndRegister.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fujitsu.LoginAndRegister.DAO.UserDao;
import com.fujitsu.LoginAndRegister.model.User;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao dao=new UserDao();
		ResultSet rs =dao.displayUser();
		User user;
		ArrayList<User> array=new ArrayList<User>();
		try {
			while(rs.next()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2));
				user =new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5));
				array.add(user);
			}
			request.setAttribute("userlist", array);
			response.sendRedirect("admin.jsp");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}
		
	}



