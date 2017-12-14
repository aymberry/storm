package STDao;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import JDBC.POOLUtil;
import STSql.CommuSql;
import STVo.CommuVo;



public class CommuDao {
	Connection			con;
	Statement				stmt;
	PreparedStatement	pstmt;
	POOLUtil				db;
	public CommuDao(){
		db = new POOLUtil();
		con = db.getCON();
	}
	
	//	이제 각각 작업에서 필요한 함수를 만들어서 사용하도록 하자.
	//	1.	총 데이터개수 구하기 작업
	public int getTotal() {
		String	sql = CommuSql.getSQL(CommuSql.GET_TOTAL);
		stmt = db.getSTMT(con);
		//	총 개수를 기억할 변수
		int		total = 0;
		try {
			ResultSet	rs = stmt.executeQuery(sql);
			rs.next();
			total = rs.getInt("CNT");
		}
		catch(Exception e) {
			System.out.println("총 데이터개수 구하기 에러 = " + e);
		}
		return total;
	}
	
	//	목록보기 질의 실행 함수
	public ArrayList getCommuList() {
		String	sql = CommuSql.getSQL(CommuSql.GET_COMMULIST);
		stmt = db.getSTMT(con);
		ArrayList	list = new ArrayList();
		try {
			ResultSet	rs = stmt.executeQuery(sql);
			while(rs.next()) {
				//	한줄의 데이터는 VO로 묶어서
				CommuVo	vo = new CommuVo();
				vo.commuNo = rs.getInt("commuNo");
				vo.commuName = rs.getString("commuName");
				vo.commuText = rs.getString("commuText");
				vo.commuImgName = rs.getString("commuImgName");
				vo.commuUsrNo = rs.getInt("commuUsrNo");

				//	컬렉션에 담는다.
				list.add(vo);
			}
		}
		catch(Exception e) {
			System.out.println("목록 구하기 에러 = " + e);
		}
		return list;
	}
	public ArrayList getCommuReview(int CommuNo){
		String sql = CommuSql.getSQL(CommuSql.GET_REVIEWINCOMMU);
		pstmt = db.getPSTMT(con, sql);
		ArrayList	list = new ArrayList();
		try{
			pstmt.setInt(1, CommuNo);
			ResultSet rs= pstmt.executeQuery();
			while(rs.next()) {
				//	한줄의 데이터는 VO로 묶어서
				CommuVo	vo = new CommuVo();
				vo.gname = rs.getString("gname");
				vo.nickname = rs.getString("nickname");
				vo.content = rs.getString("content");
				vo.score = rs.getInt("score");
				vo.usrimgname	=rs.getString("usrimgname");


				//	컬렉션에 담는다.
				list.add(vo);
			}
		}
		catch(Exception e){}
		return list;
	}
	public int getCommuNo(){
		String sql = CommuSql.getSQL(CommuSql.GET_COMMUNO);
		stmt = db.getSTMT(con);
		int		cnt = 0;
		try {
			ResultSet	rs = stmt.executeQuery(sql);
			rs.next();
			cnt = rs.getInt("CNT");
		}
		catch(Exception e) {
			
		}
		return cnt;
	}
	public void insertMapCommuUsr(int CommuNo, int UsrNo){
		String sql = CommuSql.getSQL(CommuSql.INSERT_MAP_COMMU_USR);
		pstmt = db.getPSTMT(con, sql);
		try{
			pstmt.setInt(1, CommuNo);
			pstmt.setInt(2, UsrNo);
			pstmt.execute();
		}
		catch(Exception e){System.out.println("맵인서트에러"+e);}
	}
	public void insertCommunity(int CommuNo, String cName, String Text, String imgName, int UsrNo){
		String sql = CommuSql.getSQL(CommuSql.INSERT_COMMUNITY);

		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1, CommuNo);
			pstmt.setString(2,  cName);
			pstmt.setString(3, Text);
			pstmt.setString(4,  imgName);
			pstmt.setInt(5,  UsrNo);
			pstmt.execute();
		}
		catch(Exception e) {System.out.println("커뮤니티인서트에러"+e);}
	}
	public String getIsshow(int CommuNo, int UsrNo){
		String sql = CommuSql.getSQL(CommuSql.GET_ISSHOW);
		pstmt = db.getPSTMT(con, sql);
		String list = "";
		try{
			pstmt.setInt(1, CommuNo);
			pstmt.setInt(2, UsrNo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				list = rs.getString("SHOW");
			}
		}
		catch(Exception e) {System.out.println("겟isshow에러"+e);}
		return list;
	}
	public ArrayList getMapCommuUsr(int CommuNo, int UsrNo){
		String sql = CommuSql.getSQL(CommuSql.GET_MAP_COMMU_USR);
		pstmt = db.getPSTMT(con, sql);
		ArrayList list = new ArrayList();
		try{
			pstmt.setInt(1, CommuNo);
			pstmt.setInt(2, UsrNo);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			CommuVo vo = new CommuVo();
			vo.commuNo = rs.getInt("commu_no");
			list.add(vo);
			}
		catch(Exception e) {System.out.println("겟isshow에러"+e);}
		return list;
	}
	public CommuVo getCommuViewList(int commuNo) {
		String	sql = CommuSql.getSQL(CommuSql.GET_COMMUVIEWLIST);
		pstmt = db.getPSTMT(con, sql);
		CommuVo	vo = new CommuVo();
		try {
			pstmt.setInt(1, commuNo);
			ResultSet	rs = pstmt.executeQuery();
			rs.next();
				vo.commuNo = rs.getInt("commuNo");
				vo.commuName = rs.getString("commuName");
				vo.commuText = rs.getString("commuText");
				vo.commuImgName = rs.getString("commuImgName");
				vo.commuUsrNo = rs.getInt("commuUsrNo");
				}
		catch(Exception e) {
			System.out.println("목록 구하기 에러 = " + e);
		}
		return vo;
	}
