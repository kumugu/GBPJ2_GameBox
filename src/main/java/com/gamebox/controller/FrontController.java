package com.gamebox.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FrontController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 한글 깨짐 방지
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        // URI와 Context Path 추출
        String uri = request.getRequestURI();
        String contextPath = request.getContextPath();
        String command = uri.substring(contextPath.length() + 1);

        // 요청에 매핑된 경로 찾기
        Properties prop = new Properties();
        prop.load(getServletContext().getResourceAsStream("/WEB-INF/mapping.properties"));
        String viewPath = prop.getProperty(command);

        // View로 Forward
        if (viewPath != null) {
            request.getRequestDispatcher(viewPath).forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Invalid request: " + command);
        }
    }
}
