<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel ="stylesheet" href="css/centering.css">
<%-- <link rel ="stylesheet" href="css/standard_setting.css">  --%>
</head>
<body>
<%-- <div class="overley"> --%>
<%-- <video src="city.mp4" autoplay loop></video> --%>
<%-- <header class="title">Welcome</header> --%>
<main>
	<%-- <div class = "parent"> --%>
	<div class = "box11">
		<h2>Welcome</h2>

		<div>
			<form action="/AccountBook1/src/Register" method="post" >
				<p>メールアドレス:<input type="text" name="address" value="jack@gmail.com"/></p>
				<p>パスワード:<input type="password" name="pwd" value="0000"/></p>
				<%-- <input type="submit" name="btn" value="新規登録"/> --%>
				<%-- <input type="submit" name="btn" value="ログイン"/> --%>
				<button type='submit' name='btn' value='新規登録' class = "button" >新規登録</button>
				<button type='submit' name='btn' value='ログイン' class = "button" >ログイン</button>
			</form>
		</div>
	</div>
</main>
<footer class="title">2017 © AccountBook</footer>
</body>
</html>