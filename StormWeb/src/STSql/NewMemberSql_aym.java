package STSql;

public class NewMemberSql_aym {
	
	public static final int INSERT_NEW = 1001;
	public static final int SELECT_NICK = 2001;
	public static final int SELECT_USR_ALL = 2002;
	public static final int SELECT_OLDEMAIL = 2003;
	public static final int SELECT_OLDNICK = 2004;


	public static String getSQL(int code) {
		StringBuffer buff = new StringBuffer();

		switch (code) {
		case	2003:
			buff.append("SELECT ");
			buff.append("	COUNT(*) AS CNT ");
			buff.append("FROM ");
			buff.append("	USER_TABLE ");
			buff.append("WHERE ");
			buff.append("	usr_ename = ? ");
			break;

		case	2004:
			buff.append("SELECT ");
			buff.append("	COUNT(*) AS CNT ");
			buff.append("FROM ");
			buff.append("	USER_TABLE ");
			buff.append("WHERE ");
			buff.append("	usr_nickname = ? ");
			break;
			
		case	1001:
			buff.append("INSERT ");
			buff.append("INTO ");
			buff.append("		USER_TABLE ");
			buff.append("VALUES ");
			buff.append("		( (SELECT NVL(MAX(usr_no), 0) + 1 FROM USER_TABLE), ");
			buff.append("		?,?,?,SYSDATE,SYSDATE,'usr_img_pass','usr_img_name') ");
			break;

			
			
			
			//			buff.append("INSERT ");
//			buff.append("INTO ");
//			buff.append("	USER_TABLE ");
//			buff.append("VALUES ");
//			buff.append("(usr_nickname,usr_password,usr_ename);");
//			buff.append("COMMIT;");
//			break;
		
		
		
		case SELECT_NICK:
			buff.append("SELECT ");
			buff.append("	count(*) ");
			buff.append("FORM ");
			buff.append("	USER_TABLE ");
			buff.append("WHERE ");
			buff.append("	USR_NICKNAME = ? ");

			break;
		case SELECT_USR_ALL:
			buff.append("SELECT ");
			buff.append("	* ");
			buff.append("FORM ");
			buff.append("	USER_TABLE ");

			break;
		}

		return "" + buff;
	}

}
