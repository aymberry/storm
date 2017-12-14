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
		//	�Ķ���� �ް�
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
		
		//		2.	��� ��������
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
		//	������ ��ġ�� ������ �������� ũ�� ������ ������
		//	������ ���´�.
		//	�ٵ�...	0���� �����ϹǷ� -1�� �� �־�� �Ѵ�.
		if(end >= list.size()) {
			end = list.size() - 1;
		}
		System.out.println("MyPageList ��� ="+list.size());
		
		//		���� ��ġ�� �˾Ƴ���.
		//		�Ϲ������� ������ġ�� ������ġ + (10 - 1)�� �ϸ� �ȴ�.
		//		�ٵ�..	�������� 10���� ���� ���� ���ִ�.
		//		(�׷��Ƿ� �������� list�� ���� �����Ͱ����� ������ġ�� �ȴ�.)
		//		���������� �ʿ��� �Խù��� ���� ����� ����
		ArrayList	rList = new ArrayList();		
		for(int i = start; i <= end; i++) {
			rList.add(list.get(i));
		}
		//	�� �����ؼ�
		req.setAttribute("savePath", savePath);
		req.setAttribute("PINFO", pInfo);
		req.setAttribute("MyLIST", rList);
		
		//	�並 �θ���.
		return "../view/My/MyPageList.jsp";
	}
}

