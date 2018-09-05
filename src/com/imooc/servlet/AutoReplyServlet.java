package com.imooc.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Command;
import com.imooc.bean.CommandContent;
import com.imooc.service.CommandService;

/**
 * 自动回复控制层
 * 
 * @author youtan
 *
 */
@SuppressWarnings("serial")
public class AutoReplyServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		// 接收页面传过来的参数
		String name = req.getParameter("content");

		CommandService commandService = new CommandService();
		// 根据name查询content列表 需要改
		List<CommandContent> ContentList = commandService.queryContentListByName(name);
		PrintWriter out = resp.getWriter();
		// 产生一个随机数
		int nextInt = new Random().nextInt(ContentList.size());
		CommandContent commandContent = ContentList.get(nextInt);
		// 将content输出
		out.write(commandContent.getContent());
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
