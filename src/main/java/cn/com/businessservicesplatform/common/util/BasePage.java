package cn.com.businessservicesplatform.common.util;


public class BasePage {
	
	/** 当前页 */
	private Integer page = 1;
	/** 当前页显示记录条数 */
	private Integer pageSize = 20;
	/** 取得查询总记录数 */
	private Integer count;
	
	public BasePage(){};
	
	public BasePage(Integer page){
		this.page = page==null?1:page;
	}
	public BasePage(Integer page,Integer pageSize){
		this.page = page==null?1:page;
		this.pageSize = pageSize==null?20:pageSize;
	}
	
	
	/**
	 * 取得当前查询总页数
	 * @return 当前查询总页数
	 */
	public Integer getPages() {
		return (count + getPageSize() - 1) / getPageSize();
	}
	/**
	 * 取得起始显示记录号
	 * @return 起始显示记录号
	 */
	public Integer getStartNo() {
		return ((getPage() - 1) * getPageSize());
	}
	/**
	 * 取得结束显示记录号
	 * @return 结束显示记录号
	 */
	public Integer getEndNo() {
		return Math.min(getPage() * getPageSize(), count);
	}
	
	/**
	 * 取得前一显示页码
	 * @return 前一显示页码
	 */
	public Integer getPrePageNo() {
		return Math.max(getPage() - 1, 1);
	}
	
	/**
	 * 取得后一显示页码
	 * @return 后一显示页码
	 */
	public Integer getNextPageNo() {
		return Math.min(getPage() + 1, getPages());
	}
	
	public Integer getPage() {
		return (page <= 0) ? 1 : page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = (count < 0) ? 0 : count;
		if (this.count == 0) {
			this.page = 0;
			return;
		}
	}
	
}
