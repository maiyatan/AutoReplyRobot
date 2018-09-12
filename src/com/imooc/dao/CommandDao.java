package com.imooc.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Command;
import com.imooc.db.ConnDb;

/**
 * Command表的数据库处理
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
	 * 
	 * @param name        指令名称
	 * @param description 描述
	 * @return
	 * 
	 */
	public List<Command> queryMessageList(Map<String,Object> paramter)  {
		SqlSession session = null;
		ConnDb connDb = new ConnDb();
		List<Command> commandList = new ArrayList<Command>();
		try {

			session = connDb.getSqlSession();
			// 使用接口式编程
			ICommand icommand = session.getMapper(ICommand.class);
			commandList = icommand.queryMessageList(paramter);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return commandList;
	}

	/**
	 * 查询总条数
	 * 
	 * @param command 指令名称
	 * @return 总条数
	 */
	public int count(Command command) {
		SqlSession session = null;
		ConnDb connDb = new ConnDb();
		int count = 0;
		try {
			session = connDb.getSqlSession();
			// 使用接口式编程
			ICommand icommand = session.getMapper(ICommand.class);
			count = icommand.count(command);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return count;
	}
}
