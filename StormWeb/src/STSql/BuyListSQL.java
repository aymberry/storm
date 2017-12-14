package STSql;

public class BuyListSQL {
	public static final int  CHECK_PURCHASE_PRODUCT= 5001; //구매목록 조회
	public static final int  GET_TOTAL= 5002; //구매목록 총개수
	public static String getSQL(int code) {
		StringBuffer	buff = new StringBuffer();
		switch(code) {
		case CHECK_PURCHASE_PRODUCT:
			buff.append("SELECT ");
			buff.append("		gt.g_no as g_no, " );
			buff.append("		gt.g_name as g_name, " );
			buff.append("		gt.g_price as g_price, " );
			buff.append("		st.sales_buydate as sales_buydate " );
			buff.append("FROM ");
			buff.append("		goods_table gt,  ");
			buff.append("		sales_table st  ");
			buff.append("WHERE ");
			buff.append("		gt.g_no = st.g_no ");
			buff.append("		and	   st.usr_no = ? " );
//			buff.append("			and    gt.g_no  = ? " );
			break;
		case	GET_TOTAL:
			buff.append("SELECT ");
			buff.append("		COUNT(*) AS CNT " );
			buff.append("FROM ");
			buff.append("		SALES_TABLE " );
			break;
		}
		return buff.toString();
	}
}
