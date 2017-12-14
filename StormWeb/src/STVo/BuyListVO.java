package STVo;

import java.sql.Date;

public class BuyListVO {
	public int g_no; 			//구매번호
	public String g_name; 	//상품이름
	public int g_price;		// 상품 가격
	public Date sales_buydate ; 	//구매날짜
	
	public int getG_no() {
		return g_no;
	}
	public void setG_no(int g_no) {
		this.g_no = g_no;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public int getG_price() {
		return g_price;
	}
	public void setG_price(int g_price) {
		this.g_price = g_price;
	}
	public Date getSales_buydate() {
		return sales_buydate;
	}
	public void setSales_buydate(Date sales_buydate) {
		this.sales_buydate = sales_buydate;
	}
	
}
