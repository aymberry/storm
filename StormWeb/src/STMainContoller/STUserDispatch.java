package STMainContoller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SunDispatch
 */
@WebServlet("*.ust")
public class STUserDispatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap		map = new HashMap();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public STUserDispatch() {
        super();
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		Properties		prop = new Properties();
		FileInputStream	fin = null;
		try {
			fin = new FileInputStream("D:\\WebSource\\StormWeb\\src\\STMainContoller\\STUserMap.properties");
			prop.load(fin);
		}
		catch(Exception e) {}
		finally {
			try {
				fin.close();
			}
			catch(Exception e){}
		}
		
		Enumeration en = prop.keys();
		while(en.hasMoreElements()) {
			String	key = (String) en.nextElement();
			String	data = (String) prop.get(key);
			try {
				Class tempClass = Class.forName(data);
				STAction	realClass = (STAction) tempClass.newInstance();
				map.put(key, realClass);
			}
			catch(Exception e) {}
		}
	}
	/**  
	 * @see Servlet#destroy()
	 */
	public void destroy() {
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String	fullName = request.getRequestURI();
		String	domain = request.getContextPath();
		String	req = fullName.substring(domain.length());
		STAction	controller = (STAction) map.get(req);
		String	view = controller.action(request, response);
		try {
			RequestDispatcher ds = request.getRequestDispatcher(view);
			ds.forward(request, response);
		}
		catch(Exception e) {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
