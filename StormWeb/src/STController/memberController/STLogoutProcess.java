package STController.memberController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import STDao.GoodsDao;
import STMainContoller.STAction;
import STVo.GoodsVo;

public class STLogoutProcess extends STAction {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.invalidate();
		
		GoodsDao		dao	=	new GoodsDao();
		GoodsDao		dao1	=	new GoodsDao();
		ArrayList<GoodsVo>	recentList	=	dao.getRecentList();
		ArrayList<GoodsVo>	randomList	=	dao1.getRandomList();
		req.setAttribute("RECENT_LIST", recentList);
		req.setAttribute("RANDOM_LIST", randomList);
		dao.close();	
		dao1.close();	

		return "../view/main/StormMain.jsp";
	}
}
