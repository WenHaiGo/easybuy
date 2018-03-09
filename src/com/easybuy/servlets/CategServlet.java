package com.easybuy.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.dbutils.CategUtils;
import com.easybuy.model.EPCateg;
import com.easybuy.service.impl.CategServiceImpl;

/**
 * Servlet implementation class CategServlet
 */
@WebServlet("/CategServlet")
public class CategServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CategServlet() {
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
		if (param != null && param.equals("manageCateg")) {
			showAllCateg(request, response);
		}

		if (param != null && param.equals("delCateg")) {
			delCateg(request, response);
		}

		if (param != null && param.equals("updateCateg")) {
			updateCategById(request, response);

		}

	}

	private void updateCategById(HttpServletRequest request, HttpServletResponse response) {
		String idString = request.getParameter("id");
		// 得到这个分类的所有数据然后转发给编辑页面
		CategServiceImpl csi = new CategServiceImpl();
		if (idString != null) {
			try {
				EPCateg categ = csi.getByCid(Integer.parseInt(idString));
				List<CategUtils> list = new CategServiceImpl().getCategoryOfTree();
				request.setAttribute("allCateg",list);
				request.setAttribute("currentCateg", categ);
				request.getRequestDispatcher("productClass-modify.jsp").forward(request, response);
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private boolean delCateg(HttpServletRequest request, HttpServletResponse response) {
		String categId = request.getParameter("categId");
		CategServiceImpl csi = new CategServiceImpl();
		if (categId != null) {
			try {
				boolean isDel = csi.delCateg(Integer.parseInt(categId));
				if (isDel) {
					request.getRequestDispatcher("manageProductCateg.jsp").forward(request, response);
				} else {
					return false;

				}
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}

	private void showAllCateg(HttpServletRequest request, HttpServletResponse response) {
		CategServiceImpl csi = new CategServiceImpl();
		try {
			List<CategUtils> CUList = csi.getCategoryOfTree();
			// 把工具类发给页面
			request.setAttribute("CUList", CUList);
			request.getRequestDispatcher("manageProductCateg.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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