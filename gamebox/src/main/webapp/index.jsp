<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<html>
<head>
    <title>Home|GameBox</title>
    <link rel="stylesheet" href="./resources/css/style.css">
    
</head>
<body>
<div class="main-banner">
    <img src="./resources/image/banner.jpg" alt="Main Banner">
    <div class="banner-text">
        <h1>겨울 세일!</h1>
        <p>지금 바로 할인된 게임을 만나보세요!</p>
    </div>
</div>

<div class="game-list">
    <form method="get" action="games.jsp">
        <input type="text" name="search" placeholder="게임 검색">
        <button type="submit">검색</button>
    </form>
    <div class="games" align="center">
        <img src="./resources/image/game1.jpg" alt="Game 1: God of War">
        <img src="./resources/image/game2.jpg" alt="Game 2: Metaphor">
        <img src="./resources/image/game3.jpg" alt="Game 3: Satisfactory">
        <img src="./resources/image/game4.jpg" alt="Game 4: Forza Horizon 5">
        <img src="./resources/image/game5.jpg" alt="Game 5: Ghost of Tsushima">
        <img src="./resources/image/game6.jpg" alt="Game 6: Stardew Valley">
    </div>
</div>
</body>
<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</html>