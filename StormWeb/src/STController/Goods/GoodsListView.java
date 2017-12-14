package STController.Goods;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import STDao.GoodsDao;
import STDao.GoodsTagDao;
import STMainContoller.STAction;
import STVo.GoodsTagVo;
import STVo.GoodsVo;
import oracle.net.aso.f;

public class GoodsListView extends STAction 
{
	
	@Override
	public String action(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String req_GoodsType	=	req.getParameter("goodstype");
		System.out.println(req_GoodsType);
		
		GoodsDao		dao	=	new GoodsDao();
		ArrayList<GoodsVo>	goodsList	=	dao.getGoodsList();

		req.setAttribute("GOODS_LIST", goodsList);
		
		dao.close();		
		return "../view/Goods/GoodsListView.jsp";
	}

}
