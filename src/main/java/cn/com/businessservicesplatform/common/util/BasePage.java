package cn.com.businessservicesplatform.common.util;


public class BasePage {
	
	/** 当前页 */
	private int page = 1;
	/** 当前页显示记录条数 */
	private int pageSize = 20;
	/** 取得查询总记录数 */
	private int count;
	
	public BasePage(){};
	
	public BasePage(int page){
		this.page = page;
	}
	public BasePage(int page,int pageSize){
		this.page = page;
		this.pageSize = pageSize;
	}
	
	
	/**
	 * 取得当前查询总页数
	 * @return 当前查询总页数
	 */
	public int getPages() {
		return (count + getPageSize() - 1) / getPageSize();
	}
	/**
	 * 取得起始显示记录号
	 * @return 起始显示记录号
	 */
	public int getStartNo() {
		return ((getPage() - 1) * getPageSize());
	}
	/**
	 * 取得结束显示记录号
	 * @return 结束显示记录号
	 */
	public int getEndNo() {
		return Math.min(getPage() * getPageSize(), count);
	}
	
	/**
	 * 取得前一显示页码
	 * @return 前一显示页码
	 */
	public int getPrePageNo() {
		return Math.max(getPage() - 1, 1);
	}
	
	/**
	 * 取得后一显示页码
	 * @return 后一显示页码
	 */
	public int getNextPageNo() {
		return Math.min(getPage() + 1, getPages());
	}
	
	public int getPage() {
		return (page <= 0) ? 1 : page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = (count < 0) ? 0 : count;
		if (this.count == 0) {
			this.page = 0;
			return;
		}
	}
	
}
