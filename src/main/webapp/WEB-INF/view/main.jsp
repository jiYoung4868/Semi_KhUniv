<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=<device-width>, initial-scale=1.0">
<title>KH 대학교</title>

<link rel="stylesheet" href="/resources/css/reset.css">

<style>
* {
	font-family: Arial, Helvetica, sans-serif;
}

header, .content, footer {
	box-sizing: border-box;
	/*중앙정렬*/
	width: 960px;
	margin: 0 auto;
	border: 1px solid black;
	display: flex;
	justify-content: center;
	align-items: center;
}
</style>

<style>
header {
	position: relative;
	height: 200px;
}

header>.top-menu {
	position: absolute;
	right: 5px;
	top: 5px;
}

.top-menu td {
	border: 1px black solid;
	padding: 0;
	margin: 10px;
}

.top-menu td:hover {
	background-color: black;
	color: white;
}

header>.main-menu {
	position: absolute;
	bottom: 0;
	right: 5px;
	margin: 10px;
}

.main-menu tr {
	margin: 10px;
}

.main-menu td {
	border: 1px black solid;
	padding: 0;
	margin: 5px;
}

.main-menu td:hover {
	background-color: black;
	color: white;
}

.s_title {
	font-size: 20px;
	margin: 0;
	font-weight: bold;
}

.b_title {
	font-size: 30px;
	font-weight: bold;
	margin: 0;
}

.main-content {
	width: 1600px;
	height: 300px;
	display: flex;
	justify-content: center;
	align-items: baseline;
	margin: 10px;
	position: relative;
}

.notice-table {
	width: 600px;
	height: 50px;
	border: 1px solid black;
	margin-top: auto;
}

.notice-table td {
	border: 1px solid black;
	text-align: center;
}

.lower-content {
	width: 1600px;
	height: 100px;
	display: flex;
	justify-content: center;
	align-items: center;
	margin: 10px;
	position: relative;
}

.menu-button {
	width: 600px;
	height: 70px;
	border: 1px solid black;
}

.menu-button td {
	border: 1px solid black;
	text-align: center;
}
</style>

</head>

<body>
<jsp:include page="/WEB-INF/view/msg.jsp"></jsp:include>
	<div class="wrap-header">
		<header>
			<div>
				<p class="s_title">KH 정보교육대학교</p>
				<p class="b_title">자바개발학과</p>
			</div>
			<div class="top-menu">
				<table>
					<tr>
						<td>
							<div>
							<c:choose>
								<c:when test="${not empty loginId }">
									<a href="${pageContext.request.contextPath}/logout.do">로그아웃</a>
								</c:when>
								<c:otherwise>
									<a href="${pageContext.request.contextPath}/login">로그인</a>
								</c:otherwise>
							</c:choose>
							</div>
						</td>
					</tr>
				</table>
			</div>
			<div class="main-menu">
				<table>
					<tr>
						<td>학과 소개</td>
						<td>교수 소개</td>
						<td>학사 정보</td>
						<td>커뮤니티</td>
						<td>자료실</td>
					</tr>
				</table>
			</div>
		</header>
	</div>
	<div class="main-content">
		<table class="notice-table">
			<tr>
				<td><a href="<%=request.getContextPath()%>/notice">공지사항</a></td>
				<td>notice content</td>
				<td>button</td>
				<td>banner</td>
			</tr>
		</table>
	</div>
	<div class="lower-content">
		<table class="menu-button">
			<tr>
				<td>학과소개</td>
				<td>교수소개</td>
				<td>학사일정</td>
				<td>자료실보기</td>
			</tr>
		</table>
	</div>
	<div>
		<footer>
			<p>서울특별시 강남구 테헤란로14길 6 [6층]</p>
			<p>Copyright © 1998-2023 KH Information Educational Institute All
				Right Reserved</p>
		</footer>
	</div>

</body>

</html>