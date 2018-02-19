package com.easybuy.servlets;

import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.model.EPCateg;
import com.easybuy.model.EProduct;
import com.easybuy.service.impl.EProductServiceImpl;
import com.google.gson.Gson;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String param = request.getParameter("param");

		EProductServiceImpl epService = new EProductServiceImpl();
		if (param != null && param.equals("specialProduct")) {
			// 这个参数真的不应该传入，既然变量名都是特卖的了为什么还要传入参数啊 传入参数和不传入参数会不会影响性能啊
			List<EProduct> list = epService.getSpecialSaleProduct(1);
			// 将list转换为json来一波
			Gson gson = new Gson();
			String productList = gson.toJson(list);
			response.getWriter().write(productList);
		}

		if (param != null && param.equals("productView")) {
			String str = request.getParameter("EPId");
			if (str != null) {
				System.out.println(str);
				int EPID = Integer.parseInt(str);
				// 根据商品id得到该id商品所有的商品信息。
				EProduct ep = epService.getDetailProduct(EPID);

				request.setAttribute("EProduct", ep);

				request.getRequestDispatcher("product-view.jsp").forward(request, response);
			}
		}

		if (param != null && param.equals("productCateg")) {
			List<EPCateg> list = epService.getCateg();
			Gson gson = new Gson();
			String productCategList = gson.toJson(list);
			response.getWriter().write(productCategList);

		}

		if (param != null && param.equals("hotProduct")) {
			List<EProduct> list = epService.getHotProduct(99);
			// 将list转换为json来一波
			Gson gson = new Gson();
			String productList = gson.toJson(list);
			response.getWriter().write(productList);
		}

		if (param != null && param.equals("categ")) {
			// 获取子类的id
			String str = request.getParameter("EPCId");
			// 如何判断一定是数字字符串？
			int EPCId = Integer.parseInt(str);

			List<EProduct> list = epService.getCategProduct(EPCId);

			// 因为是从一个页面跳转到另外一个页面，而且需要上一页的数据 所以不通过ajax 而是通过jsp实现
			request.setAttribute("categProduct", list);

			request.getRequestDispatcher("product-list.jsp").forward(request, response);
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
