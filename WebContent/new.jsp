<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="model.User, model.LoginLogic, model.RegisterLogic"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="css/standard_setting.css">
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String address = request.getParameter("address");
	String pwd = request.getParameter("pwd");
	String btn = request.getParameter("btn");

	if("送信".equals(btn)){
		out.print(name);
		out.print(address);
		out.print(pwd);

		User u = new User(name,address, pwd);
		RegisterLogic rl = new RegisterLogic();
		rl.execute(u);
		request.setAttribute("User",u);

		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/registerResult.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
		dispatcher.forward(request, response);
	}
%>
<div class="parent">
	<form action="new.jsp" method="post">
		ユーザー名:<input type="text" name="name" value="user"/><br>
		メールアドレス:<input type="text" name="address" value="jack@gmail.com"/><br>
		パスワード:<input type="password" name="pwd" value="0000"/><br>
		<%-- <input type="submit" name="btn" value="送信"/> --%>
		<button type='submit' name='btn' value='送信' class = "button" >送信</button>
	</form>
</div>
</body>
</html>