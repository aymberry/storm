package STSql;

public class CommuSql {
	public static final int GET_TOTAL = 1101 ; // 커뮤니티 총개수
	public static final int GET_COMMULIST =1102 ; // 커뮤니티리스트
	public static final int GET_COMMUNO = 1103; //커뮤니티 넘버구하기
	public static final int INSERT_COMMUNITY = 1104; // 커뮤니티만들기
	public static final int INSERT_MAP_COMMU_USR =1105; // 맵테이블인서트
	public static final int GET_COMMUVIEWLIST = 1106; //커뮤니티 상세보기 정보
	public static final int GET_ISSHOW = 1107; // 커뮤니티를 팔로우한 유저가 있는지
//	public static final int UPDATE_ISSHOW =1108; // 팔로우하기
	public static final int GET_MAP_COMMU_USR=1108; // 맵테이블에 있는지
	public static final int DO_FOLLOW =1109;	//팔로우하기
	public static final int DO_UNFOLLOW=1110;	//팔로우취소하기
	public static final int GET_REVIEWINCOMMU = 1111; //커뮤니티 안의 상품평 출력
	public static String getSQL(int code) {
		StringBuffer	buff = new StringBuffer();
		switch(code) {
		case	GET_TOTAL:
			buff.append("SELECT ");
			buff.append("		COUNT(*) AS CNT ");
			buff.append("FROM ");
			buff.append("		Community_Table ");
			break;
		case	GET_COMMULIST:
			buff.append("SELECT ");
			buff.append("		commu_no		AS commuNo, ");
			buff.append("		commu_name		AS commuName, ");
			buff.append("		commu_text		AS commuText, ");
			buff.append("		commu_img_name	AS commuImgName, ");
			buff.append("		commu_usr_no	AS commuUsrNo ");
			buff.append("FROM ");
			buff.append("		Community_table ");
			buff.append("ORDER BY ");
			buff.append("		commu_no DESC ");
			//isshow가 Y인거 조건 추가
			break;
		case GET_COMMUNO:
			buff.append("select ");
			buff.append("(nvl(max(commu_no),0)+1) AS CNT ");
			buff.append("from community_table ");
			break;
		case	INSERT_COMMUNITY:
			buff.append("INSERT ");
			buff.append("INTO ");
			buff.append("		Community_table ");
			buff.append("(COMMU_NO, COMMU_NAME, COMMU_TEXT, COMMU_IMG_NAME, COMMu_USR_NO) ");
			buff.append("VALUES ");
			buff.append("		(?, ?, ?, ?, ?) ");
			break;
		case INSERT_MAP_COMMU_USR:
			buff.append("INSERT ");
			buff.append("INTO ");
			buff.append("		MAP_USR_COMMU ");
			buff.append("(COMMU_NO, usr_no, isshow) ");
			buff.append("VALUES ");
			buff.append("		(?, ?, 'Y') ");
			break;
		case	GET_COMMUVIEWLIST:
			buff.append("SELECT ");
			buff.append("		commu_no		AS commuNo, ");
			buff.append("		commu_name		AS commuName, ");
			buff.append("		commu_text		AS commuText, ");
			buff.append("		commu_img_name	AS commuImgName, ");
			buff.append("		commu_usr_no	AS commuUsrNo ");
			buff.append("FROM ");
			buff.append("		Community_table ");
			buff.append("Where ");
			buff.append("commu_no = ? ");
			buff.append("ORDER BY ");
			buff.append("		commu_no asc ");
			break;
		case GET_ISSHOW:
			buff.append("select ");
			buff.append("	isshow AS SHOW ");
			buff.append("from ");
			buff.append("	map_usr_commu ");
			buff.append("where ");
			buff.append("	commu_no = ? and ");
			buff.append("	usr_no = ? ");
			break;
//		case	UPDATE_ISSHOW:
//			buff.append("UPDATE ");
//			buff.append("		map_usr_commu ");
//			buff.append("SET ");
//			buff.append("		IsShow = '@' ");
//			buff.append(" WHERE ");
//			buff.append("		commu_no = ? ");
//			buff.append("		AND usr_no = ? ");
//			break;
		case	GET_MAP_COMMU_USR:
			buff.append("select ");
			buff.append("	commu_no ");
			buff.append("from ");
			buff.append("	map_usr_commu ");
			buff.append("where ");
			buff.append("	commu_no = ? and ");
			buff.append("	usr_no = ? ");
			break;
		case	DO_FOLLOW:
			buff.append("UPDATE ");
			buff.append("		map_usr_commu ");
			buff.append("SET ");
			buff.append("		IsShow = 'Y' ");
			buff.append(" WHERE ");
			buff.append("		commu_no = ? ");
			buff.append("		AND usr_no = ? ");
			break;
		case	DO_UNFOLLOW:
			buff.append("UPDATE ");
			buff.append("		map_usr_commu ");
			buff.append("SET ");
			buff.append("		IsShow = 'N' ");
			buff.append(" WHERE ");
			buff.append("		commu_no = ? ");
			buff.append("		AND usr_no = ? ");
			break;
//		case	GET_COMMULIST:
//			buff.append("SELECT ");
//			buff.append("		commu_no		AS commuNo, ");
//			buff.append("		commu_name		AS commuName, ");
//			buff.append("		commu_text		AS commuText, ");
//			buff.append("		commu_img_name	AS commuImgName, ");
//			buff.append("		comm_usr_no		AS commuUsrNo, ");
//			buff.append("FROM ");
//			buff.append("		Map_usr_commu ");
//			buff.append("WHERE ");
//			buff.append("		commu_no = ? ");
//			buff.append("ORDER BY ");
//			buff.append("		commu_no DESC ");
//			break;
		case GET_REVIEWINCOMMU:
			buff.append("SELECT ");
			buff.append("		gt.g_name as gname, ");
			buff.append("		gt.g_img_name as usrimgname, ");
			buff.append("		ut.USR_NICKNAME as nickname, ");
			buff.append("		rt.REVIEW_CONTENT as content, ");
			buff.append("		rt.REVIEW_SCORE as score ");
			buff.append("FROM ");
			buff.append("		 Goods_TABLE gt, ");
			buff.append("		 USeR_TABLE ut, ");
			buff.append("		 review_TABLE rt ");
			buff.append("Where ");
			buff.append("	rt.g_no = gt.g_no ");
			buff.append("	and  ( rt.review_wdate is not null ) ");
			buff.append("	and	rt.usr_no=ut.usr_no ");
			buff.append("	and	rt.usr_no in ");
			buff.append("	(select usr_no from Map_usr_commu where commu_no=? and isshow='Y') ");
			buff.append("ORDER BY ");
			buff.append("		gt.g_no ");
			break;
		}
		return buff.toString();
	}
}
