package com.ithc.util;

import java.util.List;

import com.ithc.bean.Table;

/**
 * 分页工具类
 * 
 * @author 李某人 motto 学习就像和尚诵经 cell-phone number 13437278267
 */
public class PageBean {
	// 当前页
	private int pagePresent = 1;
	// 总页数
	private int pageTotal;
	// 总记录数
	private int pageCount;
	// 每页显示的数量
	public static final int PAGE_SIZE = 4;

	public int getPagePresent() {
		return pagePresent;
	}

	public void setPagePresent(int pagePresent) {
		// 当前页不小于1
		if (pagePresent < 1) {
			this.pagePresent = 1;
		}
		// 限制当前页不大于总页面数
		if (pagePresent > pageTotal) {
			pagePresent = pageTotal;
		}
		this.pagePresent = pagePresent;
	}

	public int getPageTotal() {
		return pageTotal;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		// 计算总页数
		pageTotal = pageCount / 4;
		if (pageCount % 4 != 0) {
			pageTotal = pageTotal + 1;
		}

		this.pageCount = pageCount;
	}

}
