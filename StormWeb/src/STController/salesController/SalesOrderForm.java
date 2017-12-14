package STController.salesController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import STDao.SalesDao;
import STMainContoller.STAction;
import STVo.SalesVo;

public class SalesOrderForm extends STAction {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		
		// 1. 파라메터
		String imgname	=req.getParameter("g_imgname");
		String str_g_no = req.getParameter("g_no");
		int g_no = Integer.parseInt(str_g_no);
		String nowPage = req.getParameter("nowPage");
		
		// 세션
		HttpSession session = req.getSession();

		// 2. 뷰
		SalesDao dao = new SalesDao();
		SalesVo list = dao.getSalesGoods(g_no);
		
		dao.close();

		// 3. 모델
		req.setAttribute("OLIST", list);
		req.setAttribute("imgname", imgname);
		return "../view/Sales/SalesOrderForm.jsp";
	}
}
