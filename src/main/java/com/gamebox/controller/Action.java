package com.gamebox.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {

	/**
	 * 요청 처리 및 결과 반환
	 * 
	 * @param request HttpServletRequest
	 * @param respone HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */
	
	ActionForward execute(HttpServletRequest request, HttpServletResponse response);
	
}
