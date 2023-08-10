<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
header, .content, body {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

footer {
	box-sizing: border-box;
	/*중앙정렬*/
	width: 960px;
	margin: 20px auto;
	border: 1px solid black;
	justify-content: center;
	align-items: center;
	text-align: center;
	display: flex;
}

header {
	height: 200px;
	border: 0px;
}

.login-box {
	border: solid 1px black;
	width: 500px;
	height: 400px;
	text-align: center;
	justify-content: center;
	align-items: center;
}

.login-welcome {
	margin-top: 50px;
}
</style>
</head>

<body>
	<script>
		var msg = '${Msg}';
		if (msg) {
			alert(msg);
		}
	</script>
	<header> </header>
	<div class="login-box">
		<div class="login-welcome">
			<p>lOGIN</p>
			<p>KH 대학교 포탈시스템 방문을 환영합니다.</p>
		</div>

		<div>
			<form action="<%=request.getContextPath()%>/login.do" method="post">

				<input type="text" name="id" placeholder="아이디를 입력해주세요." required><br>
				<input type="text" name="pwd" placeholder="비밀번호를 입력해주세요." required>
		</div>
		<div class="who">
			<input type="radio" id="student" name="who" value="s" checked>
			<label for="student">학생</label><br> <input type="radio"
				id="professor" name="who" value="p"> <label for="professor">교직원</label>

		</div>
		<div>
			<input type="submit" value="로그인">
			</form>
		</div>
		<div>
			<p>아이디찾기</p>
			<p>비밀번호찾기</p>
		</div>
	</div>
	<footer>
		<p>서울특별시 강남구 테헤란로14길 6 [6층]</p>
		<p>Copyright © 1998-2023 KH Information Educational Institute All
			Right Reserved</p>
	</footer>
</body>

</html>