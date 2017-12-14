package STDao;

import java.sql.*;  
import java.util.ArrayList;

import JDBC.JDBCUtil;
import STSql.BuyListSQL;
import STVo.BuyListVO;

public class MyPageDAO {

	JDBCUtil 		db;
	Connection 	con;
	Statement 	stmt;
	PreparedStatement pstmt;

	public MyPageDAO() {
		db = new JDBCUtil();
		con = db.getCON();
	}

	/*
	 * ���Ÿ�� ����
	 */
	public ArrayList getBuyList(int uNo) {
		String sql = BuyListSQL.getSQL(BuyListSQL.CHECK_PURCHASE_PRODUCT);
		ArrayList list = new ArrayList();
		try {
			pstmt = db.getPSTMT(con, sql);
			pstmt.setInt(1, uNo);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BuyListVO BVo = new BuyListVO();
				BVo.g_no = rs.getInt("g_no");
				BVo.g_name= rs.getString("g_name");
				BVo.g_price = rs.getInt("g_price");
				BVo.sales_buydate = rs.getDate("sales_buydate");

				list.add(BVo);
			}
		} 
		catch (Exception e) {
			System.out.println("getBuyList����= " + e );
		} finally{
			db.close(pstmt);
		}
			return list;
	}
	
	public int getTotal() {
		String	sql = BuyListSQL.getSQL(BuyListSQL.GET_TOTAL);
		stmt = db.getSTMT(con);
		//	�� ������ ����� ����
		int		total = 0;
		try {
			ResultSet	rs = stmt.executeQuery(sql);
			rs.next();
			total = rs.getInt("CNT");
		}
		catch(Exception e) {
			System.out.println("���Ÿ�� �ѵ����� ���ϱ⿡�� = " + e);
		} finally{
			db.close(stmt);
		}
		return total;
	}

	
	// �ݾ��ִ� �Լ�
	public void close() {
		db.close(stmt);
		db.close(pstmt);

	}

}
