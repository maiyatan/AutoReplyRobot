package com.imooc.test;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.imooc.bean.Command;
import com.imooc.db.ConnDb;

public class GetSqlSessionTest {
	public static void main(String[] args) {
		ConnDb connDb = new ConnDb();
		List<Command> commandList = new ArrayList<Command>();
		SqlSession session = connDb.getSqlSession();
		// 映射sql的标识字符串
		String statement = "com.imooc.sql.Command.queryCommandList";
		// 执行查询返回一个唯一user对象的sql
		commandList = session.selectList(statement);
		for (Command command : commandList) {
			System.out.println(command.getDescription());
			System.out.println(command.getId());
			System.out.println(command.getName());
			System.out.println(command.getContentList().toString());
		}
	}
}