//	public void updataIsshow(String whatdo, int commuNo, int usrNo){
//		String sql =CommuSql.getSQL(CommuSql.UPDATE_ISSHOW);
//		System.out.println("Dao의 왓두"+whatdo);
//		if(whatdo.equals("follow")) {
//			sql.replaceAll("@", "Y");
//
//			System.out.println("실행되나1");
//		}
//		else if(whatdo.equals("unfollow")) {
//			sql.replaceAll("@", "N");
//			System.out.println("실행되나2");
//		}
//		System.out.println(sql);
//		pstmt = db.getPSTMT(con, sql);
//		try {
//			pstmt.setInt(1,  commuNo);
//			pstmt.setInt(2,  usrNo);
//			pstmt.execute();
//		}
//		catch(Exception e) {System.out.println("isshow업데이트에러"+e);}
//	}
	public void updataIsshow(String whatdo, int commuNo, int usrNo){
		String sql="";
		if(whatdo.equals("follow")) {
			 sql =CommuSql.getSQL(CommuSql.DO_FOLLOW);
		}
		else if(whatdo.equals("unfollow")) {
			 sql =CommuSql.getSQL(CommuSql.DO_UNFOLLOW);
		}
		pstmt = db.getPSTMT(con, sql);
		try {
			pstmt.setInt(1,  commuNo);
			pstmt.setInt(2,  usrNo);
			pstmt.execute();
		}
		catch(Exception e) {System.out.println("isshow업데이트에러"+e);}
	}
	public void close() {
		db.close(stmt);
		db.close(pstmt);
		db.close(con);
		//	close는 닫는 기능이지만....
		//	컨넥션 풀을 사용하는 경우에는 닫지 않고 컨넥션 풀에
		//	컨넥션을 돌려주는 기능이 구현된다.
	}
}
