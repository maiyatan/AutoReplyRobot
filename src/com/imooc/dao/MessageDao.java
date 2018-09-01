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
	 * 获取message表的全部数据
	 */
	public List<Message> queryMessageList() {
		SqlSession session = null;
		ConnDb connDb = new ConnDb();
		List<Message> messageList = new ArrayList<Message>();
		try {
			session = connDb.getSqlSession();
			// 映射sql的标识字符串
			String statement = "com.imooc.sql.Message.queryMessageList";
			// 执行查询返回一个唯一user对象的sql
			messageList = session.selectList(statement);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return messageList;
	}
	
	public static void main(String[] args) {
		MessageDao messageDao=new MessageDao();
		List<Message> messageList = messageDao.queryMessageList();
		for (Message message : messageList) {
			System.out.println("getContent: "+message.getContent());
		}
	}
}
