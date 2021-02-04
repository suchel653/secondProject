<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/js/customer/activity/group/study/index.js"></script>
<link href="/css/reset.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="container"
		style="width: 1500px; height: 900px; border: 1px solid black; display: flex;">
		<div class="box1"
			style="width: 500px; hegiht: 900px; border: 1px solid black;">
			<div
				style="display: flex; flex-direction: column; align-items: center;">
				<input hidden value="${sv.id}" /> 
				<input type="button" value="정보" class="info" />
			</div>

			<div
				style="display: flex; flex-direction: column; align-items: center;">
				<h1>팀원 정보</h1>
				<div>
					<div style="width: 100px; border: 1px solid black; text-align: center;">팀장 : ${sv.leaderName}</div>
				</div>
				<c:forEach var="sav" items="${sav}">
					<div>
						<div style="width: 100px; border: 1px solid black; text-align: center;">팀원 : ${sav.memberNickname}</div>
					</div>
				</c:forEach>
			</div>
			<div style="display: flex; flex-direction: column; align-items: center;">
				<input hidden class="pageStatus" value="${pageStatus}" />
				<input type="button" value="지원 관리" class="apply-Btn"/>
				
				<form action="approve" method="post">
					<div>
					  <table class="table">
					  	<tbody class="tbody">
					  		<c:forEach var="swv" items="${swv}">
						  		<tr>
							  		<td>
							  			<span>${swv.memberNickname}님이 지원하였습니다.</span>
										<span class="date-fmt"><fmt:formatDate value="${swv.regDate}" pattern="yyyy-MM-dd a hh:mm:ss" /></span>
							  		</td>
							  		<td>
							  			<input hidden name="studyId" value="${swv.studyId}" />
							  			<input hidden name="memberId" value="${swv.memberId}" />
							  			<input type="submit" name="action" value="승인"/>
							  		</td>
							  		<td>
							  			<input hidden name="studyId" value="${swv.studyId}" />
							  			<input hidden name="memberId" value="${swv.memberId}" />
							  			<input type="submit" name="action" value="거절"/>
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
					<input type="button" value="등록" style="margin-left: 30px;" />
				</div>
				<div>
					<table>
						<thead>
							<th>번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>등록일</th>
						</thead>
						<tbody>
							<td>1</td>
							<td>안녕하세요</td>
							<td>성현</td>
							<td>2010-03-02</td>
						</tbody>
					</table>

				</div>
				<input type="button" value="+" />
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