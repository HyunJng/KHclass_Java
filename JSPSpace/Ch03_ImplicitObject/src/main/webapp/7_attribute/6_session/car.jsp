<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	session.setAttribute("car", "자동차");	
	%>
	
	<h3>자동차를 장바구니에 담았습니다.</h3>
	<a href="showCart.jsp">장바구니 내용 보기</a>
</body>
</html>