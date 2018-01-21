<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="model.User, java.sql.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%%>
<%
		out.print("ユーザーを追加しました。\n");
		User u = (User)request.getAttribute("User");
		if(u.getName() != null || u.getAddress() != null || u.getPwd() != null){
			out.print("ユーザー名:"+u.getName()+"\n");
			out.print("メールアドレス:"+u.getAddress()+"\n");
			out.print("パスワード:"+u.getPwd()+"\n");
		}
%>
<%%>
<%%>
</body>
</html>