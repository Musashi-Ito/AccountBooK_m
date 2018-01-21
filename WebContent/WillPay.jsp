<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.sql.*" import="model.User"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="css/standard_setting.css">
</head>
<body>
<%User c = (User)request.getAttribute("User"); %>
<div class="parent">
	<form method="post" action="/Accountbook">
		<h2 class="title">ほしいものリスト追加</h2>
			<p>商品名&emsp;<input type="text" name="TradeName"/></p>
			<p>金     額&emsp;<input type="text" name="Amount"/></p>
			<p>優先度
			<select name="Priority">
				<option selected disabled>最高を5とした時の優先順位</option>
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select></p>
		<button type='submit' name='btn' value='追加' class = "button" >追加</button>
	</form>

	<form method="post" action="/Accountbook">
		<h2 class="title">ほしいものリスト一覧(編集)</h2>
		<table border>
			<tr>
				<td align="center">商品名</td>
				<td>金額</td>
				<td>優先度</td>
				<td>削除</td>
			</tr>
			<%

			%>
		</table>
	</form>
</div>
<footer class="title">2017 © AccountBook</footer>
</body>
</html>