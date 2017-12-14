package STVo;

import java.sql.Date;
import java.util.ArrayList;

public class GoodsVo 
{
	public 	int		no;
	public	String	name;
	public	int		type_no;
	public 	String	type;
	public	Date	registDate;
	public	Date	releaseDate;
	public	int		price;
	public	String	smallText;
	public	String	bigText;
	public	String	installFileName;
	public	String	os_name;
	public 	String 	img_name;
	
	public String getImg_name() {
		return img_name;
	}
	public void setImg_name(String img_name) {
		this.img_name = img_name;
	}
	public	int	reviewCnt;
	public	int	avgScore;
	public	ArrayList	tag_list;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getType_no() {
		return type_no;
	}
	public void setType_no(int type_no) {
		this.type_no = type_no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getRegistDate() {
		return registDate;
	}
	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSmallText() {
		return smallText;
	}
	public void setSmallText(String smallText) {
		this.smallText = smallText;
	}
	public String getBigText() {
		return bigText;
	}
	public void setBigText(String bigText) {
		this.bigText = bigText;
	}
	public String getInstallFileName() {
		return installFileName;
	}
	public void setInstallFileName(String installFileName) {
		this.installFileName = installFileName;
	}
	public String getOs_name() {
		return os_name;
	}
	public void setOs_name(String os_name) {
		this.os_name = os_name;
	}
	public int getReviewCnt() {
		return reviewCnt;
	}
	public void setReviewCnt(int reviewCnt) {
		this.reviewCnt = reviewCnt;
	}
	public int getAvgScore() {
		return avgScore;
	}
	public void setAvgScore(int avgScore) {
		this.avgScore = avgScore;
	}
	public ArrayList getTag_list() {
		return tag_list;
	}
	public void setTag_list(ArrayList tag_list) {
		this.tag_list = tag_list;
	}
	
}
