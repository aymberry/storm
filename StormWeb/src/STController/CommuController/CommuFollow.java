package STController.CommuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import STDao.CommuDao;
import STMainContoller.STAction;

public class CommuFollow extends STAction{
	public String action(HttpServletRequest req, HttpServletResponse resp){
		
		String whatdo=req.getParameter("whatdo");
		String no =  req.getParameter("data2");
		String noWpage =req.getParameter("nowpage");
		int nowpage = Integer.parseInt(noWpage);
		int commuNo =Integer.parseInt(no);
	
		CommuDao Dao = new CommuDao();
		HttpSession session = req.getSession();
		int usrNo =(int) session.getAttribute("UNO");
		
		System.out.println("Ŀ�³�"+commuNo+"������"+usrNo+"�ӵ�"+whatdo);
		
		if(whatdo.equals("add")){
			System.out.println("����ǳ�");
			Dao.insertMapCommuUsr(commuNo, usrNo); //�����̺� �μ�Ʈ
		}
		else{
		Dao.updataIsshow(whatdo, commuNo, usrNo); 
		}
		Dao.close();
		req.setAttribute("cNo", commuNo);
		req.setAttribute("nowpage", nowpage);
		return "../view/Commu/CommuFollow.jsp";
	}
}
