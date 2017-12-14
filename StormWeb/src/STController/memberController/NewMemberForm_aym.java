package STController.memberController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import STMainContoller.STAction;
public class NewMemberForm_aym extends STAction {
	@Override
	public String action(HttpServletRequest req, HttpServletResponse resp) {

		
		//	회원가입폼을 보여준다.
		return "../view/Member/NewMemberForm_aym.jsp";

	}
}
