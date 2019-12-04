package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String username = req.getParameter("username");
		String pwd = req.getParameter("password");
		UserDao userDao = new UserDao();
		if (!userDao.queryByName(username)) {
			req.setAttribute("info", "用户名不存在,请注册");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
			return;
		}
		if (userDao.queryByNameAndPwd(username, pwd)) {
			req.setAttribute("info", "登录成功，欢迎" + username + "登录");
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		} else {
			req.setAttribute("info", "登录失败成功，请重新登录");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
	}
}
