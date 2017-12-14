package STUtil;
public class STPageUtil {
	public 		int		nowPage;
	public		int		totalCount;
	
	public		int		listCount;
	public		int		pageGroup;
	
	public		int		totalPage;
	public		int		startPage;
	public		int		endPage;
	
	public STPageUtil(int nowPage, int totalCount) {
		this.nowPage = nowPage;
		this.totalCount = totalCount;
		listCount = 6;
		pageGroup = 6;
		calcTotalPage();
		calcStartPage();
		calcEndPage();
	}
	private void calcTotalPage() {
		totalPage = (totalCount % listCount) == 0 ? (totalCount / listCount) : (totalCount / listCount) + 1;
	}
	private void calcStartPage() {
		int	tempGroup = (nowPage - 1) / pageGroup + 1;
		startPage = (tempGroup - 1) * pageGroup + 1;
	}
	private void calcEndPage() {
		endPage = startPage + pageGroup - 1;
		if(endPage > totalPage) {
			endPage = totalPage;
		}
	}
	public int getNowPage() {
		return nowPage;
	}
	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getListCount() {
		return listCount;
	}
	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
	public int getPageGroup() {
		return pageGroup;
	}
	public void setPageGroup(int pageGroup) {
		this.pageGroup = pageGroup;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
}
