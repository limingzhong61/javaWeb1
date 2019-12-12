package controller.fee;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FeeDao;
import pojo.Fee;

@WebServlet("/fee/deleteFee")
public class DeleteFeeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		FeeDao feeDao = new FeeDao();
		String id = req.getParameter("id");
		feeDao.deleteFee(Integer.parseInt(id));
		List<Fee> all = feeDao.getAll();
		req.setAttribute("list", all);
		resp.setContentType("html");
		req.getRequestDispatcher("/fee/fee_list.jsp").forward(req, resp);
	}
}
