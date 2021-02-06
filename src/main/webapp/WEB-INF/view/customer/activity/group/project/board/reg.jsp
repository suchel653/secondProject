<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/customer/activity/group/project/board/reg.js"></script>
</head>
<body>
	<input class="projectId" type="hidden" value="${projectId}"/>
	<input class="writerId" type="hidden" value="${writerId}"/>
	<table>
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
	
	<input class="reg-btn" type="button" value="등록"/> 
	<input class="cancel-btn" type="button" value="취소"/> 
	
</body>
</html>