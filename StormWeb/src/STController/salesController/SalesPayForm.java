package STController.salesController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import STMainContoller.STAction;
import STUtil.STSessionUtil;

public class SalesPayForm extends STAction {
	public String action(HttpServletRequest req, HttpServletResponse resp) {

		String str_g_no = req.getParameter("g_no");
		int g_no = Integer.parseInt(str_g_no);
		

		int usr_no = STSessionUtil.getId(req);	
		
		String nowPage = req.getParameter("nowPage");
		
		// 세션을 이용해야 할 필요가 있으므로 일단 세션을 받아놓자
		
		req.setAttribute("g_no", g_no);
		req.setAttribute("usr_no", usr_no);
		req.setAttribute("nowPage", nowPage);
		
		System.out.println("(1) " + g_no);
		System.out.println("(2) " + usr_no);
		System.out.println("(3) " + nowPage);
		
		return "../view/Sales/SalesPayForm.jsp";
	}
}
