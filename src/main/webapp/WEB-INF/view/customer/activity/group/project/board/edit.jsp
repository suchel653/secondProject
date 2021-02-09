<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/customer/activity/group/project/board/edit.js"></script>
</head>
<body>
	<input class="boardId" type="hidden" value="${pb.id}"/>
	<table>
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
	
	<input class="edit-btn" type="button" value="수정"/> 
	<input class="cancel-btn" type="button" value="취소"/> 
	
</body>
</html>