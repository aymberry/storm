package STDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.JDBCUtil;
import JDBC.POOLUtil;
import STSql.GoodsTagSql;
import STVo.GoodsTagVo;

public class GoodsTagDao 
{
	Connection				connection;
	Statement					statement;
	PreparedStatement	preparedStatement;
	JDBCUtil					db;
	
	public GoodsTagDao()
	{
		db					=	new JDBCUtil();
		connection	=	db.getCON();
	}
	
	public ArrayList<GoodsTagVo>	getTags(int goods_no)
	{
		ArrayList<GoodsTagVo>	list	=	new ArrayList<GoodsTagVo>();
		
		String sql = GoodsTagSql.getSQL(GoodsTagSql.GET_TAG_OF_GOODS);
		preparedStatement	=	db.getPSTMT(connection, sql);
		
		try
		{
			
			preparedStatement.setInt(1, goods_no);
			ResultSet	rs	=	preparedStatement.executeQuery();
			
			while(rs.next())
			{
				GoodsTagVo vo	=	new GoodsTagVo();
				vo.tag_name =	rs.getString("TAG_NAME");
				vo.tag_no	=	rs.getInt("TAG_NO");
				
				list.add(vo);
			}
		}
		catch (Exception e) 
		{
			System.out.println("SQL에러 - GoodsTagDao-getTags함수"+e);
		}
		
		//System.out.println("LIST:"+list.toString());
		db.close(preparedStatement);
		return list;
	}
	
	public void close()
	{
		db.close(connection);
		db.close(statement);
		db.close(preparedStatement);
		
	}
}
