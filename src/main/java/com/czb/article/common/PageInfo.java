package com.czb.article.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.github.pagehelper.Page;

/**
 * <p>Title: PageInfo.java</p>
 * <p>Description: 分页封装</p>
 * @author zhxun
 * @date 2018年6月22日上午9:44:27
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class PageInfo<T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// 当前页
	private int pageNum;
	// 每页的数量
	private int pageSize;
	// 总记录数
	private long total;
	// 总页数
	private int pages;
	// 结果集
	private List<T> list;

	public PageInfo() {
	}

	/**
	 * 包装Page对象
	 *
	 * @param list
	 */
	public PageInfo(List<T> list) {
		if (list instanceof Page) {
			Page page = (Page) list;
			this.pageNum = page.getPageNum();
			this.pageSize = page.getPageSize();
			this.pages = page.getPages();
			this.list = page;
			this.total = page.getTotal();
		} else if (list instanceof Collection) {
			this.pageNum = 1;
			this.pageSize = list.size();
			this.pages = 1;
			this.list = list;
			this.total = list.size();
		}
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public List<T> getList() {
		return list;
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("PageInfo{");
		sb.append("pageNum=").append(pageNum);
		sb.append(", pageSize=").append(pageSize);
		sb.append(", total=").append(total);
		sb.append(", pages=").append(pages);
		sb.append(", list=").append(list);
		sb.append(", navigatepageNums=");
		sb.append('}');
		return sb.toString();
	}
}