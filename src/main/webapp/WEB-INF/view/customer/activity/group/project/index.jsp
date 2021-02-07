<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/customer/activity/group/project/index.js"></script>
<link href="/css/reset.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="container"
		style="width: 1500px; height: 900px; border: 1px solid black; display: flex;">
		<div class="box1"
			style="width: 500px; hegiht: 900px; border: 1px solid black;">
			<div
				style="display: flex; flex-direction: column; align-items: center;">
				<input hidden value="${pv.id}" /> 
				<input type="button" value="정보" class="info" />
			</div>

			<div
				style="display: flex; flex-direction: column; align-items: center;">
				<h1>팀원 정보</h1>
				<div>
					<div style="width: 100px; border: 1px solid black; text-align: center;">팀장 : ${pv.leaderName}</div>
				</div>
				<c:forEach var="pav" items="${pav}">
					<div>
						<div style="width: 100px; border: 1px solid black; text-align: center;">팀원 : ${pav.memberNickname}</div>
					</div>
				</c:forEach>
			</div>
			<div style="display: flex; flex-direction: column; align-items: center;">
				<input type="button" value="지원 관리" class="apply-Btn"/>
				
				<form action="approve" method="post">
					<div class="panel">
					  <table>
					  	<tbody class="tbody">
					  		<c:forEach var="pwv" items="${pwv}">
					  			
						  		<tr>
							  		<td>
							  			<span>${pwv.memberNickname}님이 지원하였습니다.</span>
										<span class="date-fmt"><fmt:formatDate value="${pwv.regDate}" pattern="yyyy-MM-dd a hh:mm:ss" /></span>
							  		</td>
							  		<td>
							  			<input hidden name="id" value="${pwv.projectId}" />
							  			<input hidden name="id" value="${pwv.memberId}" />
							  			<input class="a" type="submit" name="action" value="승인">
							  		</td>
							  		<td>
							  			<input hidden name="id" value="${pwv.projectId}" />
							  			<input hidden name="id" value="${pwv.memberId}" />
							  			<input class="b" type="submit" name="action" value="거절">
							  		</td>
								</tr>
							</c:forEach>
					  	</tbody>
					  </table>
					</div>
				</form>
			</div>

		</div>

		<div class="box2"
			style="width: 500px; hegiht: 900px; border: 1px solid black;">
			<div class="table"
				style="display: flex; flex-direction: column; align-items: center;">
				<div>
					<h1 style="display: inline-block; margin-left: 50px;">게시판</h1>
					<input class="board-reg" type="button" value="등록" style="margin-left: 30px;" />
				</div>
				<div class="board">
					<table>
						<thead>
						<tr>
							
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>
						</tr>
						</thead>
						<tbody class="boardTbody">
						
						<!-- <tr>
							<td colspan="4" style="border:1px solid black; height:100px;">asdasdasdasdas</td>
						</tr>
						<tr>
							<td colspan="4" style="border:1px solid black;">
								<div>댓글1</div>
								<div>댓글2</div>
							</td>
						</tr> -->
						</tbody>
					</table>

				</div>
				<input class="board-plus-btn" type="button" value="+" />
			</div>
		</div>

		<div class="box3"
			style="width: 500px; hegiht: 900px; border: 1px solid black;">
			<div
				style="display: flex; flex-direction: column; align-items: center;">
				<h1>일정 공유</h1>
				<div style="width: 300px; height: 300px; border: 1px solid black;"></div>
			</div>

			<div style="display: flex; flex-direction: column; align-items: center; justify-content: space-around;">
				<h1>팀 채팅</h1>
				<input type="button" value="채팅" />
			</div>
		</div>
	</div>
</body>
</html>