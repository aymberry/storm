package STController.CommuController;

import java.util.ArrayList;
import java.util.Comparator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import STDao.CommuDao;
import STMainContoller.STAction;
import STUtil.STSessionUtil;
import STVo.CommuVo;
import STVo.ReviewVo;

public class CommuView extends STAction {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		
		CommuDao Dao = new CommuDao();
		String strNo = req.getParameter("commuNo");
		String		strPage = req.getParameter("nowpage");
		int nowPage = 1;
		try {
			nowPage = Integer.parseInt(strPage);
		}
		catch(Exception e) {
			nowPage = 1;
		}
		int commuNo = Integer.parseInt(strNo);

		int 	usrNo = -9;
		usrNo = STSessionUtil.getId(req);
		CommuVo 	Vo = Dao.getCommuViewList(commuNo);
		String	list1 = "";
		ArrayList   list2 = null;
		if(usrNo != -9) {
			list1 = Dao.getIsshow(commuNo, usrNo); //팔로우버튼
//			list2 =	Dao.getMapCommuUsr(commuNo, usrNo); // 팔로우버튼중에 맵테이블이 안에있는 여부
		}
		ArrayList 	list3 = Dao.getCommuReview(commuNo);
		Dao.close();
		
		
		req.setAttribute("cNo", commuNo);
		req.setAttribute("CLIST", Vo);
		req.setAttribute("SHOWLIST", list1);
		req.setAttribute("SHOWLIST2", list2);
		req.setAttribute("REVIEWLIST", list3);
		req.setAttribute("NOWPAGE", nowPage);

	
		return"../view/Commu/CommuView.jsp";
	}
}
