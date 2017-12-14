package STSql;

public class GoodsSql 
{
	public final static int	ALL_GOODS_LIST=1111,
										GET_GOODS_DETAIL=2222,
										GET_GAME_GOODS_LIST=3333,
										GET_SOFTWARE_GOODS_LIST=1444,
										GET_REVIEW_WRITABLE=55555,
										GET_RRECENTLY_RELEASED=333,
												GET_RECENTLIST=1666,
												GET_RANDOMLIST=1777;

	
	public static String getSQL(int command)
	{
		StringBuilder sb = new StringBuilder();
		
		switch(command)
		{
			case	GET_RRECENTLY_RELEASED:
				sb.append("	SELECT																				");
				sb.append("		gt.G_NO  							AS		no,							"); 
				sb.append("		gt.G_NAME  						AS  		name,						");   
				sb.append("		gt.GTYPE_NO    				AS		TYPE_NO,					");    
				sb.append("		gt.G_REGISTDATE    			AS		REGISTDATE,				"); 
				sb.append("		gt.G_RELEASEDATE   		AS		RELEASEDATE,			");    
				sb.append("		gt.G_PRICE 						AS		PRICE,						");  
				sb.append("		gt.G_SMALLTEXT 				AS		SMALLTEXT,				");   
				sb.append("		gt.G_BIGTEXT   				AS		BIGTEXT,					");
				sb.append("		gt.G_INSTALLFILE_NAME	AS		INSTALLFILENAME,		");
				sb.append("		gt.G_OS_NAME   				AS		OS_NAME,				");
				sb.append("		(		SELECT	g.GTYPE_NAME											");
				sb.append("				FROM	GOODSTYPE_TABLE g								");
				sb.append("				WHERE g.gtype_no = gt.gtype_no 						");
				sb.append("		)										AS		TYPE							");
				sb.append("		from																				");
				sb.append("		(																					");
				sb.append("		select  *																		");
				sb.append("		from																				");
				sb.append("		goods_table																	"); 
				sb.append("		order by G_RELEASEDATE desc										");
				sb.append("		)																					");
				sb.append("						    where														");
				sb.append("		rownum<4																	");
				break;
			case	GET_REVIEW_WRITABLE:
				sb.append("		SELECT  NVL ( TO_CHAR ( review_wdate ) , 'Y' ) AS WRITABLE	");
				sb.append("			FROM    review_table    												");
				sb.append("			WHERE    	  	g_no=?													");
				sb.append("						AND usr_no=?												");
				sb.append("						AND REVIEW_CONTENT IS NULL 					");
				break;
			case	GET_SOFTWARE_GOODS_LIST:
				sb.append("	SELECT																				");
				sb.append("		gt.G_NO  							AS		no,							"); 
				sb.append("		gt.G_NAME  						AS  		name,						");   
				sb.append("		gt.GTYPE_NO    				AS		TYPE_NO,					");    
				sb.append("		gt.G_REGISTDATE    			AS		REGISTDATE,				"); 
				sb.append("		gt.G_RELEASEDATE   		AS		RELEASEDATE,			");    
				sb.append("		gt.G_PRICE 						AS		PRICE,						");  
				sb.append("		gt.G_SMALLTEXT 				AS		SMALLTEXT,				");   
				sb.append("		gt.G_BIGTEXT   				AS		BIGTEXT,					");
				sb.append("		gt.G_INSTALLFILE_NAME	AS		INSTALLFILENAME,		");
				sb.append("		gt.G_OS_NAME   				AS		OS_NAME,				");
				sb.append("		(		SELECT	g.GTYPE_NAME											");
				sb.append("				FROM	GOODSTYPE_TABLE g								");
				sb.append("				WHERE g.gtype_no = gt.gtype_no 						");
				sb.append("		)										AS		TYPE							");
				sb.append("		FROM																			");
				sb.append("			GOODS_TABLE gt														");
				sb.append("		WHERE	gt.GTYPE_NO=2												");
				break;
			case	GET_GAME_GOODS_LIST:
				sb.append("	SELECT		");
				sb.append("		G_NO    AS  							no,		"); 
				sb.append("		G_NAME  AS  						name,	");   
				sb.append("		GTYPE_NO    AS  					TYPE_NO,	");    
				sb.append("		G_REGISTDATE    AS 			REGISTDATE,	"); 
				sb.append("		G_RELEASEDATE   AS  			RELEASEDATE,	");    
				sb.append("		G_PRICE AS  						PRICE,	");  
				sb.append("		G_SMALLTEXT AS 					SMALLTEXT,	");   
				sb.append("		G_BIGTEXT   AS  					BIGTEXT,	");
				sb.append("		G_INSTALLFILE_NAME  AS		INSTALLFILENAME,	");
				sb.append("		G_OS_NAME   AS  				OS_NAME,	");
				sb.append("		(		SELECT	g.GTYPE_NAME											");
				sb.append("				FROM	GOODSTYPE_TABLE g								");
				sb.append("				WHERE g.gtype_no = gt.gtype_no 						");
				sb.append("		)										AS		TYPE							");
				sb.append("		FROM	");
				sb.append("			GOODS_TABLE	gt	");
				sb.append("		WHERE	GTYPE_NO=1	");
				break;
			case ALL_GOODS_LIST:
				sb.append("	SELECT		");
				sb.append("		G_NO    AS  							no,		"); 
				sb.append("		G_NAME  AS  						name,	");   
				sb.append("		GTYPE_NO    AS  					TYPE_NO,	");    
				sb.append("		G_REGISTDATE    AS 			REGISTDATE,	"); 
				sb.append("		G_RELEASEDATE   AS  			RELEASEDATE,	");    
				sb.append("		G_PRICE AS  						PRICE,	");  
				sb.append("		G_SMALLTEXT AS 					SMALLTEXT,	");   
				sb.append("		G_BIGTEXT   AS  					BIGTEXT,	");
				sb.append("		G_img_name  AS		imgname,	");
				sb.append("		G_INSTALLFILE_NAME  AS		INSTALLFILENAME,	");
				sb.append("		G_OS_NAME   AS  				OS_NAME,	");
				sb.append("		(		SELECT	g.GTYPE_NAME											");
				sb.append("				FROM	GOODSTYPE_TABLE g								");
				sb.append("				WHERE g.gtype_no = gt.gtype_no 						");
				sb.append("		)										AS		TYPE							");
				sb.append("		FROM	");
				sb.append("		GOODS_TABLE	gt	");
				sb.append("		order by g_no desc	");
				break;
			case GET_RECENTLIST:
				sb.append("	SELECT		");
				sb.append("		G_NO    AS  							no,		"); 
				sb.append("		G_NAME  AS  						name,	");   
				sb.append("		GTYPE_NO    AS  					TYPE_NO,	");    
				sb.append("		G_REGISTDATE    AS 			REGISTDATE,	"); 
				sb.append("		G_RELEASEDATE   AS  			RELEASEDATE,	");    
				sb.append("		G_PRICE AS  						PRICE,	");  
				sb.append("		G_SMALLTEXT AS 					SMALLTEXT,	");   
				sb.append("		G_BIGTEXT   AS  					BIGTEXT,	");
				sb.append("		G_img_name  AS		imgname,	");
				sb.append("		G_INSTALLFILE_NAME  AS		INSTALLFILENAME,	");
				sb.append("		G_OS_NAME   AS  				OS_NAME,	");
				sb.append("		(		SELECT	g.GTYPE_NAME											");
				sb.append("				FROM	GOODSTYPE_TABLE g								");
				sb.append("				WHERE g.gtype_no = gt.gtype_no 						");
				sb.append("		)										AS		TYPE							");
				sb.append("		FROM	");
				sb.append("		GOODS_TABLE	gt	");
				sb.append("			order by	");
				sb.append("				gt.g_releasedate desc	");
				break;
			case GET_RANDOMLIST:
				sb.append("	SELECT 	");
				sb.append("		G_NO    AS  							no,		"); 
				sb.append("		G_NAME  AS  						name,	");   
				sb.append("		GTYPE_NO    AS  					TYPE_NO,	");    
				sb.append("		G_REGISTDATE    AS 			REGISTDATE,	"); 
				sb.append("		G_RELEASEDATE   AS  			RELEASEDATE,	");    
				sb.append("		G_PRICE AS  						PRICE,	");  
				sb.append("		G_SMALLTEXT AS 					SMALLTEXT,	");   
				sb.append("		G_BIGTEXT   AS  					BIGTEXT,	");
				sb.append("		G_INSTALLFILE_NAME  AS		INSTALLFILENAME,	");
				sb.append("		G_img_name  AS		imgname,	");
				sb.append("		G_OS_NAME   AS  				OS_NAME	");
				sb.append("		FROM	");
				sb.append("		(select * from goods_table ");
				sb.append("		order by dbms_random.value) ");
				sb.append(" 	where  rownum <= 5 ");
				break;
			case	GET_GOODS_DETAIL:
				sb.append("	SELECT		");
				sb.append("		G_NO    AS  			no,		"); 
				sb.append("		G_NAME  AS  			name,	");   
				sb.append("		GTYPE_NO    AS  		TYPE_NO,	");    
				sb.append("		G_REGISTDATE    AS 		REGISTDATE,	"); 
				sb.append("		G_RELEASEDATE   AS  	RELEASEDATE,	");    
				sb.append("		G_PRICE AS  			PRICE,	");  
				sb.append("		G_SMALLTEXT AS 			SMALLTEXT,	");   
				sb.append("		G_BIGTEXT   AS  		BIGTEXT,	");
				sb.append("		G_img_name  AS		imgname,	");
				sb.append("		G_INSTALLFILE_NAME  AS	INSTALLFILENAME,	");
				sb.append("		G_OS_NAME   AS  		OS_NAME	");
				sb.append("		FROM	");
				sb.append("			GOODS_TABLE	");
				sb.append(" 	WHERE G_NO = ? ");
				break;
		}
		
		return sb.toString();
	}
}
