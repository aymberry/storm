package STSql;

public class ReviewSql 
{
	public final static int	GET_USERs_REVIEW_COUNT	=	1111,
										GET_USERs_GOODS_COUNT	=	3331,
										GET_USERS_REVIEW_LIST	=	444,
										GET_USERs_GOODS_LIST	=	1244,
										GET_GOODS_REVIEW_COUNT	=	2222,
										GET_GOODS_REVIEW_LIST	=	1234,
										GET_REVIEW_DETAIL=5555,
										UPDATE_NEW_REVIEW=4412;
	
	public	static	String	getSQL(int command)
	{
		StringBuilder sb = new StringBuilder();
		
		switch(command)
		{
			case	UPDATE_NEW_REVIEW:
				sb.append("		UPDATE												");
				sb.append("			REVIEW_TABLE								");
				sb.append("		SET													");
				sb.append("			REVIEW_WDATE	=   SYSDATE,		");
				sb.append("			REVIEW_CONTENT=   ?,				");
				sb.append("			REVIEW_SCORE    =   ?					");
				sb.append("		WHERE												");
				sb.append("			G_NO    =   ?								");
				sb.append("			AND USR_NO= ?							");
				break;
			case	GET_REVIEW_DETAIL:
				sb.append("	SELECT	");
				sb.append("		r.G_no					AS  GOODS_NO,		");			
				sb.append("		r.usr_no				AS  USER_NO,			");	
			    sb.append("		(															");
				sb.append("			SELECT gt.g_name							");					
				sb.append("				from GOODS_TABLE gt					");			
				sb.append("				WHERE gt.g_no=r.g_no					");
				sb.append("		)  		       				AS GOODS_NAME,	");		
				sb.append("		(															");
				sb.append("			SELECT u.usr_NICKNAME					");			
				sb.append("				FROM    USER_TABLE u					");		
				sb.append("				WHERE   u.usr_no = r.usr_no		");
				sb.append("		)               				AS  USR_NICK,		");				
				sb.append("		r.REVIEW_BUYDATE	AS	BuyDATE,		"); 
				sb.append("		r.REVIEW_WDATE		AS	writeDate,		"); 
				sb.append("		r.REVIEW_CONTENT	AS	CONTENT,		");
				sb.append("		r.REVIEW_SCORE		AS	score			");
				sb.append("	FROM    REVIEW_TABLE r							");
				sb.append("	WHERE   r.g_no =  ? AND r.usr_no=?			");
				break;
			case	GET_USERS_REVIEW_LIST:
				sb.append("	SELECT	");
				sb.append("		r.G_no    As  GOODS_NO,			");
				sb.append("		r.usr_no  AS  USER_NO,			");
				sb.append("		(SELECT g_name					");
				sb.append("			from GOODS_TABLE gt			");
				sb.append("			WHERE gt.g_no=r.g_no)  		");
				sb.append("					AS GOODS_NAME,		");
				sb.append("		(SELECT u.usr_NICKNAME			");
				sb.append("			FROM    USER_TABLE u		");
				sb.append("			WHERE   u.usr_no = r.usr_no)");
				sb.append("			AS  USR_NICK,				");
				sb.append("		r.REVIEW_BUYDATE    as  BuyDATE, ");
				sb.append("		r.REVIEW_WDATE      as  writeDate, ");
				sb.append("		r.REVIEW_CONTENT    as  CONTENT,	");
				sb.append("		r.REVIEW_SCORE      as  score		");   
				sb.append("	FROM    REVIEW_TABLE r				");
				sb.append("	WHERE   r.usr_no = ?	AND r.REVIEW_WDATE IS NOT NULL		");
				break;
			
			case	GET_GOODS_REVIEW_LIST:
				sb.append("	SELECT	");
				sb.append("		r.g_no    As  GOODS_NO,								");
				sb.append("		r.usr_no  AS  USER_NO,								");
				sb.append("		(	SELECT gt.g_name									");
				sb.append("			from GOODS_TABLE gt								");
				sb.append("			WHERE gt.g_no=r.g_no ) 							");
				sb.append("											AS GOODS_NAME,	");
				sb.append("		(	SELECT u.usr_NICKNAME							");
				sb.append("			FROM    USER_TABLE u								");
				sb.append("			WHERE   u.usr_no = r.usr_no )					");
				sb.append("											AS  USR_NICK,			");
				sb.append("		r.REVIEW_BUYDATE		as  BuyDATE,	 			");
				sb.append("		r.REVIEW_WDATE			as  writeDate, 			");
				sb.append("		r.REVIEW_CONTENT		as  CONTENT,			");
				sb.append("		r.REVIEW_SCORE			as  score					");   
				sb.append("	FROM    REVIEW_TABLE r									");
				sb.append("	WHERE   r.g_no = ?		AND r.REVIEW_WDATE IS NOT NULL		");
				
				break;
			
			case	GET_USERs_REVIEW_COUNT:
				sb.append("	SELECT	COUNT(review_content)	as cnt	");
				sb.append("		FROM	REVIEW_TABLE				");
				sb.append("		WHERE	usr_no	=	?				");
				break;
			case	GET_GOODS_REVIEW_COUNT:
				sb.append("	SELECT  COUNT(g_no)			");  
				sb.append("		from    REVIEW_TABLE	");
				sb.append("		where   g_no    =   ?	");
				break;
			case	GET_USERs_GOODS_COUNT:
				sb.append("	SELECT	COUNT(g_no)	as cnt	");
				sb.append("		FROM	REVIEW_TABLE	");
				sb.append("	WHERE	usr_no	=	?		");
				break;
			
		}
		
		
		return sb.toString();
	}
}
