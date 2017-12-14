package STSql;

public class GoodsTypeSql 
{
	public	 final		static	int	MATCH_GOODS_TYPE=1;
	
	public	static String getSQL(int command)
	{
		StringBuilder	sb	=	new StringBuilder();
		
		switch	(command)
		{
			case	MATCH_GOODS_TYPE:
				sb.append("SELECT  g.gtype_name	AS TYPE_NAME ");
				sb.append("	FROM    GoodsType_Table g, Goods_Table gt	");
				sb.append("	WHERE   gt.gtype_no=?	");
				sb.append(" 		AND"
						+ "			gt.gtype_no	= g.gtype_no");
				break;
		}
		return sb.toString();
	}
}	
