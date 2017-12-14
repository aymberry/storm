package STController.mainController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import STDao.GoodsDao;
import STMainContoller.STAction;
import STVo.GoodsVo;

public class STMainController extends STAction {

		
		@Override
		public String action(HttpServletRequest req, HttpServletResponse resp) {
			// TODO Auto-generated method stub

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
