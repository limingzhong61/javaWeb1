package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import pojo.User;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 处理中文乱码
		req.setCharacterEncoding("utf-8");
		// 接收用户数据
		String name = req.getParameter("username");
		String pwd = req.getParameter("password");
		String address = req.getParameter("address");
		String tel = req.getParameter("tel");
		// 将用户填写的数据查到数据库中

		User user = new User();
		user.setUsername(name);
		user.setPassword(pwd);
		user.setAddress(address);
		user.setPhone(tel);

		UserDao userDao = new UserDao();
		if (userDao.addUser(user)) {
			req.setAttribute("info", "注册成功，请登录");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} else {
			req.setAttribute("info", "注册失败成功，请重新注册");
			req.getRequestDispatcher("reister.jsp").forward(req, resp);
		}
	}
}
