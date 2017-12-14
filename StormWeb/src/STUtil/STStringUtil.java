package STUtil;
//		자주 사용하는 기능은 한세트 만들어 놓으면 편하게 이용할 것이다.
public class STStringUtil {
	//	1.	String에 데이터가 있는지 확인해주는 함수
	public static boolean isNull(String data) {
		if(data == null || data.length() == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	//	작업하다가 많이 사용하는 기능이 있으면 붙이면 된다.
}
