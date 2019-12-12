package controller.fee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FeeDao;
import pojo.Fee;

@WebServlet("/saveFee")
public class SaveFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String feeName = req.getParameter("feeName");
		String baseTime = req.getParameter("baseTime");
		String baseFee = req.getParameter("baseFee");
		String unitFee = req.getParameter("unitFee");
		String remark = req.getParameter("remark");
//		String type=req.getParameter("radFeeType");

		Fee fee = new Fee();
		fee.setFeeName(feeName);
		fee.setBaseTime(Integer.parseInt(baseTime));
		fee.setBaseFee(Double.valueOf(baseFee));
		fee.setUnitFee(unitFee);
		fee.setRemark(remark);
		fee.setState("已开通");

		// 调用costDao的方法，将数据插入到数据库
		FeeDao feeDao = new FeeDao();
		feeDao.addFee(fee);

		// 跳转到资费列表页面 同时刷新资费列表页面
		// 重定向
		resp.sendRedirect(req.getContextPath() + "/fee/feeList");
	}
}
