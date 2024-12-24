<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home|GameBox</title>
</head>
<body>
 <header>
        <h1>Welcome to GameBox</h1>
        <nav>
            <a href="games.do">Games</a>
            <a href="community.do">Community</a>
            <c:choose>
                <c:when test="${not empty sessionScope.user}">
                    <span>Welcome, ${sessionScope.user}</span>
                    <a href="logout.do">Logout</a>
                </c:when>
                <c:otherwise>
                    <a href="login.do">Login</a>
                </c:otherwise>
            </c:choose>
        </nav>
    </header>

</body>
</html>