package STController.memberController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import STMainContoller.STAction;

public class STLoginForm extends STAction {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		return "../view/Member/STLoginForm.jsp";
	}
}
