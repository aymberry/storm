package STController.Goods;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import STDao.GoodsDao;
import STDao.GoodsTagDao;
import STDao.ReviewDao;
import STDao.UserDao;
import STMainContoller.STAction;
import STUtil.STSessionUtil;
import STVo.GoodsVo;
import STVo.ReviewVo;

public class GoodsDetailView	extends	STAction 
{
	String	DEBUG_HEADR	=	"[GoodsDetailView->";
	@Override
	public String action(HttpServletRequest req, HttpServletResponse resp) 
	{
		String thisHeader	=	DEBUG_HEADR+"action(HttpServletRequest req, HttpServletResponse resp) ] : ";
		
		String goods_noString = req.getParameter("GOODS_NO");
		String user_name	=	req.getParameter("USER_ID");
		
		int	goods_no	=	Integer.parseInt(goods_noString);
		
		GoodsDao	dao	=	new GoodsDao();
		GoodsVo		detailView = dao.getGoodsDetail(goods_no);
		dao.close();
		//��ǰ�� list�� ��ǰ�� �� ��� ���� �о�´�.
		ReviewDao	r_dao	=	new ReviewDao();
		ArrayList	reviewList	=	r_dao.getGoodsReviews(detailView.no);
		
		UserDao	u_dao	=	new UserDao();
		//���� �ۼ����� üũ
			int 	user_no = -9;
			user_no	=	u_dao.getUserNumber(user_name);
			
			boolean	review_writable	=false;
			
			if( user_no!=-9)
				review_writable	=	dao.getReviewWritable(goods_no, user_no);
			System.out.println(user_no+"\t"+review_writable);
		
		//������ ��ǰ�� ���� ���Ѵ�. ��ǰ���� ���� ��� 0 ���� ����ó��
		if(reviewList!=null)
		{
			detailView.reviewCnt	=	reviewList.size();
			int avgScore = 0;
			
			for(int i=0; i<reviewList.size();i++)
			{
				ReviewVo	temp	=(ReviewVo)reviewList.get(i);
				if(temp.score !=null)
				avgScore+=Integer.parseInt(temp.score);
			}
			
			if(reviewList.size()!=0)
			{
				avgScore/=reviewList.size();
			}		
			
			detailView.avgScore=avgScore;
		}
		else
		{
			detailView.avgScore=0;
			detailView.reviewCnt=0;
		}
		
		dao.close();
		r_dao.close();
		u_dao.close();
		
		System.out.println(thisHeader+"detailView->name = "+detailView.name);
		System.out.println(thisHeader+"reviewList.size() = "+reviewList.size());
		
		req.setAttribute("WRITABLE", review_writable);
		req.setAttribute("GOODS_INFO", detailView);
		req.setAttribute("REVIEW_LIST", reviewList);
		
		return "../view/Goods/GoodsDetailView.jsp";
	}

}
