package STController.memberController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import STMainContoller.STAction;
public class NewMemberForm_aym extends STAction {
	@Override
	public String action(HttpServletRequest req, HttpServletResponse resp) {

		
		//	ȸ���������� �����ش�.
		return "../view/Member/NewMemberForm_aym.jsp";

	}
}
