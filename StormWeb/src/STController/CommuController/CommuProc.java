package STController.CommuController;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import STDao.CommuDao;
import STMainContoller.STAction;
import STUtil.STStringUtil;


public class CommuProc extends STAction {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		String	savePath = "D:\\WebSource\\JSP\\.metadata\\.plugins\\org.eclipse.wst.server.core"
				+ "									\\tmp0\\wtpwebapps\\StormWeb\\img\\commu";
		
		MultipartRequest multi = null;
		try { 
			multi = new MultipartRequest(req, savePath, 1024 * 1024 * 10, "UTF-8"
																, new DefaultFileRenamePolicy());
		}
		catch(Exception e){}
		
		String	title 	= multi.getParameter("title");
		String	body 	= multi.getParameter("body");
		
		CommuDao Dao = new CommuDao();
		String	oriName = multi.getOriginalFileName("file1");
		String	saveName = multi.getFilesystemName("file1");
		File		file = multi.getFile("file1");
		long	size = file.length();
	
		HttpSession session = req.getSession();
		int usrNo =(int) session.getAttribute("UNO");
		
		int no =Dao.getCommuNo();
//		Dao.insertCommunity("����", "�־ȴ�", "�̷�", 1); //��������
		Dao.insertMapCommuUsr(no, usrNo);     //�����̺� �μ�Ʈ
		Dao.insertCommunity(no, title, body, oriName, usrNo); //Ŀ�´�Ƽ���̺� �μ�Ʈ
		Dao.close();

		
		
		return "../view/Commu/CommuProc.jsp";
	}
}
