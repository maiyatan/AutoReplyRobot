package com.imooc.dao;

import java.util.List;
import java.util.Map;

import com.imooc.bean.Command;

/**
 * @author youtan 与Command文件相对于的接口
 */
public interface ICommand {
	/**
	 * 查询command+content全部数据的接口
	 * 
	 * @param command
	 * @return List<Command
	 */
	public List<Command> queryMessageList(Map<String,Object> paramter);

	/**
	 * 查询总条数
	 * 
	 * @param command
	 * @return 总条数
	 */
	public int count(Command command);
}
