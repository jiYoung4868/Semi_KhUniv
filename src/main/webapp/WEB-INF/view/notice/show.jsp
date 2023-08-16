<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지 게시판</title>

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
	height: 50px;
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
<style>
.noticeContent {
	width: 1600px;
	height: 300px;
	display: flex;
	justify-content: center;
	margin: 10px;
	position: relative;
}

.noticeContent td {
	border: 1px solid black;
	justify-content: center;
	align-items: center;
	text-align: center;
}

.contentContent {
	width: 400px;
	height: 200px;
	border: 1px solid black;
	text-align: initial;
}

.nsubmit {
	text-align: center;
}

.commentBox {
	width: 1600px;
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
	margin: 10px;
}

.comment {
	width: 600px;
	border: 1px black solid;
	justify-content: center;
	align-items: center;
	text-align: center;
}

.comment td {
	width: 450px;
	border: 1px black solid;
	justify-content: center;
	align-items: center;
	text-align: center;
}

.newComment {
	justify-content: center;
	align-items: center;
	text-align: center;
}

textarea {
	resize: none;
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
				<c:if test="${loginId.memberId eq nvo.writer}">

					<form action="<%=request.getContextPath()%>/delnotice"
						method="post">
						<input type="hidden" name="noticeNo" value="${nvo.noticeNo}">
						<input type="hidden" name="writer" value="${nvo.writer}">
						<td><button type="submit" id="btnDelete">글 삭제</button></td>
					</form>

					<form action="<%=request.getContextPath()%>/editnotice"
						method="post">
					<td><button type="submit" id="btnUpdate">
							<input type="hidden" name="noticeNo" value="${nvo.noticeNo}">
							글 수정
						</button></td>
					</form>
				</c:if>

			</tr>
		</table>
	</div>

	<table class="noticeContent">
		<c:if test="${not empty nvo}">
			<tr>
				<td><strong>글 번호</strong></td>
				<td>${nvo.noticeNo}</td>
			<tr>
				<td><strong>제목</strong></td>
				<td>${nvo.noticeTitle}</td>
			</tr>
			<tr>
				<td><strong>내용</strong></td>
				<td class="contentContent">${nvo.noticeContent}</td>
			</tr>
		</c:if>
		</form>
	</table>
	<div class="commentBox">
		<table class="comment">
			<tr>
				<td>작성자</td>
				<td>내용</td>
				<td>작성 시간</td>
				<td></td>
			</tr>
			<c:if test="${not empty cvo}">
				<c:forEach items="${cvo}" var="cvo">
					<tr>
						<form action="<%=request.getContextPath()%>/delcomment.do"
							method="post">
							<input type="hidden" name="commentNo" value="${cvo.commentNo}">
							<input type="hidden" name="noticeNo" value="${cvo.noticeNo }">
							<td>${cvo.commenter}</td>
							<td>${cvo.commentContent}</td>
							<td>${cvo.cWrittenTime}</td>
							<c:if test="${loginId.memberName eq cvo.commenter}">
								<td><button type="submit" id="btnCDel">삭제</button></td>
							</c:if>
					</tr>
					</form>
				</c:forEach>
			</c:if>

			<tr class="newComment">
				<form action="<%=request.getContextPath()%>/newcomment.do"
					method="post">
					<%-- 					<c:if test="${empty loginId }">
						<script>
							alert("댓글작성은 로그인 후 사용가능합니다.");
							location.href = "${pageContext.request.contextPath}/login";
						</script>
					</c:if> --%>
					<td colspan="3"><input type="text" size="71" name="comment"
						placeholder="댓글을 입력하시오." required></td>
					<td><input type="hidden" name="noticeNo"
						value="${nvo.noticeNo}"> 
						<c:if test="${empty loginId }">
							<button type="button" onclick="commentFail();" id="btnComment">등록</button></td>
					</c:if>
					<c:if test="${not empty loginId }">
						<button type="submit" id="btnComment">등록</button>
						</td>
					</c:if>

		
					</td>
					<script>
						function commentFail() {
								alert("댓글 작성은 로그인 후 사용가능합니다.");
								location.href = "${pageContext.request.contextPath}/login";
						}
					</script>
			</tr>

			</form>

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