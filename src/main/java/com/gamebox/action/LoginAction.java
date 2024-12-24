package com.gamebox.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamebox.controller.Action;
import com.gamebox.controller.ActionForward;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if ("admin".equals(username) && "admin123".equals(password)) {
			request.getSession().setAttribute("user", username);
			return new ActionForward("index.jsp", true);	// 로그인 성공 시 Redirect
		} else {
			request.setAttribute("error", "Invalid username or password");
			return new ActionForward("/WEB-INF/views/user/login.jsp", false);	//  실패 시 forward 
		}
	}
}
