<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
</head>
<body>
    <h1>Welcome, Admin</h1>
    <nav>
        <a href="userManagement.do">Manage Users</a>
        <a href="gameManagement.do">Manage Games</a>
        <a href="reviews.do">View Reviews</a>
        <a href="logout.do">Logout</a>
    </nav>
    <c:choose>
	    <c:when test="${not empty sessionScope.admin}">
	        <h1>Welcome, Admin (${sessionScope.admin})</h1>
	        <a href="logout.do">Logout</a>
	    </c:when>
	    <c:otherwise>
	        <h1>You are not authorized to access this page</h1>
	        <a href="login.do">Login</a>
	    </c:otherwise>
	</c:choose>
    
</body>
</html>
