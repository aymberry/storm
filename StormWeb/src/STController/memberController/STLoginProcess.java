package STController.memberController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import STDao.GoodsDao;
import STDao.STMemberDao;
import STMainContoller.STAction;
import STVo.GoodsVo;
import STVo.STMemberVo;

public class STLoginProcess extends STAction {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		// 데이터 받고
		String strID = req.getParameter("id");
		String strPW = req.getParameter("pw");
		System.out.println("#### login contr : " + strID);
		// 가져오고
		STMemberDao dao = new STMemberDao();
		STMemberVo data = dao.loginCheck(strID, strPW);
		GoodsDao		dao2	=	new GoodsDao();
		GoodsDao		dao1	=	new GoodsDao();
		ArrayList<GoodsVo>	recentList	=	dao2.getRecentList();
		ArrayList<GoodsVo>	randomList	=	dao1.getRandomList();
		req.setAttribute("RECENT_LIST", recentList);
		req.setAttribute("RANDOM_LIST", randomList);
		dao2.close();
		dao1.close();
		
		// 뷰에게 넘기자...
		String url = "";
		try{
			String ename = data.getEname();
			HttpSession session = req.getSession();
			session.setAttribute("UID", data.getEname());
			session.setAttribute("UNO", data.getNo());

			url = "../view/main/StormMain.jsp";
		} catch(Exception e){
		
			url = "../view/Member/STLoginForm.jsp";
		}
		
		return url ;
	}
}
