<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.24.0/moment.min.js"></script>
<script src="/js/customer/activity/group/study/index.js"></script>
<script src="/js/customer/activity/group/chat-client.js"></script>
<link href="/css/reset.css" type="text/css" rel="stylesheet" />
<link href="/css/customer/activity/group/index.css" type="text/css" rel="stylesheet" />
</head>
<body>
	<div class="container">
		<div class="box1">
			<div class="info-div">
				<input hidden value="${sv.id}" /> 
				<Button class="info-Btn">Information</Button>
			</div>

			<div class="img-div">
				<div class="main-img">
					<c:if test="${sv.image != 'img1.jpg'}">
						<img src="/images/studyImg/${sv.id}/${sv.image}"></img>
					</c:if>
					<c:if test="${sv.image == 'img1.jpg'}">
						<img src="/images/studyImg/${sv.image}"></img>
					</c:if>
				</div>
				<button class="snip1535">팀원 정보</button>
				<div class="team-info">
					<div class="member-info">
						<div class="team-leader">팀장 : ${sv.leaderName} 
						<input type="button" class="btn-two mini purple" onclick="window.open('/customer/profile/${sv.leaderId}','win','width=900,height=500')" value="프로필 보기"/></div>
					</div>
					<c:forEach var="sav" items="${sav}">
						<div class="member-info">
							<div class="team-member">팀원 : ${sav.memberNickname} 
							<input type="button" class="btn-two mini purple" onclick="window.open('/customer/profile/${sav.memberId}','win','width=900,height=500')" value="프로필 보기"/></div>
						</div>
					</c:forEach>
				</div>
			</div>
			<input hidden class="pageStatus" value="${pageStatus}" />
			<c:if test="${sessionScope.id == sv.leaderId}">
				<div class="apply-div">
					<div class="apply-btn-div">
						<input type="button" value="지원 관리" class="apply-Btn btn-two small yellow"/>
					</div>
					<form action="approve" method="post">
						<div>
						  <table class="apply-table">
						  	<tbody class="tbody">
						  		<c:forEach var="swv" items="${swv}">
							  		<tr class="tr">
								  		<td>
								  			<p class="apply-p">${swv.memberNickname}님이 지원하였습니다. 
								  				<span class="date-fmt"><fmt:formatDate value="${swv.regDate}" pattern="yyyy-MM-dd a hh:mm:ss" /></span>
								  			</p>
								  			<div>
									  			<li style="display:none;">${swv.comment}
									  			<input type="button" class="btn-two mini purple" onclick="window.open('/customer/profile/${swv.memberId}','win','width=900,height=500')" value="프로필 보기"/>
									  			</li>
								  			</div>
								  			<input hidden class="commentValue" value="0" />
								  		</td>
								  		<td>
								  			<input hidden name="studyId" value="${swv.studyId}" />
								  			<input hidden name="memberId" value="${swv.memberId}" />
								  			<input type="submit" name="action" class="btn-two mini cyan" value="승인"/>
								  		</td>
								  		<td>
								  			<input hidden name="studyId" value="${swv.studyId}" />
								  			<input hidden name="memberId" value="${swv.memberId}" />
								  			<input type="submit" name="action" class="btn-two mini red" value="거절"/>
								  		</td>
									</tr>
								</c:forEach>
						  	</tbody>
						  </table>
						</div>
					</form>
				</div>
			</c:if>
			<c:if test="${sessionScope.id == sv.leaderId}">
				<div class="status-box">
				<input type="hidden" class="status-id" value="${sv.statusId}"/>
					<c:if test="${sv.statusId==1}">
						<input class="start-btn" type="button" value="시작"/>
					</c:if>
					<c:if test="${sv.statusId==2}">
						<input class="end-btn" type="button" value="종료"/>
					</c:if>
				</div>
			</c:if>
			<c:if test="${sv.statusId==3}">
				<div class="status-box">
					<span>종료된 스터디입니다.</span>
				</div>
			</c:if>
		</div>

		<input type="hidden" class="memberId" value="${id}">
		<div class="box2">
			<div class="board-table">
				<div>
					<h1 class="board-h1">BOARD</h1>
					<input class="board-reg" type="button" value="등록"/>
				</div>
				<div class="bodrd">
					<table class="board-table2">
						<thead>
						<tr>
						
							<th class="large">제목</th>
							<th class="small">작성자</th>
							<th class="middle">등록일</th>
						</tr>
						</thead>
						<tbody class="boardTbody">
						</tbody>
					</table>

				</div>
				<input class="board-plus-btn" type="button" value="+" />
			</div>
		</div>

		<div class="box3">
			<div class="date-div">
				<h1>일정 공유</h1>
				<div class="date-div-box"></div>
			</div>

			<div class="chat" style="display: flex; flex-direction: column; align-items: center; justify-content: space-around;width:300px;height:300px;border: 1px solid black">
				<h1>팀 채팅</h1>
				<input class="type" type="hidden" value="1" >
				<input class="img" type="hidden" value="${image}">
				<input class="nickname" type="hidden" value="${nickname}" >
				<input class="id" type="hidden" value="${sessionScope.id}" >
		  		<input class="chat-id" type="hidden" value="${sv.id}" >
		   		<input class="chat-input" autofocus="autofocus" type = "text" id = "message" style = "height : 30px; width : 340px" placeholder="내용을 입력하세요" autofocus>
				<button class = "send-btn" id = "send">전송</button>
				<!-- <input type="button" value="채팅" /> -->
			</div>
		</div>
	</div>
</body>
</html>