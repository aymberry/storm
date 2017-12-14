package STUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class STSessionUtil {
	public static boolean isLogin(HttpServletRequest req) {
		HttpSession	session = req.getSession();
		if(session.getAttribute("USER") == null) {
			return false;
		}
		else {
			return true;
		}
	}
	public static int getId(HttpServletRequest req) {
		HttpSession session = req.getSession();
		//	이 부분은 로그인 처리를 담당한 사람이 사용하는 세션을 이용해서 수정 사용하세요
		Integer uno = (Integer) session.getAttribute("UNO");
		if(uno == null) {
			uno = -9;
		}
		return uno;
	}
	
	public static HttpSession createSession(HttpServletRequest req) {
		HttpSession session = req.getSession();
		return session;
	}
}







