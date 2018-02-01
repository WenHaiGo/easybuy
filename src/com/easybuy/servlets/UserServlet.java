package com.easybuy.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.easybuy.model.EUser;
import com.easybuy.service.impl.EUServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String param = request.getParameter("param");
		if (param.equals("reg") && param != null && param != "") {
			// TODO Auto-generated method stub
			String EUId = request.getParameter("EUId");
			String EUPwd = request.getParameter("EUPwd");

			EUServiceImpl eu = new EUServiceImpl();
			// 在使用session上有一个问题就是：是不是只需要声明一次就可以后面一直存了呢？
			HttpSession session = request.getSession();// 获取session
			System.out.println(EUId);
			boolean flag = false;
			try {
				flag = eu.save(EUId, EUPwd);
				System.out.println(flag);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (flag) {
				session.setAttribute("login", EUId);
				response.sendRedirect("index.html");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
