package com.imooc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.Command;
import com.imooc.bean.Page;
import com.imooc.service.CommandService;

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
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		String currentPage = req.getParameter("currentPage");// 接收当前页（分页功能）
		// 向页面传值。目的是：搜索栏保存查询条件
		req.setAttribute("name", name);
		req.setAttribute("description", description);
		// 创建分页对象
		Page page = new Page();
		if (currentPage == null) {
			page.setCurrentPage(1);
		} else {
			page.setCurrentPage(Integer.valueOf(currentPage));
		}
		CommandService commandService = new CommandService();
		List<Command> commandList = commandService.queryMessageList(name, description, page);
		
		req.setAttribute("commandList", commandList);
		req.setAttribute("page", page);
		// 页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
