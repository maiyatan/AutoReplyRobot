package com.imooc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.bean.CommandContent;
import com.imooc.service.CommandContentService;
/**
 * 修改页操作
 * @author youtan
 *
 */
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 接收页面传过来的参数
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String description = req.getParameter("description");
		// 向页面传值。目的是：搜索栏保存查询条件
		req.setAttribute("name", name);
		req.setAttribute("description", description);
		// 数据库操作
		CommandContentService commandContentService =new CommandContentService();
		List<CommandContent> CommandContentList = commandContentService.queryCommandContentList(id);
		// 将CommandContentList放到JavaBean中，给jsp用
		req.setAttribute("CommandContentList", CommandContentList);
		// 页面跳转
		req.getRequestDispatcher("/WEB-INF/jsp/back/update.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
