package STDao;
import java.sql.*;
import STVo.NewMemberVo_aym;
import JDBC.JDBCUtil;
import STSql.NewMemberSql_aym;

@SuppressWarnings("unused")
public class NewMemberDao_aym {
	JDBCUtil	db = null;
	Connection	con = null;
	Statement	stmt = null;
	PreparedStatement	pstmt = null;
	ResultSet	rs = null;

	
	//	이 Dao를  new 시키면 드라이버 로딩, 커넥트.
	public NewMemberDao_aym() {
		db = new JDBCUtil();
		con = db.getCON();
	}
	//	이메일 중복 검사 질의함수
	public int emailCheck(String email) {
		String sql = NewMemberSql_aym.getSQL(NewMemberSql_aym.SELECT_OLDEMAIL);
		pstmt = db.getPSTMT(con, sql);
		int	result = 0;
		try {
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt("CNT");
		}
		catch(Exception e) {System.out.println("이메일 체크 에러 : " + e);}
		return result;
	}

	//	닉네임 중복 검사 질의함수
	public int nickCheck(String nick) {
		String sql = NewMemberSql_aym.getSQL(NewMemberSql_aym.SELECT_OLDNICK);
		pstmt = db.getPSTMT(con, sql);
		int	result = 0;
		try {
			pstmt.setString(1, nick);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			result = rs.getInt("CNT");
		}
		catch(Exception e) {System.out.println("닉네임 체크 에러 : " + e);}
		
		return result;
	}


	//	회원정보입력 질의함수 
	public void insertMember(String newEmail, String newNickname, String newPassword) throws SQLException {
		String sql = NewMemberSql_aym.getSQL(NewMemberSql_aym.INSERT_NEW);
		pstmt = db.getPSTMT(con, sql);

		try {
			pstmt.setString(1, newEmail);
			pstmt.setString(2, newNickname);
			pstmt.setString(3, newPassword);
//			pstmt.setDate(4, sysdate);
//			pstmt.setDate(5, sysdate);
//			pstmt.setString(6, null);
//			pstmt.setString(7, null);
			
			pstmt.execute();
			
		}
		catch(Exception e) {System.out.println("가입 처리 에러 : "+e);}
		finally {

		}
	}
	
	public void close() {
		db.close(rs);
		db.close(pstmt);
		db.close(con);
	}
}


		
		
//JDBCUtil	db;
//Connection	con;
//Statement	stmt;
//PreparedStatement	pstmt;
//ResultSet	rs;
////	이 Dao를  new 시키면 드라이버 로딩, 커넥트.
//public NewMemberDao() {
//	db = new JDBCUtil();
//	con = db.getCON();
//}

//	닉네임, 이메일 중복체크.
//public ArrayList memberCheck(String nickname) {		
//	String sql = "SELECT usr_nickname FROM usr_table";	
//	ResultSet rs = stmt.executeQuery(sql);
//	try {
//		stmt.setString(nick);
//		ResultSet rs = pstmt.executeQuery();
//
//		while(rs.next()) {
//			NewMemberVo	nvo = new NewMemberVo();
//			nvo.setNewNickname(String newNickname) = rs.getString("usr_nickname");
//			
//			list.add(nvo);
//		}
//	}
//	catch(Exception e) {}
//	return list;
//}
//	
//	if(rs.next()) {
//		NewMemberVo nvo = new NewMemberVo();
//		nvo.newNickname = rs.getString("nickname");
//		
//		list.add(nvo);
//				
//	}
	
//	return "";
//	
//}


//public void insertMember(String newNickname ,String newPassword, String newEmail, String newUserNo) {
//		사용자가 입력한 데이터 받아서 테이블에 넣는 작업
//	String sql = NewMemberSql.getSQL(NewMemberSql.SELECT_NICK);
//	String sql1 = "SELECT * FROM user_table WHERE usr_nickname=? AND usr_password=? AND usr_ename=? AND usr_no=?";		
//	pstmt = db.getPSTMT(con, sql);
//	try {
//		pstmt.setString(1,  newNickname);
//		
//		rs = pstmt.executeQuery();
//		
//		rs.next();
//		NewMemberVo	nvo = new NewMemberVo();
//		int tmpNo = rs.getInt(0);
//		
//		if(tmpNo > 0) { 				
//		} else {}
//	}
//	catch(Exception e) {System.out.println("회원가입에러: "+e);}
//}
//
//public void close() {
//	// TODO Auto-generated method stub
//	
//}
//}

//public ArrayList getNewMemberForm() {
//	String sql = NewMemberSql.getSQL(1);
//	String sql = "SELECT * FROM user_table WHERE usr_nickname=? AND usr_ename=? AND usr_password=?";
	//	입력결과를 컬렉션에 기억하는 작업
//	ArrayList list = new ArrayList();
//	try {
//		stmt = db.getSTMT(con);
//		ResultSet rs = stmt.executeQuery(sql);
//		while(rs.next()) {
//			NewMemberVo	nvo = new NewMemberVo();
//			nvo.setNewEmail(rs.getString("Email"));
//			nvo.setNewNickname(rs.getString("Nickname"));
//			nvo.setNewPassword(rs.getString("Password"));
//			nvo.setNewUserNo(rs.getString("UserNo"));
//			
//			list.add(nvo);
//		}
//	}
//	catch(Exception e) {
//		System.out.println("리스트 예외: " +e);
//	}
//	return list;			
//	
//}
//}