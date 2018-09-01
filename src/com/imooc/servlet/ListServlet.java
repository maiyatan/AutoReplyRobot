package com.imooc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Message;
import com.imooc.service.MessageService;

/**
 * 页面初始化处理
 * 
 * @author youtan
 *
 */
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收页面传过来的参数
		String command = req.getParameter("command");
		String description = req.getParameter("description");
		// 向页面传值。目的是：搜索栏保存查询条件
		req.setAttribute("command", command);
		req.setAttribute("description", description);

		MessageService messageService = new MessageService();
		List<Message> messageList = messageService.queryMessageList(command, description);
		req.setAttribute("messageList", messageList);
		// 页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
