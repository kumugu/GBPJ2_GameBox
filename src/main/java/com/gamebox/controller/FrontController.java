package com.gamebox.controller;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")	// ".do"로 끝나는 요청 처리
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String command = request.getRequestURI().substring(request.getContextPath().length() + 1);
		
		Action action = null;
		ActionForward forward = null;
		
		Properties prop = new Properties();
		prop.load(getServletContext().getResourceAsStream("/WEB-INF/mapping.properties"));
		
		String value = prop.getProperty(command);
		if (value == null) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}
		
		if (value.startsWith("execute|")) {
			try {
				String ClassName = value.split("\\|")[1];
				Class<?> clazz = Class.forName(ClassName);
				action = (Action) clazz.getDeclaredConstructor().newInstance(null);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		} else {
			forward = new ActionForward(value, false);
		}
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}
	}
}























