package com.gamebox.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamebox.controller.Action;
import com.gamebox.controller.ActionForward;
import com.gamebox.service.UserService;

public class LoginAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserService userService = new UserService();
		boolean isAdmin = userService.isAdmin(username, password);
		boolean isValid = userService.validateUser(username, password);
		
		if (isAdmin) {
		}
		
		
	}
}
