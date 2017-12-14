package STDao;

import		JDBC.*;
import STSql.STLoginSQL;

import		java.sql.*;
import		STVo.*;
public class STMemberDao {
	
	public STMemberVo loginCheck(String id, String pw) {
		
		JDBCUtil				db 		= null;
		Connection			con 	= null;
		PreparedStatement	pstmt 	= null;
		ResultSet				rs 		= null;
		
		STMemberVo				mVO 	= null;
		try {
			db = new JDBCUtil();
			con = db.getCON();
			String sql = STLoginSQL.getSQL(STLoginSQL.SELECT_MEMBER);
			pstmt = db.getPSTMT(con, sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println("111");
				
				mVO = new STMemberVo();
				
				mVO.setNo(rs.getInt("no"));
				mVO.setNick(rs.getString("nick"));
				mVO.setEname(rs.getString("ename"));
			}
			
		}
		catch(Exception e) {
			System.out.println("로그인 에러 = " + e);
		}
		finally {
			db.close(rs);
			db.close(pstmt);
		}
		return mVO;
	}
}





