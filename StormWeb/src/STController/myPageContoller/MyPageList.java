package STController.myPageContoller;

import java.util.ArrayList;  

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import STDao.MyPageDAO;
import STMainContoller.STAction;
import STUtil.STPageUtil;
import STUtil.STStringUtil;


public class MyPageList extends STAction {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		//	파라메터 받고
		String	savePath = req.getSession().getServletContext().getRealPath("img");
		String	strPage = req.getParameter("nowPage");
		int		nowPage = 0;
		if(STStringUtil.isNull(strPage)) {
			nowPage = 1;
		}
		else {
			nowPage = Integer.parseInt(strPage);
		}
		MyPageDAO 	dao = new MyPageDAO();
		int  total=dao.getTotal();
		STPageUtil	pInfo = new STPageUtil(nowPage, total);
		
		//		2.	목록 꺼내오고
		HttpSession session = req.getSession();
		int userNo = (int) session.getAttribute("UNO");
		
		System.out.println("########## DAO start ####");
		System.out.println("****** DAO usrNo : " + userNo);
		
		/*int uNo = 0;
		try{
			uNo = Integer.parseInt(userNo);
		}catch(Exception e){}*/
		ArrayList	list = dao.getBuyList(userNo);
		
	
		int		start = (nowPage - 1) * pInfo.listCount;
		int		end = start + pInfo.listCount - 1;
		//	마지막 위치가 데이터 개수보다 크면 데이터 개수로
		//	조절해 놓는다.
		//	근데...	0부터 시작하므로 -1을 해 주어야 한다.
		if(end >= list.size()) {
			end = list.size() - 1;
		}
		System.out.println("MyPageList 목록 ="+list.size());
		
		//		종료 위치를 알아낸다.
		//		일반적으로 종료위치는 시작위치 + (10 - 1)을 하면 된다.
		//		근데..	마지막은 10개가 되지 않을 수있다.
		//		(그러므로 마지막은 list가 가진 데이터개수가 종료위치가 된다.)
		//		그페이지에 필요한 게시물만 따로 기억할 변수
		ArrayList	rList = new ArrayList();		
		for(int i = start; i <= end; i++) {
			rList.add(list.get(i));
		}
		//	모델 생산해서
		req.setAttribute("savePath", savePath);
		req.setAttribute("PINFO", pInfo);
		req.setAttribute("MyLIST", rList);
		
		//	뷰를 부른다.
		return "../view/My/MyPageList.jsp";
	}
}

