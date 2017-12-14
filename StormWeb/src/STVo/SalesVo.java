package STVo;

import java.sql.Date;

public class SalesVo {

	/* 상품 변수 */
	public String g_name;
	public Date g_releasedate;
	public int g_price;
	public String g_smalltext;
	public String g_bigtext;
	public String g_installfile_name;
	public String g_os_name;

	public String getG_name() {
		return g_name;
	}

	public void setG_name(String g_name) {
		this.g_name = g_name;
	}

	public Date getG_releasedate() {
		return g_releasedate;
	}

	public void setG_releasedate(Date g_releasedate) {
		this.g_releasedate = g_releasedate;
	}

	public int getG_price() {
		return g_price;
	}

	public void setG_price(int g_price) {
		this.g_price = g_price;
	}

	public String getG_smalltext() {
		return g_smalltext;
	}

	public void setG_smalltext(String g_smalltext) {
		this.g_smalltext = g_smalltext;
	}

	public String getG_bigtext() {
		return g_bigtext;
	}

	public void setG_bigtext(String g_bigtext) {
		this.g_bigtext = g_bigtext;
	}

	public String getG_installfile_name() {
		return g_installfile_name;
	}

	public void setG_installfile_name(String g_installfile_name) {
		this.g_installfile_name = g_installfile_name;
	}

	public String getG_os_name() {
		return g_os_name;
	}

	public void setG_os_name(String g_os_name) {
		this.g_os_name = g_os_name;
	}

	/* 결제 변수 */
	public int g_no;
	public int usr_no;
	public Date sales_buydate;
	public int sales_qty;
	public String sales_account;
	public String sales_bankname;
	public String payer;

	public int getG_no() {
		return g_no;
	}

	public void setG_no(int g_no) {
		this.g_no = g_no;
	}

	public int getUsr_no() {
		return usr_no;
	}

	public void setUsr_no(int usr_no) {
		this.usr_no = usr_no;
	}

	public Date getSales_buydate() {
		return sales_buydate;
	}

	public void setSales_buydate(Date sales_buydate) {
		this.sales_buydate = sales_buydate;
	}

	public int getSales_qty() {
		return sales_qty;
	}

	public void setSales_qty(int sales_qty) {
		this.sales_qty = sales_qty;
	}

	public String getSales_account() {
		return sales_account;
	}

	public void setSales_account(String sales_account) {
		this.sales_account = sales_account;
	}

	public String getSales_bankname() {
		return sales_bankname;
	}

	public void setSales_bankname(String sales_bankname) {
		this.sales_bankname = sales_bankname;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

}
