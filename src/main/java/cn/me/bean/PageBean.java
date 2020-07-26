/**
 * 
 */
package cn.me.bean;

import java.util.List;

/**
 * @author WS
 *
 */
public class PageBean<T> {
	private int curPage;    //当前的页码
	private int totalRecord;	//总记录数
	private int pageSize;	//每页显示的数据量
	private List<T> beanList;		//当前页的所有记录
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotalRecord() {
		return totalRecord;
	}
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	
	//返回总页数
	public int getTotalPage() {
		int totalPage = totalRecord/pageSize;
		return totalRecord%pageSize == 0?totalPage:totalPage+1;
	}
	
}
