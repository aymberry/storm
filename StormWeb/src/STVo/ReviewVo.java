package STVo;

import java.sql.Date;
import java.util.ArrayList;

public class ReviewVo 
{
	public	int		goods_no;
	public	String	goods_name;
	
	public	int		user_no;
	public	String	user_nickname;
	
	public	Date		buy_date;
	public	Date		wdate;
	public	String	content;
	public	String	score;
	
	public	int		commentCnt;
	
	@SuppressWarnings("rawtypes")
	public ArrayList	commentList;

	public ArrayList getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList commentList) {
		this.commentList = commentList;
	}

	public int getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_nickname() {
		return user_nickname;
	}

	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	public Date getBuy_date() {
		return buy_date;
	}

	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}
	
}	
