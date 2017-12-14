package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*
 * 	이 클래스는 데이터베이스 작업이 필요하면
 * 	드라이버 로딩, 컨넥션, 스테이트먼트 등등... 기본 작업을 수행핼 줄
 * 	클래스이다.
 * 
 * 	우리가 앞에서 사용한 JDBCUtil와 동일한 역활인데...
 * 	다만 컨넥션 풀에서 잡아오는 기능이다.
 */
public class POOLUtil {
	//	1.	이 클래스는 new 시키는 순간 컨넥션 풀과 연결할 예정이다.
	public DataSource ds;	//	컨넥션 풀을 관리하는 클래스
	public POOLUtil() {
		try {
			//	1.	환경설정 파일을 관리할 클래스를 생성한다.
			//		컨넥션풀은 서버의 context.xml  파일에 준비해 놓았으므로
			//		이 context.xml(환경설정 파일)을 알아야 한다.
			//			사용 클래스 Context
			//			이 클래스는 인터페이스이므로 직접 new는 시키지 못하고
			//			대신 그 하위 클래스(InitialContext)를 이용해서 new 시킨다.
			Context	ct = new InitialContext();
			//	이처럼 new를 시키면 환경 설정 파일을 다 가지고 온다.
			//	2.	 환경 설정 파일 중에서 컨넥션 풀 부분을 알아낸다.
			ds = (DataSource) ct.lookup("java:/comp/env/jdbc/iedu");
			//	이렇게 하면 환경 설정 부분 중에서 이름이 jdbc/iedu인 부분을
			//	을 이용해서 컨넥션 풀을 관리하는 클래스를 알아낸다.	
		}
		catch(Exception e) {
			System.out.println("컨넥션 풀 생성 에러 = " + e);
		}
	}
	
	//	누군가가 Connection이 필요하면 알려주는 함수
	public Connection getCON() {
		Connection	con = null;
		try {
			con = ds.getConnection();
		}
		catch(Exception e) {
			System.out.println("컨넥션 획득 에러 = " + e);
		}
		return con;
	}
	
	
	public Statement getSTMT(Connection con) {
		Statement		stmt = null;
		try {
			stmt = con.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE, 
					ResultSet.CONCUR_READ_ONLY);
		}
		catch(Exception e) {
			System.out.println("Statement 생성 에러 = " + e);
		}
		return stmt;
	}
	//	누군가가 PrepardStatement 를 만들어 달라고 하면
	//	대신 만들어줄 함수
	public PreparedStatement getPSTMT(Connection con, String sql) {
		PreparedStatement	pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
		}
		catch(Exception e) {
			System.out.println("PreparedStatement 생성 에러 = " + e);
		}
		return pstmt;
	}
	
	//	누군가가 자원을 닫을 필요가 있으면 대신 닫아줄 함수
	public void close(Object target) {
		try {
			if(target instanceof ResultSet) {
				ResultSet	temp = (ResultSet) target;
				temp.close();
			}
			else if(target instanceof Statement) {
				Statement	temp = (Statement) target;
				temp.close();
			}
			else if(target instanceof PreparedStatement) {
				PreparedStatement temp = (PreparedStatement) target;
				temp.close();
			}
			else if(target instanceof Connection) {
				Connection	temp = (Connection) target;
				temp.close();
			}
		}
		catch(Exception e) {}
	}
	
	
}



