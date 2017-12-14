package STSql;

public class STLoginSQL {
	// SELECT 질의 명령
	public static final int SELECT_MEMBER = 1001;
	
	// INSERT 질의 명령
	
	// UPDATE 질의 명령
	
	// DELETE 질의 명령
	
	public static String getSQL(int sqlNO){
		StringBuffer buff = new StringBuffer();
		switch (sqlNO){
		case SELECT_MEMBER:
			buff.append("SELECT ");
			buff.append(" usr_no no, usr_ename ename, usr_nickname nick ");
			buff.append("FROM ");
			buff.append("	user_table ");
			buff.append("WHERE ");
			buff.append("	usr_ename = ? ");
			buff.append("	AND usr_password = ? ");
			break;
		
		}
		
		return "" + buff ;
	}
	
}
