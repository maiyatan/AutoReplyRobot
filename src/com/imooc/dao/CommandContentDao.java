package com.imooc.dao;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import com.imooc.bean.CommandContent;
import com.imooc.db.ConnDb;

/**
 * CommandContent表的数据库处理
 * 
 * @author youtan
 *
 */
public class CommandContentDao {
	/**
	 * 单条删除
	 * 
	 * @param id
	 */
//	public void deleteOne(int id) {
//		SqlSession session = null;
//		ConnDb connDb = new ConnDb();
//		try {
//			session = connDb.getSqlSession();
//			// 映射sql的标识字符串
//			String statement = "com.imooc.sql.Command.deleteOne";
//			// 执行查询返回一个唯一user对象的sql
//			session.delete(statement, id);
//			// 提交删除
//			session.commit();
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}

	/**
	 * 根据id查询content列表
	 */
	public List<CommandContent> queryCommandContentList(int id) {
		SqlSession session = null;
		ConnDb connDb = new ConnDb();
		List<CommandContent> CommandContentList = new ArrayList<CommandContent>();
		try {
			session = connDb.getSqlSession();
			// 映射sql的标识字符串
			String statement = "com.imooc.sql.CommandContent.queryCommandContentList";
			// 执行查询返回一个唯一user对象的sql
			CommandContentList = session.selectList(statement, id);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return CommandContentList;
	}
}
