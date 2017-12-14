package STDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


import JDBC.JDBCUtil;
import JDBC.POOLUtil;
import STSql.ReviewSql;
import STVo.ReviewVo;

public class ReviewDao 
{
	Connection			con;
	PreparedStatement	pstmt;
	Statement			stmt;
	JDBCUtil			db;
	//PoolUtils			db;
	
	String	DEBUG_HEADER	=	"[ReviewDao->";
	
	public	ReviewDao()
	{
		db = new JDBCUtil();
		//db	=	new PoolUtils();
		con = db.getCON();
		
	}	
	public void close()
	{
		db.close(pstmt);
		db.close(stmt);
		db.close(con);
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList	getUsersReviews(int usr_no)
	{
		String	sql	=	ReviewSql.getSQL(ReviewSql.GET_USERS_REVIEW_LIST);
		pstmt	=	db.getPSTMT(con, sql);
		
		ArrayList	result	=	new ArrayList<>();
		
		try
		{
			pstmt.setInt(1, usr_no);
			
			ResultSet	rs	=	pstmt.executeQuery();
			
			while(rs.next())
			{
				ReviewVo	vo	=	new ReviewVo();
				vo.goods_no		=	rs.getInt("");
			}
			
		}
		catch (Exception e) 
		{	System.out.println("[ReviewDao->getUsersReviews:]"+e);	}
		
		
		db.close(pstmt);
		return result;
	}
	
	public	void UpdateReview(int g_no, int usr_no, String score, String content)
	{
		String sql	=	ReviewSql.getSQL(ReviewSql.UPDATE_NEW_REVIEW);
		
		pstmt	=	db.getPSTMT(con, sql);
		
		try
		{
			pstmt.setString(1,	content);
			pstmt.setString(2, score);
			pstmt.setInt(3, g_no);
			pstmt.setInt(4, usr_no);
			
			pstmt.execute();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return;
	}
	
	public	int	getUsersReviewsCount(int usr_no)
	{
		return	0;
	}
	public	int	getGoodsReviewCount(int goods_no)
	{
		return this.getGoodsReviews(goods_no).size();
	}
	
	//@SuppressWarnings({ "rawtypes", "unchecked" })
	public ArrayList	getGoodsReviews(int goods_no)
	{
		String	thisHeader	=	DEBUG_HEADER+"getGoodsReviews(int goods_no)";
		System.out.println(thisHeader+" ] : START");
		
		String	sql	=	ReviewSql.getSQL(ReviewSql.GET_GOODS_REVIEW_LIST);
		pstmt	=	db.getPSTMT(con, sql);
		
		ArrayList	result	=	new ArrayList<>();
		
		try
		{
			System.out.println(thisHeader+"] : START_TRY");
			pstmt.setInt(1, goods_no);
			ResultSet	rs	=	pstmt.executeQuery();
						
			System.out.println(thisHeader+"] : START_WHILE");
			while(rs.next())
			{
				System.out.println(thisHeader+"IN THE WHILE");
				CommentDao	temp=	new CommentDao();
				ReviewVo	vo	=	new	ReviewVo();
				
				vo.goods_no			=	rs.getInt	("goods_no"		);
				vo.goods_name	=	rs.getString("goods_name"	);
				
				vo.user_no			=	rs.getInt	("user_no"		);
				vo.user_nickname=	rs.getString("USR_NICK");
				
				vo.buy_date			=	rs.getDate	("BuyDate"		);
				vo.wdate				=	rs.getDate	("writeDate"	);
				
				vo.content			=	rs.getString("CONTENT"		);
				vo.score				=	rs.getString("score"		);
								
				vo.commentList	=	temp.getReviewsComments(goods_no, vo.user_no);
				vo.commentCnt	=	vo.commentList.size();
				System.out.println(thisHeader+"user_nickname : "+vo.user_nickname);
				result.add(vo);
			}
			System.out.println(thisHeader+"END OF WHILE");
			
		}
		catch (Exception e)
		{	
			System.out.println(thisHeader+"ERROR:"+e);
		}
		db.close(pstmt);
		
		System.out.println(thisHeader+"]:END");
		return result;
	}
	public ReviewVo getUserReview(int goodsNo, int originUser) 
	{
		String thisHeader	=	DEBUG_HEADER+"getUserReview] : ";
		System.out.println(thisHeader+"START");
		
		String sql	=	ReviewSql.getSQL(ReviewSql.GET_REVIEW_DETAIL);
		pstmt	=	db.getPSTMT(con, sql);
		
		ReviewVo	result	=	new ReviewVo();
		
		System.out.println(thisHeader+"Start of TryBlock.");
		try
		{
			System.out.println(thisHeader+"In the TryBlock.");
			pstmt.setInt(1, goodsNo);
			pstmt.setInt(2, originUser);
			
			ResultSet	rs 	=	pstmt.executeQuery();
			
			rs.next();
			
			result.goods_no			=	rs.getInt("GOODS_NO");
			result.goods_name		=	rs.getString("GOODS_NAME");
			
			result.user_nickname	=	rs.getString("USR_NICK");
			result.user_no			=	rs.getInt("USER_NO");
			
			result.buy_date			=	rs.getDate("BuyDate");
			result.wdate			=	rs.getDate("writeDate");
			
			result.content			=	rs.getString("CONTENT");
			result.score			=	rs.getString("score");
			result.commentList		=	new CommentDao().getReviewsComments(goodsNo, originUser);
			result.commentCnt		=	result.commentList.size();
		}
		catch (Exception e)
		{	
			System.out.println(thisHeader+" ERR : "+e);
		}
		
		db.close(pstmt);
		System.out.println(thisHeader+"END");
		return result;
	}
}
