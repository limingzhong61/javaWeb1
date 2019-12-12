package controller.fee;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import dao.FeeDao;
import pojo.Fee;

@WebServlet("/fee/updateFee")
public class UpdateFeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		FeeDao feeDao = new FeeDao();
		Map<String, String[]> map = req.getParameterMap();
		Fee fee = new Fee();
		try {
			// 将map所得到的表单数据封装到user实体类
			BeanUtils.populate(fee, map);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		System.out.println(fee);
		feeDao.updateFeeById(fee);
		req.getRequestDispatcher("/fee/feeList").forward(req, resp);
	}
}
