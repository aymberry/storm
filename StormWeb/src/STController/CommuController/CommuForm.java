package STController.CommuController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import STMainContoller.STAction;

public class CommuForm extends STAction {
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		
		return"../view/Commu/CommuForm.jsp";
	}
}
