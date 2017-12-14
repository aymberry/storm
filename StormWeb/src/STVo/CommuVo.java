package STVo;

public class CommuVo {
	public int commuNo; 		//일련번호
	public String commuName; 	//커뮤니티 이름
	public String commuText; 	//커뮤니티 소개
	public String commuImgName;	//이미지 파일이름
	public int commuUsrNo; 	//커뮤니티 주인
	public String usrimgname;
	
	public String getUsrimgname() {
		return usrimgname;
	}
	public void setUsrimgname(String usrimgname) {
		this.usrimgname = usrimgname;
	}
	public int usrNo; //유저번호
	public int gNo; // 상품일련번호
	
	public int score; 	//리뷰점수
	public String content;	//리뷰내용
	public String nickname;	//유저닉네임
	public String gname; 	//상품이름 
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public int getCommuNo() {
		return commuNo;
	}
	public void setCommuNo(int commuNo) {
		this.commuNo = commuNo;
	}
	public String getCommuName() {
		return commuName;
	}
	public void setCommuName(String commuName) {
		this.commuName = commuName;
	}
	public String getCommuText() {
		return commuText;
	}
	public void setCommuText(String commuText) {
		this.commuText = commuText;
	}
	public String getCommuImgName() {
		return commuImgName;
	}
	public void setCommuImgName(String commuImgName) {
		this.commuImgName = commuImgName;
	}
	public int getCommuUsrNo() {
		return commuUsrNo;
	}
	public void setCommuUsrNo(int commuUsrNo) {
		this.commuUsrNo = commuUsrNo;
	}
	public int getUsrNo() {
		return usrNo;
	}
	public void setUsrNo(int usrNo) {
		this.usrNo = usrNo;
	}
	public int getgNo() {
		return gNo;
	}
	public void setgNo(int gNo) {
		this.gNo = gNo;
	}

}
