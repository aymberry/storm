package STController.memberController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import STDao.NewMemberDao_aym;
import STMainContoller.STAction;

public class EmailCheck_aym extends STAction {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		
		String email = req.getParameter("email");
		
		NewMemberDao_aym dao = new NewMemberDao_aym();
		int	result = dao.emailCheck(email);
		dao.close();
		
		req.setAttribute("RESULT", result);
		return "../view/Member/EmailCheck_aym.jsp";
	}
}
