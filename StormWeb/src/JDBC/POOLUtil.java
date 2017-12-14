package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/*
 * 	�� Ŭ������ �����ͺ��̽� �۾��� �ʿ��ϸ�
 * 	����̹� �ε�, ���ؼ�, ������Ʈ��Ʈ ���... �⺻ �۾��� ������ ��
 * 	Ŭ�����̴�.
 * 
 * 	�츮�� �տ��� ����� JDBCUtil�� ������ ��Ȱ�ε�...
 * 	�ٸ� ���ؼ� Ǯ���� ��ƿ��� ����̴�.
 */
public class POOLUtil {
	//	1.	�� Ŭ������ new ��Ű�� ���� ���ؼ� Ǯ�� ������ �����̴�.
	public DataSource ds;	//	���ؼ� Ǯ�� �����ϴ� Ŭ����
	public POOLUtil() {
		try {
			//	1.	ȯ�漳�� ������ ������ Ŭ������ �����Ѵ�.
			//		���ؼ�Ǯ�� ������ context.xml  ���Ͽ� �غ��� �������Ƿ�
			//		�� context.xml(ȯ�漳�� ����)�� �˾ƾ� �Ѵ�.
			//			��� Ŭ���� Context
			//			�� Ŭ������ �������̽��̹Ƿ� ���� new�� ��Ű�� ���ϰ�
			//			��� �� ���� Ŭ����(InitialContext)�� �̿��ؼ� new ��Ų��.
			Context	ct = new InitialContext();
			//	��ó�� new�� ��Ű�� ȯ�� ���� ������ �� ������ �´�.
			//	2.	 ȯ�� ���� ���� �߿��� ���ؼ� Ǯ �κ��� �˾Ƴ���.
			ds = (DataSource) ct.lookup("java:/comp/env/jdbc/iedu");
			//	�̷��� �ϸ� ȯ�� ���� �κ� �߿��� �̸��� jdbc/iedu�� �κ���
			//	�� �̿��ؼ� ���ؼ� Ǯ�� �����ϴ� Ŭ������ �˾Ƴ���.	
		}
		catch(Exception e) {
			System.out.println("���ؼ� Ǯ ���� ���� = " + e);
		}
	}
	
	//	�������� Connection�� �ʿ��ϸ� �˷��ִ� �Լ�
	public Connection getCON() {
		Connection	con = null;
		try {
			con = ds.getConnection();
		}
		catch(Exception e) {
			System.out.println("���ؼ� ȹ�� ���� = " + e);
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
			System.out.println("Statement ���� ���� = " + e);
		}
		return stmt;
	}
	//	�������� PrepardStatement �� ����� �޶�� �ϸ�
	//	��� ������� �Լ�
	public PreparedStatement getPSTMT(Connection con, String sql) {
		PreparedStatement	pstmt = null;
		try {
			pstmt = con.prepareStatement(sql);
		}
		catch(Exception e) {
			System.out.println("PreparedStatement ���� ���� = " + e);
		}
		return pstmt;
	}
	
	//	�������� �ڿ��� ���� �ʿ䰡 ������ ��� �ݾ��� �Լ�
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



