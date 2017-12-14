package STDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import JDBC.JDBCUtil;
import JDBC.POOLUtil;
import STSql.UserSql;

public class UserDao 
{
	JDBCUtil	db;
	Connection	con;
	PreparedStatement	pstmt;
	Statement		stmt;
	public UserDao()
	{
		db	=	new JDBCUtil();
		con	=	db.getCON();
	}
	public int	getUserNumber(String user)
	{
		int result = -9;
		String sql	=	UserSql.getSql(UserSql.GET_USER_NO);
		
		pstmt = db.getPSTMT(con, sql);
		
		try
		{
			pstmt.setString(1, user);
			
			ResultSet rs =pstmt.executeQuery();
			rs.next();
			result = rs.getInt("USR_NO");
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	public void close() {
		db.close(pstmt);
		db.close(stmt);
		db.close(con);		
	}
}
