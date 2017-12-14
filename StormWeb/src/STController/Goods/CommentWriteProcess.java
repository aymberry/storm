package STController.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import STDao.CommentDao;
import STDao.UserDao;
import STMainContoller.STAction;

public class CommentWriteProcess	extends	STAction 
{

	@Override
	public String action(HttpServletRequest req, HttpServletResponse resp) 
	{
		String	content	=	req.getParameter("content");
		String	str_goods_no	=	req.getParameter("gno");
		String	str_originNo	=	req.getParameter("originUID");
		String	str_writerNo	=	req.getParameter("writerNo");
		
		int	goods_no	=	Integer.parseInt(str_goods_no);
		int	origin_no	=	Integer.parseInt(str_originNo);
		int	writer_no	=	new UserDao().getUserNumber(str_writerNo);
		
		new CommentDao().insertNewComment(goods_no, origin_no, writer_no, content);
		req.setAttribute("g_no", goods_no);
		req.setAttribute("originUser", origin_no);
		return "../view/Goods/CommentWriteProcess.jsp";
	}

}
