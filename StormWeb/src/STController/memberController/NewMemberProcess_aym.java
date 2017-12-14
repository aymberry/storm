package STController.memberController;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import STDao.GoodsDao;
import STDao.NewMemberDao_aym;
import STMainContoller.STAction;
import STVo.GoodsVo;

public class NewMemberProcess_aym extends STAction {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		//파라메터 받는다
		String newEmail = req.getParameter("email");
		String newNickname = req.getParameter("nick");
		String newPassword = req.getParameter("pw");
		
		GoodsDao		dao2	=	new GoodsDao();
		GoodsDao		dao1	=	new GoodsDao();
		ArrayList<GoodsVo>	recentList	=	dao2.getRecentList();
		ArrayList<GoodsVo>	randomList	=	dao1.getRandomList();
		req.setAttribute("RECENT_LIST", recentList);
		req.setAttribute("RANDOM_LIST", randomList);
		dao2.close();
		dao1.close();
		
		//작업처리하고 디비에 넣는다.
		NewMemberDao_aym dao = new NewMemberDao_aym();
		System.out.println("dao :  "+"email");
		try {
			dao.insertMember(newEmail, newNickname, newPassword);
		} catch (SQLException e) {System.out.println("에러"+e);
			
//			e.printStackTrace();
		}
		dao.close();
		System.out.println("dao닫고 :  "+"email");
		req.setAttribute("EMAIL", newEmail);		
		req.setAttribute("NICKNAME", newNickname);
		req.setAttribute("PASSWORD", newPassword);		

		return "../view/main/StormMain.jsp";
	}
}
//public void insertMember(String newNickname ,String newPassword, String newEmail, String newUserNo) {
//사용자가 입력한 데이터 받아서 테이블에 넣는 작업
//String sql = NewMemberSql.getSQL(NewMemberSql.SELECT_NICK);	
//pstmt = db.getPSTMT(con, sql);
//try {
//pstmt.setString(1,  newNickname);
//
//rs = pstmt.executeQuery();
//
//rs.next();
//NewMemberVo	nvo = new NewMemberVo();
//int tmpNo = rs.getInt(0);
//
//if(tmpNo > 0) { 				
//} else {}
//}
//catch(Exception e) {System.out.println("회원가입에러: "+e);}
//}