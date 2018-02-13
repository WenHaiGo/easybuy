package com.easybuy.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easybuy.model.ECartProduct;
import com.easybuy.model.EProduct;
import com.easybuy.service.impl.EProductServiceImpl;
import com.easybuy.service.impl.EUServiceImpl;

/**
 * Servlet implementation class UserActionServlet
 */
@WebServlet("/UserActionServlet")
public class UserActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserActionServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	EUServiceImpl eus = new EUServiceImpl();
	EProductServiceImpl eps = new EProductServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String param = request.getParameter("param");
		if (param != null && param.equals("cart")) {
			viewAllCartProduct(request, response);
		}

	}

	// 得到购物车所有的商品

	void viewAllCartProduct(HttpServletRequest request, HttpServletResponse response) {
		// 先得到当前用户id
		HttpSession session = request.getSession();
		String EPUId = (String) session.getAttribute("userName");
		System.out.println("当前用户是当前用户是当前用户是当前用户是" + EPUId);
		// clean code 里面说尽量不要做这种判断
		if (EPUId != null) {
			List<EProduct> cartProductList = eps.getAllCartProduct(EPUId);
			System.out.println("当前用户购物车商品数量为" + cartProductList.size());
			request.setAttribute("cartProductList", cartProductList);
			try {
				request.getRequestDispatcher("cart.jsp").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// 未登录点击购物车
		else {
			try {
				// response.sendRedirect("login.jsp");
				request.setAttribute("fromCart", "已经登录了");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			} catch (IOException | ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
