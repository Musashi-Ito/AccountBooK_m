<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String user = request.getParameter("user");
	String pwd = request.getParameter("pwd");

	out.print(user +"さんのユーザーページ<br>");
	out.print("残高：33000<br>");
	out.print("優先順序の高い順<br>");
%>
<input type="checkbox" name="c1" checked="checked">
<img src="1.jpg" width="25%" height="25%">購入した場合、残高：28000<br>
<input type="checkbox" name="c1" checked="checked">
<img src="2.jpg" width="25%" height="25%">購入した場合、残高：28000<br>
</body>
</html>