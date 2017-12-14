package STMainContoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class STAction {
	public abstract String action(HttpServletRequest req, HttpServletResponse resp);
}




