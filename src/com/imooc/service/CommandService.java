package com.imooc.service;

import java.util.List;

import com.imooc.bean.Command;
import com.imooc.bean.CommandContent;
import com.imooc.dao.CommandDao;

/**
 * Command相关的业务操作
 */
public class CommandService {
	
	/**
	 * 通过name查询content列表
	 * @param name 指令名称
	 * @return contentList
	 */
	public List<CommandContent> queryContentListByName(String name) {
		CommandDao commandDao = new CommandDao();
		List<CommandContent> contentList=null;
		List<Command> commandList = commandDao.queryMessageList(name, null);
		for (Command command : commandList) {
			contentList = command.getContentList();
		}
		return contentList;
	}
	/**
	 * 通过name、description查询message全部数据
	 * 
	 * @return messageList
	 */
	public List<Command> queryMessageList(String name, String description) {
		CommandDao commandDao = new CommandDao();

		List<Command> commandList = commandDao.queryMessageList(name, description);
		return commandList;
	}

	/**
	 * 根据id做单条删除处理
	 * 
	 * @param id id
	 */
	public void deleteOne(String id) {
		if (id != null && !"".equals(id.trim())) {
			CommandDao commandDao = new CommandDao();
			commandDao.deleteOne(Integer.parseInt(id));
		}
	}
	/**
	 * 根据ids数组做批量删除处理
	 * @param ids
	 */
	public void deleteBatch(String[] ids) {
		CommandDao commandDao = new CommandDao();
		commandDao.deleteBatch(ids);
	}
}
