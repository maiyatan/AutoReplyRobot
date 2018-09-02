package com.imooc.service;

import java.util.List;

import com.imooc.bean.CommandContent;
import com.imooc.dao.CommandContentDao;

/**
 * CommandContent相关的业务操作
 */
public class CommandContentService {
	/**
	 * 查询CommandContent全部数据
	 * 
	 * @return CommandContentList
	 */
	public List<CommandContent> queryCommandContentList(String id) {
		CommandContentDao commandContentDao = new CommandContentDao();
		List<CommandContent> CommandContentList = commandContentDao.queryCommandContentList(Integer.parseInt(id));
		return CommandContentList;
	}

	/**
	 * 根据id做单条删除处理
	 * 
	 * @param id id
	 */
//	public void deleteOne(String id) {
//		if (id != null && !"".equals(id.trim())) {
//			MessageDao messageDao = new MessageDao();
//			messageDao.deleteOne(Integer.parseInt(id));
//		}
//	}
}
