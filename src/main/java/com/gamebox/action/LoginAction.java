package com.gamebox.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamebox.controller.Action;
import com.gamebox.controller.ActionForward;
import com.gamebox.service.UserService;

public class LoginAction implements Action {

    @Override
    public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
        // 입력값 받기
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 입력값 유효성 검사
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            request.setAttribute("error", "Username and password are required.");
            return new ActionForward("/WEB-INF/views/login.jsp", false);
        }

        // 사용자 인증 처리
        UserService userService = new UserService();
        boolean isValid = userService.validateUser(username, password);

        if (isValid) {
            // 로그인 성공: 세션에 사용자 정보 저장
            request.getSession().setAttribute("user", username);
            return new ActionForward("home.do", true); // Redirect to home.do
        } else {
            // 로그인 실패: 에러 메시지와 함께 로그인 페이지로 이동
            request.setAttribute("error", "Invalid username or password.");
            return new ActionForward("/WEB-INF/views/user/login.jsp", false);
        }
    }
}
