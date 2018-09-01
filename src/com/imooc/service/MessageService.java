package com.imooc.service;

import java.util.List;

import com.imooc.bean.Message;
import com.imooc.dao.MessageDao;

/**
 * Message相关的业务操作
 */
public class MessageService {
	/**
	 * 查询message全部数据
	 * 
	 * @return messageList
	 */
	public List<Message> queryMessageList(String command, String description) {
		MessageDao messageDao = new MessageDao();

		List<Message> messageList = messageDao.queryMessageList(command, description);
		return messageList;
	}
}
