<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
		<li>application :${applicationScope.sum} </li>
		<li>session : ${sessionScope.sum} </li>
		<li>cookie : ${cookieScope.sum}</li>
	</ul>


	<div>
		<a href="add2.jsp">덧셈하기</a>
	
	</div>
</body>
</html>