package STController.CommuController;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import STDao.CommuDao;
import STMainContoller.STAction;
import STUtil.STPageUtil;
import STUtil.STStringUtil;


public class CommuList extends STAction {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		//	�Ķ���� �ް�
		String	savePath = req.getSession().getServletContext().getRealPath("img");
		String	strPage = req.getParameter("nowPage");
		System.out.println("���������� ��"+strPage);
		int		nowPage = 0;
		if(STStringUtil.isNull(strPage)) {
			nowPage = 1;
		}
		else {
			nowPage = Integer.parseInt(strPage);
		}
		CommuDao	dao = new CommuDao();
		int		total = dao.getTotal();
		STPageUtil	pInfo = new STPageUtil(nowPage, total);
		
		//		2.	��� ��������
		ArrayList	list = dao.getCommuList();
		
	
		int		start = (nowPage - 1) * pInfo.listCount;
		int		end = start + pInfo.listCount - 1;
		//	������ ��ġ�� ������ �������� ũ�� ������ ������
		//	������ ���´�.
		//	�ٵ�...	0���� �����ϹǷ� -1�� �� �־�� �Ѵ�.
		if(end >= list.size()) {
			end = list.size() - 1;
		}
		System.out.println(list.size());
		
		//		���� ��ġ�� �˾Ƴ���.
		//		�Ϲ������� ������ġ�� ������ġ + (10 - 1)�� �ϸ� �ȴ�.
		//		�ٵ�..	�������� 10���� ���� ���� ���ִ�.
		//		(�׷��Ƿ� �������� list�� ���� �����Ͱ����� ������ġ�� �ȴ�.)
		//		���������� �ʿ��� �Խù��� ���� ����� ����
		ArrayList	rList = new ArrayList();		
		for(int i = start; i <= end; i++) {
			rList.add(list.get(i));
		}
		dao.close();
		//	�� �����ؼ�
		req.setAttribute("savePath", savePath);
		req.setAttribute("PINFO", pInfo);
		req.setAttribute("CLIST", rList);
		
		//	�並 �θ���.
		return "../view/Commu/CommuList.jsp";
	}
}

