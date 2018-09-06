package com.imooc.service;

import java.util.List;
import java.util.Random;

import com.imooc.bean.Command;
import com.imooc.bean.CommandContent;
import com.imooc.dao.CommandDao;
import com.imooc.util.Iconst;

public class TalkService {
	/**
	 * 通过name随机返回一条content
	 * 
	 * @param name 指令名称
	 * @return content
	 */
	public String queryContentByName(String name) {
		CommandDao commandDao = new CommandDao();
		List<CommandContent> contentList = null;
		String content = null;
		// 用户输入【帮助】
		if ("帮助".equals(name)) {
			List<Command> hellpList = commandDao.queryMessageList(null, null);
			StringBuffer result = new StringBuffer();
			for (int i = 0; i < hellpList.size(); i++) {
				if (i != 0) {
					// 从第二行起，换行
					result.append("</br>");
				}
				result.append(
						"回复[" + hellpList.get(i).getName() + "],可以查看 [" + hellpList.get(i).getDescription() + "]");
			}
			return result.toString();
		}
		List<Command> commandList = commandDao.queryMessageList(name, null);
		if (commandList.size() > 0) {
			contentList = commandList.get(0).getContentList();
			// 产生一个随机数
			int nextInt = new Random().nextInt(contentList.size());
			CommandContent commandContent = contentList.get(nextInt);
			content = commandContent.getContent();
			return content;
		}
		return Iconst.NO_MATCHING_CONTENT;
	}

}
