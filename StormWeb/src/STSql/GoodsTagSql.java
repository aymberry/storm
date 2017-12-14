package STSql;

public class GoodsTagSql 
{
	public static final int	GET_TAG_OF_GOODS=1;
	
	
	public static String	getSQL	(int command)
	{
		StringBuilder	sb	=	new StringBuilder();
		
		switch(command)
		{
			case	GET_TAG_OF_GOODS:
				sb.append("	SELECT  GTAG_NAME	AS	TAG_NAME, "
						+ "			GTAG_NO		AS	TAG_NO	");
			    sb.append("		FROM    GOODSTAG_TABLE	");
			    sb.append("		WHERE   gtag_no  in   (   SELECT   gtag_no	");
			    sb.append("									FROM    MAP_GOODS_TAG	");
			    sb.append("		                            WHERE   g_no = ? )	");
				break;
		}		
		return sb.toString();
	}
}
