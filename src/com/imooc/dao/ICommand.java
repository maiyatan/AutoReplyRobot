package com.imooc.dao;

import java.util.List;

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
	public List<Command> queryMessageList(Command command);
}
