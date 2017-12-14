package STSql;

public class SalesSql {

	public static final int GET_TOTAL = 1;
	public static final int GET_DUPORDER = 2;
	public static final int SELECT_GOODLIST = 3;
	public static final int SELECT_GOODS = 4;
	public static final int INSERT_SALES = 5;
	public static final int SELECT_SALES = 6;

	public static String getSql(int code) {
		StringBuffer buff = new StringBuffer();

		switch (code) {
		case GET_TOTAL:
			buff.append("select ");
			buff.append("		count(*) as cnt ");
			buff.append("from ");
			buff.append("		sales_table ");
			break;
		case GET_DUPORDER:
			buff.append("insert into review_table ");
			buff.append("(g_no, usr_no,review_buydate) ");
			buff.append("values(?, ?, sysdate) ");
			break;
		case SELECT_GOODLIST:
			buff.append("select g_no as g_no, ");
			buff.append("  		  g_name as g_name, ");
			buff.append("  		  g_releasedate as g_releasedate, ");
			buff.append("		  g_price as g_price ");
			buff.append("from   goods_table ");
			buff.append("order by g_no ");
			break;
		case SELECT_GOODS:
			buff.append("select gt.g_no as g_no, ");
			buff.append("  		  gt.g_name as g_name, ");
			buff.append("  		  gt.g_releasedate as g_releasedate, ");
			buff.append("		  gt.g_price as g_price, ");
			buff.append("  		  gt.g_smalltext as g_smalltext, ");
			buff.append("  		  gt.g_bigtext as g_bigtext, ");
			buff.append("  		  gt.g_installfile_name as g_installfile_name, ");
			buff.append("  		  gt.g_os_name as g_os_name ");
			buff.append("from   goods_table gt ");
			buff.append("where gt.g_no = ? ");
			break;
		case INSERT_SALES:
			buff.append("insert into sales_table ");
			buff.append("( g_no,");
			buff.append("  usr_no,");
			buff.append("  sales_buydate, ");
			buff.append("  sales_qty, ");			
			buff.append("  sales_account, ");
			buff.append("  sales_bankname, ");
			buff.append("  payer ) ");
			buff.append("values (?, ?, sysdate, ?, ?, ?, ?) ");
			break;
		case SELECT_SALES:
			buff.append("select g_no as g_no, ");
			buff.append("  		  usr_no as usr_no,");
			buff.append("		  sales_buydate as sales_buydate,");
			buff.append("		  sales_qty as sales_qty,");
			buff.append("	      sales_account as sales_account, ");
			buff.append("		  sales_bankname as sales_bankname, ");
			buff.append("		  payer as payer ");
			buff.append("from   sales_table st ");
			buff.append("order by sales_buydate desc ");
			break;
		}
		return buff.toString();
	}

}
