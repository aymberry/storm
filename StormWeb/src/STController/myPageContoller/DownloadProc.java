package STController.myPageContoller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import STDao.MyPageDAO;
import STMainContoller.STAction;
import STUtil.STFileUtil;

public class DownloadProc extends STAction {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		
		System.out.println("다운로드실행되나");
		MyPageDAO 	dao = new MyPageDAO();
		HttpSession session = req.getSession();
		int userNo = (int) session.getAttribute("UNO");
		ArrayList	list = dao.getBuyList(userNo);


		
		STFileUtil.fileDownload(resp, "ball.exe", "ball.exe", "D:\\WebSource\\JSP\\StormWeb\\WebContent\\down");
		req.setAttribute("MyLIST", list);
		return "";
	}
}
