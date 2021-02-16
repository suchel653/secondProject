<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/customer/activity/group/project/board/reg.js"></script>
<link href="/css/customer/activity/group/reg.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<input class="projectId" type="hidden" value="${projectId}"/>
	<input class="writerId" type="hidden" value="${writerId}"/>
	 <h1 class="reg-title">게시글 등록</h1>
	 <div class="flex">
    <table class="reg-table">
        <tbody>
			<tr>
				<td>제목</td>
				<td><input class="title" type="text"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea class="content"></textarea></td>
			</tr>
			
		</tbody>
	</table>
	<div class="btn">
	<input class="reg-btn" type="button" value="등록"/> 
	<input class="cancel-btn" type="button" value="취소"/> 
	</div>
	</div>
</body>
</html>