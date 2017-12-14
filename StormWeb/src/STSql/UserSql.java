package STSql;

public class UserSql 
{
	public final static int	GET_USER_NO=1111;
	
	public static String	getSql(int command)
	{
		StringBuilder	sb	=	new StringBuilder();
		
		switch(command)
		{
			case	GET_USER_NO:
				sb.append("select  usr_no as usr_no  from    user_table  where USR_ENAME=? ");
				break;
		}
		
		return sb.toString();
	}
}
