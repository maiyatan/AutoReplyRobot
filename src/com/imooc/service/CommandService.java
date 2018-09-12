package com.imooc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.imooc.bean.Command;
import com.imooc.bean.Page;
import com.imooc.dao.CommandDao;

/**
 * Command相关的业务操作
 */
public class CommandService {

	/**
	 * 通过name、description查询message全部数据
	 * 
	 * @return messageList
	 */
	public List<Command> queryMessageList(String name, String description,Page page) {
		Command command =new Command();
		command.setName(name);
		command.setDescription(description);
		
		CommandDao commandDao = new CommandDao();
		// 查询总条数
		int totalNumber = commandDao.count(command);
		// 组织分页查询参数
		page.setTotalNumber(totalNumber);
		Map<String,Object> paramter = new HashMap<String,Object>();
		paramter.put("command", command);
		paramter.put("page", page);
		List<Command> commandList = commandDao.queryMessageList(paramter);
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
	 * 
	 * @param ids
	 */
	public void deleteBatch(String[] ids) {
		CommandDao commandDao = new CommandDao();
		commandDao.deleteBatch(ids);
	}
}
