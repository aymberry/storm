package com.storm.VO;

import java.sql.Date;

public class CommuVO {

	public int    communo; 		//�Ϸù�ȣ
	public String communame; 	//Ŀ�´�Ƽ �̸�
	public String commutext; 	//Ŀ�´�Ƽ �Ұ�
	public String commuimgName;	//�̹��� �����̸�
	public Date commudate;		//�����
	public int commuprice;		//����
	
	public int usrKey; //������ȣ
	public String usrId; //���� ���̵�
	
	public int boardno; //�Խñ� ��ȣ
	public String boardtext; //�Խñ۳���
	public String boardname; //�Խù�����
	public String bdate; // �Խñ۽ð�;
	
	public String getBdate() {
		return bdate;
	}
	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	public int oriNo; //���۳ѹ�
	public int nowPage;
	
	
	public String reply;	//��۳���
	public String nick;		//�����г���
	public String replyNo; 	//��ǰ�̸� 
	public Date rwdate;		//��۳�¥
	
	
	
	
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
	public String getCommutext() {
		return commutext;
	}
	public void setCommutext(String commutext) {
		this.commutext = commutext;
	}
	public String getCommuimgName() {
		return commuimgName;
	}
	public void setCommuimgName(String commuimgName) {
		this.commuimgName = commuimgName;
	}
	public Date getCommudate() {
		return commudate;
	}
	public void setCommudate(Date commudate) {
		this.commudate = commudate;
	}
	public int getCommuprice() {
		return commuprice;
	}
	public void setCommuprice(int commuprice) {
		this.commuprice = commuprice;
	}
	public int getUsrKey() {
		return usrKey;
	}
	public void setUsrKey(int usrKey) {
		this.usrKey = usrKey;
	}
	public int getOriNo() {
		return oriNo;
	}
	public void setOriNo(int oriNo) {
		this.oriNo = oriNo;
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}
	public Date getRwdate() {
		return rwdate;
	}
	public void setRwdate(Date rwdate) {
		this.rwdate = rwdate;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	public String getBoardtext() {
		return boardtext;
	}
	public void setBoardtext(String boardtext) {
		this.boardtext = boardtext;
	}
	public String getUsrId() {
		return usrId;
	}
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	public String getBoardname() {
		return boardname;
	}
	public void setBoardname(String boardname) {
		this.boardname = boardname;
	}
	
	
	
}
