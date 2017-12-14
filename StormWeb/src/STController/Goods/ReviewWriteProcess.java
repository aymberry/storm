package STController.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import STDao.ReviewDao;
import STDao.UserDao;
import STMainContoller.STAction;

public class ReviewWriteProcess extends STAction
{
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String	gno	=	req.getParameter("gno");
		String	uid	=	req.getParameter("uid");
		String	score	=	req.getParameter("newScore");
		String	content	=	req.getParameter("content");
		System.out.println(gno+"\t"+uid+"\t"+score+"\t"+content);
		
		int goods_no	=	Integer.parseInt(gno);
		ReviewDao	dao	=	new ReviewDao();
		
		dao.UpdateReview(	goods_no, 
										new UserDao().getUserNumber(uid),
										score, 
										content
									);
		
		req.setAttribute("GOODS_NO", goods_no);
		req.setAttribute("USER_ID", uid);
		return "../view/Goods/ReviewWriteProcess.jsp";
	}

}
