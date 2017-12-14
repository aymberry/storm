package STSql;

public class CommentSql 
{
	public	static	final	int	GET_GOODS_COMMENT_COUNT=1111,
											GET_REVIEW_COMMENT_COUNT=1112,
											GET_REVIEW_COMMENTS=12314,
											INSERT_INTO_NEW_COMMENT=3412;
	
	public static	String	getSQL(int command)
	{
		StringBuilder	sb	=	new StringBuilder();
		
		switch(command)
		{
			case	GET_GOODS_COMMENT_COUNT:
				sb.append("	SELECT 	COUNT(g_no)	as	cnt	");
			    sb.append("		FROM	REVIEW_TABLE	");
			    sb.append("		WHERE   g_no    =   ?	");
				break;
			case	GET_REVIEW_COMMENT_COUNT:
				sb.append("	SELECT  count(COMNT_text)	");
				sb.append("		FROM    COMMENT_TABLE	");
				sb.append("		WHERE   g_no=?			");
				break;
				
			// 특정 리뷰의 댓글들을 조회하는 SQL
			case	GET_REVIEW_COMMENTS:
				sb.append("	SELECT	");
				sb.append("		(   SELECT  g.g_name																");
				sb.append("			FROM    goods_table g															");
				sb.append("			WHERE   g.g_no=c.g_no														");
				sb.append("		)         										AS  GOODS_NAME,					");
				sb.append("		c.G_NO										AS  GOODS_NO,						");
				
				sb.append("		(																								");
				sb.append("			SELECT  u.usr_nickname														");
				sb.append("			FROM    USER_TABLE u															");
				sb.append("			WHERE   u.usr_no = c.USR_NO												");
				sb.append("		)												AS  ORGIN_USER_NAME,			");
				sb.append("		c.USR_NO  								AS  ORGIN_USER_NO,				");
				
				sb.append("		(																								");
				sb.append("			SELECT  us.usr_nickname														");
				sb.append("			FROM    user_Table  us															");
				sb.append("			WHERE   us.usr_no   = c.COMNT_USR_NO								");
				sb.append("		)               								AS  COMMENT_WRITER_NAME,	");
				sb.append("		c.COMNT_USR_NO    				AS  COMMENT_WRITER_NO,		");				
				sb.append("		C.COMNT_TEXT    						AS  CONTENT,							");
				sb.append("		C.COMNT_WDATE  				 	AS  WRITE_DATE						");
				sb.append("	FROM    comment_table c																");
				sb.append("	WHERE   c.g_no=?  AND c.usr_no=?												");
				break;
			case	INSERT_INTO_NEW_COMMENT:
				sb.append("		INSERT												");
				sb.append("			INTO												");
				sb.append("				COMMENT_TABLE						");
				sb.append("			VALUES( ?, ?,  ?, ?, SYSDATE )		");
				break;
		}				
		return sb.toString();
	}
}
