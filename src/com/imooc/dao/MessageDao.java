package com.imooc.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.imooc.bean.Message;
import com.imooc.db.ConnDb;

/**
 * Message表的数据库处理
 * 
 * @author youtan
 *
 */
public class MessageDao {
	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Message> queryMessageList(String command, String description) {
		SqlSession session = null;
		ConnDb connDb = new ConnDb();
		List<Message> messageList = new ArrayList<Message>();
		try {
			// 将command和description放入message，作为参数传递给sql去处理
			Message message = new Message();
			message.setCommand(command);
			message.setDescription(description);

			session = connDb.getSqlSession();
			// 映射sql的标识字符串
			String statement = "com.imooc.sql.Message.queryMessageList";
			// 执行查询返回一个唯一user对象的sql
			messageList = session.selectList(statement, message);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return messageList;
	}
}
