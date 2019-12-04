package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/findCookies")
public class FindCookiesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			String name = cookie.getName();
			String value = cookie.getValue();
			System.out.println(name + ":" + value);
		}
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}

}
