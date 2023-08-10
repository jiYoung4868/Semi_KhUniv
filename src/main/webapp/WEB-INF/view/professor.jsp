<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=<device-width>, initial-scale=1.0">
<title>교수 소개</title>

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
	margin: 10px;
	position: relative;
}

.main-content {
	width: 1600px;
	margin: 20px;
	display: flex;
	position: relative;
	align-items: flex-start;
}

.aside-button div {
	width: 100px;
	height: 50px;
	border: 1px solid black;
	padding: 0px;
	margin-left: 200px;
	text-align: center;
	display: flex;
	justify-content: center;
	align-items: center;
}

.professor-table {
	display: flex;
	margin-left: 200px;
}

.professor-table tr, td {
	border: 1px solid black;
}
</style>

</head>

<body>
	<div class="wrap-header">
		<header>
			<div>
				<p class="s_title">KH 정보교육대학교</p>
				<p class="b_title">자바개발학과</p>
			</div>
			<div class="top-menu">
				<table>
					<tr>
						<td>login</td>
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
		<div class="aside-button">

			<div>교수 소개</div>
			<div>전임교수</div>
			<div>명예교수</div>
			<div>출강교수</div>

		</div>

		<div>
			<div class="professor-info">
				<table class="professor-table">
					<tr>
						<td>교수 이름</td>
						<td>get</td>
					</tr>
					<tr>
						<td>소속 학과</td>
						<td>get</td>
					</tr>
					<tr>
						<td>담당 과목</td>
						<td>get</td>
				</table>
			</div>
		</div>
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