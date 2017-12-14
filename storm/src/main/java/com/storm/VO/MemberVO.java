package com.storm.VO;

public class MemberVO {

	private String id;
	private String pw;
	private boolean able;
	private String imgname;
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}
	public boolean isAble() {
		return able;
	}
	public void setAble(boolean able) {
		this.able = able;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	private String nick;
	private int no;

	public int    communo; 		//일련번호
	public String communame; 	//커뮤니티 이름

	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getCommuno() {
		return communo;
	}
	public void setCommuno(int communo) {
		this.communo = communo;
	}
	public String getCommuname() {
		return communame;
	}
	public void setCommuname(String communame) {
		this.communame = communame;
	}


}
