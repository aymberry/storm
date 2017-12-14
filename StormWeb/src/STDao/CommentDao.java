package STDao;

import java.sql.*;
import java.util.ArrayList;

import JDBC.JDBCUtil;
import JDBC.POOLUtil;
import STSql.CommentSql;
import STVo.CommentVo;

public class CommentDao 
{
	//PoolUtilities		db;
	JDBCUtil			db;
	Connection			connection;
	PreparedStatement	preparedStatement;
	Statement			statment;
	
	public	CommentDao()
	{
		//db	=	new PoolUtilities();
		db			=	new JDBCUtil();
		connection	=	db.getCON();
	}
	public	void	close()
	{
		db.close(preparedStatement);
		db.close(statment);
		db.close(connection);
	}
	
	@SuppressWarnings("rawtypes")
	public	ArrayList	getReviewsComments(int goods_no, int user_no)
	{
		ArrayList	result	=	new ArrayList<>();
		
		String	sql	=	CommentSql.getSQL(CommentSql.GET_REVIEW_COMMENTS);
		
		preparedStatement	=	db.getPSTMT(connection, sql);
		
		try
		{
			preparedStatement.setInt(1, goods_no);
			preparedStatement.setInt(2, user_no);
			ResultSet	rs	=	preparedStatement.executeQuery();
			
			while(rs.next())
			{
				CommentVo	vo	=	new CommentVo();
				
				vo.goods_no		=	rs.getInt("GOODS_NO");
				vo.goods_name=	rs.getString("GOODS_NAME");
				
				vo.user_no		=	rs.getInt("ORGIN_USER_NO");
				vo.user_name	=	rs.getString("ORGIN_USER_NAME");
				
				vo.writer_no		=	rs.getInt("COMMENT_WRITER_NO");
				vo.writer_name=	rs.getString("COMMENT_WRITER_NAME");

				vo.wdate			=	rs.getDate("WRITE_DATE");
				vo.content		=	rs.getString("CONTENT");
				
				result.add(vo);
			}			
		}
		catch (Exception e) 
		{	System.out.println("[CommentDAO->getReviewsComments(int goods_no, int user_no)]:"+e);		}
		
		db.close(preparedStatement);
		return result;
	}
	
	public void	insertNewComment(int goods_no, int originUserNo, int writerNo, String comment)
	{
		String	sql	=	CommentSql.getSQL(CommentSql.INSERT_INTO_NEW_COMMENT);
		
		preparedStatement	=	db.getPSTMT(connection, sql);
		
		try
		{
			preparedStatement.setInt(		1,	goods_no);
			preparedStatement.setInt(		2,	originUserNo);
			preparedStatement.setInt(		3,	writerNo);
			preparedStatement.setString(	4,	comment);
			System.out.println(goods_no+"\t"+originUserNo+"\t"+writerNo+"\t"+comment);
			preparedStatement.execute();
			
		}
		catch (Exception e) {
			System.out.println("******** insert error : " + e);
		}
		
		
		return;
	}
}
