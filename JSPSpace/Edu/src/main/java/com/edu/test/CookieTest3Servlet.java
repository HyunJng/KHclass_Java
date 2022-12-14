package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieTest3Servlet")
public class CookieTest3Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cnt = 0;
		Cookie[] list = req.getCookies();
		for(int i = 0; list != null && i < list.length; i++) {
			if(list[i].getName().equals("count")) {
				cnt = Integer.parseInt(list[i].getValue());
			}
		}
		
		cnt++;
		Cookie c = new Cookie("count", cnt+"");
		c.setMaxAge(60*60*24*1);
		resp.addCookie(c);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h1>방문 횟수 :" + cnt);
		out.close();
	}
}
