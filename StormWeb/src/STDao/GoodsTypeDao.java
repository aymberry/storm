package STDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import JDBC.JDBCUtil;
import JDBC.POOLUtil;
import STSql.GoodsTypeSql;

public class GoodsTypeDao
{
	Connection				connection;
	Statement					statement;
	PreparedStatement	preparedStatement;
	JDBCUtil			db;
	
	public GoodsTypeDao()
	{
		db					=	new JDBCUtil();
		connection	=	db.getCON();
	}
	
	public	String	getGoodsType(int goods_no)
	{
		String sql = GoodsTypeSql.getSQL(GoodsTypeSql.MATCH_GOODS_TYPE);
		
		PreparedStatement	pstmt = db.getPSTMT(connection, sql);
		String type="";
		try
		{
			pstmt.setInt(1, goods_no);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			type = rs.getString("TYPE_NAME");
		}
		catch (Exception e) 
		{
			System.out.println("GoodsTypeDao err:" + e);
		}
		System.out.println("TYPE="+type);
		
		db.close(pstmt);
		return type;
	}
	
	public void	close()
	{
		db.close(preparedStatement);
		db.close(statement);
		db.close(connection);
	}
}
