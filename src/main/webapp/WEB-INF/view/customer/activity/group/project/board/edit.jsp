<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/customer/activity/group/project/board/edit.js"></script>
<link href="/css/customer/activity/group/reg.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<input class="boardId" type="hidden" value="${pb.id}"/>
	
	 <h1 class="reg-title">게시글 수정</h1>
	 <div class="flex">
	<table class="reg-table">
		<tbody>
			<tr>
				<td>제목</td>
				<td><input class="title" type="text" value="${pb.title}"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea class="content">${pb.content}</textarea></td>
			</tr>
			
		</tbody>
	</table>
	<div class="btn">
	<input class="edit-btn" type="button" value="수정"/> 
	<input class="cancel-btn" type="button" value="취소"/> 
	</div>
	</div>
</body>
</html>