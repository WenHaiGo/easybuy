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
		String param = request.getParameter("param");
		EProductServiceImpl epService = new EProductServiceImpl();
		if (param != null && param.equals("specialProduct")) {
			// 这个参数真的不应该传入，既然变量名都是特卖的了为什么还要传入参数啊 传入参数和不传入参数会不会影响性能啊
			List<EProduct> list = epService.getSpecialSaleProduct(1);
			System.out.println(list.size());
			// 将list转换为json来一波
			Gson gson = new Gson();
			String productList = gson.toJson(list);
			System.out.println("山沟是" + productList);
			response.getWriter().write(productList);
		}

		if (param != null && param.equals("productView")) {
			System.out.println("nihao");
			String str = request.getParameter("EPId");
			System.err.println(str);
			if (str != null) {
				int EPID = Integer.parseInt(str);
				// 根据商品id得到该id商品所有的商品信息。
				EProduct ep = epService.getDetailProduct(EPID);
				
				request.setAttribute("EProduct", ep);

				request.getRequestDispatcher("product-view.jsp").forward(request, response);
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
