<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.User,model_fix.Fixity,model.UserMoney"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="css/standard_setting.css">
</head>
<body>
<%
	boolean known_user = false;
	//User u = (User)request.getAttribute("User");
	User u = (User)session.getAttribute("User");
	System.out.println(u.getId());
	System.out.println(u.getAddress());
	System.out.println(u.getPwd());
	System.out.println(u.getName());

	/*
	Fixity fix = (Fixity)session.getAttribute("Fixity");
	if(fix.getId() != -1) known_user = true;
	*/

	UserMoney um = (UserMoney)session.getAttribute("UserMoney");
	if(um.getId() != -1) known_user = true;

	//System.out.println();
	//request.setAttribute("User", u);
	session.setAttribute("User", u);
%>
<div class="parent">
	<form method="post" action="/AccountBook1/Fixity_pro">
		<h2 class="title">初期設定</h2>
			<p>現在の残高&emsp;<input type="text" name="Balance"/></p>
			<p>目標金額    &emsp;<input type="text" name="Goal"/></p>

<%
			if(known_user){
%>
					<button type='submit' name='btn' value='設定更新' class = "button" >設定更新</button>
<%
			}else {
%>
					<button type='submit' name='btn' value='設定登録' class = "button" >設定登録</button>
<%
			}
%>
			<%--
				<input type="submit" value="設定登録" name="btn">
			--%>

		<h2 class="title">固定収支</h2>
			<p>収支種類&emsp;<input type="text" name="Type" value="光熱費"/></p>
			<p>収支金額&emsp;<input type="text" name="Amount" value="6000"/></p>
			<p>収支日時&emsp;<input type="text" name="Day" value="0120"/></p>
			<%-- <input type="submit" value="収支登録" name="btn"> --%>
			<button type='submit' name='btn' value='収支登録' class = "button" >収支登録</button>
	</form>
</div>
<footer class="title">2017 © AccountBook</footer>
</body>
</html>