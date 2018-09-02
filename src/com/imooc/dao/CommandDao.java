package com.imooc.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Command;
import com.imooc.db.ConnDb;

/**
 * Message表的数据库处理
 * 
 * @author youtan
 *
 */
public class CommandDao {
	/**
	 * 单条删除
	 * 
	 * @param id
	 */
	public void deleteOne(int id) {
		SqlSession session = null;
		ConnDb connDb = new ConnDb();
		try {
			session = connDb.getSqlSession();
			// 映射sql的标识字符串
			String statement = "com.imooc.sql.Command.deleteOne";
			// 执行查询返回一个唯一user对象的sql
			session.delete(statement, id);
			// 提交删除
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 批量删除
	 * 
	 * @param ids
	 */
	public void deleteBatch(String[] ids) {
		SqlSession session = null;
		ConnDb connDb = new ConnDb();
		try {
			session = connDb.getSqlSession();
			// 映射sql的标识字符串
			String statement = "com.imooc.sql.Command.deleteBatch";
			// 执行查询返回一个唯一user对象的sql
			session.delete(statement, ids);
			// 提交删除
			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	/**
	 * 根据查询条件查询消息列表
	 */
	public List<Command> queryMessageList(String name, String description) {
		SqlSession session = null;
		ConnDb connDb = new ConnDb();
		List<Command> commandList = new ArrayList<Command>();
		try {
			// 将command和description放入message，作为参数传递给sql去处理
			Command command = new Command();
			command.setName(name);
			command.setDescription(description);

			session = connDb.getSqlSession();
			// 映射sql的标识字符串
			String statement = "com.imooc.sql.Command.queryMessageList";
			// 执行查询返回一个唯一user对象的sql
			commandList = session.selectList(statement, command);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return commandList;
	}
}
