package com.easybuy.servlets;

import java.io.IOException;
import java.security.interfaces.RSAKey;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.easybuy.model.EUser;
import com.easybuy.service.impl.EUServiceImpl;

/**
 * Servlet implementation class Manage
 */
@WebServlet("/ManageOperateServlet")
public class ManageOperateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ManageOperateServlet() {
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
		System.out.println("进入一号地点");
		//String param = request.getParameter("param");
		String param = "addUser";
		if (param != null && param.equals("addUser")) {
			System.out.println("erhaodidian ");
			addUser(request, response);
		}

	}

	private void addUser(HttpServletRequest request, HttpServletResponse response) {
		String userName = request.getParameter("userName");
		// 真实姓名
		EUser user = new EUser();
		String name = request.getParameter("name");
		String passWord = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String birthyear = request.getParameter("birthyear");
		String birthmonth = request.getParameter("birthmonth");
		String birthday = request.getParameter("birthday");
		String mobile = request.getParameter("mobile");
		String address = request.getParameter("address");
		String photo = request.getParameter("photo");
		user.setEUAddress(address);
		// 处理时间
		String birthTime = birthyear +"-"+ birthmonth +"-"+ birthday;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = null;
		try {
			// 将util的时间转换为sql里的代码希望可以保存到数据库中
			date = format.parse(birthTime);
			java.sql.Date date2 = new Date(date.getTime());
			user.setEUBirthday(date2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		user.setEUId(userName);

		user.setEUMoible(mobile);

		user.setEUName(name);
		// 上传头像应该是上传到一个图片文件夹里，然后向数据里面保存一个地址就好了
		user.setEUPhoto(photo);

		user.setEUPwd(passWord);

		user.setEUSex(sex);

		// 将user上传到数据库
		EUServiceImpl eus = new EUServiceImpl();
		boolean isSave = eus.saveUserFromManage(user);
		
		if(isSave)
		{
			try {
				System.out.println("shifpuidhsin "+isSave);
				request.getRequestDispatcher("manage-result.html").forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
			
		}
		
		else {
			System.out.println("保存失败");
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
