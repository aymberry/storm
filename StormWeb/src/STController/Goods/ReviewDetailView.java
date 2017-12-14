package STController.Goods;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import STDao.ReviewDao;
import STMainContoller.STAction;
import STSql.ReviewSql;
import STVo.ReviewVo;

public class ReviewDetailView	extends	STAction
{	
	String	DEBUG_HEADER	=	"[ReviewDetailView.java";
	@Override
	public String action(HttpServletRequest req, HttpServletResponse resp)
	{
		String thisHeader	=
				DEBUG_HEADER+"->action(HttpServletRequest req, HttpServletResponse resp)] : ";
		System.out.println(thisHeader+" action START");
		
		String	goodsNo_str		=	req.getParameter("g_no");
		String	originUser_str	=	req.getParameter("originUser");
		System.out.println(thisHeader+"->originUser_str:"+originUser_str);
		System.out.println(thisHeader+"->goodsNo_str:"+originUser_str);
		
		int		goodsNo			=	Integer.parseInt(goodsNo_str);
		int		originUser			=	Integer.parseInt(originUser_str);
		
		ReviewVo	vo	=	new ReviewDao().getUserReview(goodsNo,	originUser);
		System.out.println(thisHeader+"->vo.score : "+vo.score);
		req.setAttribute("REVIEW_DETAIL", vo);
		
		
		
		System.out.println(thisHeader+" action END");
		return "../view/Goods/ReviewDetailView.jsp";
	}
	
}
