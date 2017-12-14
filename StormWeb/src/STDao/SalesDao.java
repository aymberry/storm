package STDao;

import java.sql.*;
import java.util.ArrayList;

import JDBC.JDBCUtil;
import STSql.SalesSql;
import STVo.SalesVo;

public class SalesDao {

	JDBCUtil db;
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;

	public SalesDao() {
		db = new JDBCUtil();
		con = db.getCON();
	}

	/*
	 * 이제 각각 작업에서 필요한 함수를 만들어서 사용하도록 하자. 총 데이터개수 구하기 작업
	 */
	public int getTotal() {
		String sql = SalesSql.getSql(SalesSql.GET_TOTAL);
		stmt = db.getSTMT(con);
		// 총 개수를 기억할 변수
		int total = 0;
		try {
			ResultSet rs = stmt.executeQuery(sql);
			rs.next();
			total = rs.getInt("CNT");
		} catch (Exception e) {
			System.out.println("총 데이터개수 구하기 에러 = " + e);
		}
		return total;
	}

	/*
	 * 이제 각각 작업에서 필요한 함수를 만들어서 사용하도록 하자. 총 데이터개수 구하기 작업
	 */
	public void getDupOrder(int g_no, int usr_no) {
		String sql = SalesSql.getSql(SalesSql.GET_DUPORDER);

		pstmt = db.getPSTMT(con, sql);
		// 중복임을 기억할 변수
		int rec_cnt = 0;
		try {
			pstmt.setInt(1, g_no);
			pstmt.setInt(2, usr_no);
			pstmt.execute();

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	/*
	 * 목록 꺼내기를 위한 함수
	 */
	public ArrayList getSalesGoodList() {
		String sql = SalesSql.getSql(SalesSql.SELECT_GOODLIST);

		ArrayList list = new ArrayList();

		try {
			stmt = db.getSTMT(con);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				SalesVo sVo = new SalesVo();
				sVo.g_no = rs.getInt("G_NO");
				sVo.g_name = rs.getString("G_NAME");
				sVo.g_releasedate = rs.getDate("G_RELEASEDATE");
				sVo.g_price = rs.getInt("G_PRICE");

				// System.out.println(sVo.sales_bankname);

				list.add(sVo);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;

	}

	/*
	 * 상세상품 보기 함수
	 */
	public SalesVo getSalesGoods(int g_no) {
		String sql = SalesSql.getSql(SalesSql.SELECT_GOODS);

		SalesVo sVo = new SalesVo();

		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, g_no);

			ResultSet rs = pstmt.executeQuery();
			rs.next();
			sVo.g_no = rs.getInt("G_NO");
			sVo.g_name = rs.getString("G_NAME");
			sVo.g_releasedate = rs.getDate("G_RELEASEDATE");
			sVo.g_price = rs.getInt("G_PRICE");
			sVo.g_smalltext = rs.getString("G_SMALLTEXT");
			sVo.g_bigtext = rs.getString("G_BIGTEXT");
			sVo.g_installfile_name = rs.getString("G_INSTALLFILE_NAME");
			sVo.g_os_name = rs.getString("G_OS_NAME");
		} catch (Exception e) {
			System.out.println(e);
		}

		return sVo;

	}

	/*
	 * 목록 꺼내기를 위한 함수
	 */
	public ArrayList getSalesList() {
		String sql = SalesSql.getSql(SalesSql.SELECT_SALES);

		ArrayList list = new ArrayList();

		try {
			stmt = db.getSTMT(con);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				SalesVo sVo = new SalesVo();
				sVo.g_no = rs.getInt("G_NO");
				sVo.usr_no = rs.getInt("USR_NO");
				sVo.sales_buydate = rs.getDate("SALES_BUYDATE");
				sVo.sales_qty = rs.getInt("SALES_QTY");
				sVo.sales_account = rs.getString("SALES_ACCOUNT");
				sVo.sales_bankname = rs.getString("SALES_BANKNAME");
				sVo.payer = rs.getString("PAYER");

				// System.out.println(sVo.sales_bankname);

				list.add(sVo);

			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;

	}

	// 누군가가 게시물에 입력해 달라고 요청하면 입력해줄 함수
	public void insertSales(int g_no, int usr_no, int sales_qty, String sales_account, String sales_bankname,
			String payer) {
		// 입력을 위한 질의 명령 만들고
		String sql = SalesSql.getSql(SalesSql.INSERT_SALES);
		// 그 명령을 수행할 스테이트먼트 만들고
		pstmt = db.getPSTMT(con, sql);
		try {
			// ? 채워서
			pstmt.setInt(1, g_no); // 상품번호
			pstmt.setInt(2, usr_no); // 사용자번호
			pstmt.setInt(3, sales_qty); // 주문수량
			pstmt.setString(4, sales_account); // 결제계좌
			pstmt.setString(5, sales_bankname); // 은행명
			pstmt.setString(6, payer); // 지불자
			// 질의 실행하면 끝...

			// System.out.println(g_no + ", " + usr_no + ", " + sales_qty + ", "
			// + sales_account + ", " + sales_bankname + ", " + payer);
			pstmt.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 닫아주는 함수
	public void close() {
		db.close(stmt);
		db.close(pstmt);
		db.close(con);

	}

}
