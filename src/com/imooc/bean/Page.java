package com.imooc.bean;

public class Page {
	/** 总条数 */
	private int totalNumber;
	/** 当前页 */
	private int currentPage;
	/** 总页数 */
	private int totalPage;
	/** 每页显示条数 */
	private int pageNumber = 5;
	/** 数据库中limit参数，从第几条开始取 */
	private int dbIndex;
	/** 数据库中limit参数，一共取几条 */
	private int dbNumber;

	// --------------------根据上记属性值计算相关属性------------------------------//

	/**
	 * 根据上记属性值计算相关属性
	 */
	public void count() {
		// 计算总页数
		int totalPageTemp = this.totalNumber / this.pageNumber;
		int plus = (this.totalNumber % this.pageNumber) == 0 ? 0 : 1;
		totalPageTemp = totalPageTemp + plus;// 如果不能被整除的话，就多加一页
		if (totalPageTemp <= 0) {
			totalPageTemp = 1;
		}
		this.totalPage = totalPageTemp;

		// 设置当前页数
		if (this.totalPage < this.currentPage) {
			this.currentPage = this.totalPage;// 如果总页数小于当前页，将当前页设为总页数
		}
		if (this.currentPage < 1) {
			this.currentPage = 1;// 如果当前页小于1，设为1
		}

		// 设置limit参数
		/**
		 * select * from cammand limit dbIndex,dbNumber; 
		 * select * from cammand limit0,5; 
		 * select * from cammand limit 5,5; 
		 * select * from cammand limit 10,5;
		 */
		this.dbIndex = (this.currentPage - 1) * this.pageNumber;
		this.dbNumber = this.pageNumber;
	}

	// --------------------set，get方法------------------------------//

	public int getTotalNumber() {
		return totalNumber;
	}

	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
		this.count();// 调用count（）方法
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getDbIndex() {
		return dbIndex;
	}

	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}

	public int getDbNumber() {
		return dbNumber;
	}

	public void setDbNumber(int dbNumber) {
		this.dbNumber = dbNumber;
	}
}
