package com.imooc.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.imooc.service.TalkService;

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
		TalkService talkService = new TalkService();
		PrintWriter out = resp.getWriter();
		
		// 根据name查询content列表
		String content = talkService.queryContentByName(name);
		// 将content输出
		out.write(content);
		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}
}
