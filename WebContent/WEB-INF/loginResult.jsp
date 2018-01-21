<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//String id = (String)session.getAttribute("id");
	User u = (User)request.getAttribute("User");
	String id = u.getId();

	System.out.println(u.getId());
	System.out.println(u.getAddress());
	System.out.println(u.getPwd());
	System.out.println(u.getName());

	if( id != null){%>
		ログイン成功しました。
<%
		//User u = (User)request.getAttribute("User");
		out.println(u.getName() + "さん、ようこそ。");

%>
	<%}else{ %>
		ログイン失敗しました。
	<%} %>
</body>
</html>