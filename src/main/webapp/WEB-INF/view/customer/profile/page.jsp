<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<script src="/js/customer/profile/page.js"></script>
<link href="/css/reset.css" type="text/css" rel="stylesheet" />
<link href="/css/customer/profile.css" type="text/css" rel="stylesheet" />
<script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<input type="hidden" class="member-id" value=${p.memberId }>

	<div class="container">
		<div class="menu">
			<div class="profile-img">
				<img src="/images/profileImg/profileBasic.png">
			</div>
			<div class="nickname">
				<s:authorize access="isAuthenticated()">
				<span>${nickname }</span>
				</s:authorize>
			</div>
			<div class="menu-bar">
				<div class="introduce">Introduce</div>
				<div class="language">Language</div>
				<div class="skill">Skill</div>
				<div class="career">Career</div>
			</div>
		</div>
		<div class="detail">
			<div class="introduce selected">
				<div class="menu-name">
					<span>Introduce</span>
				</div>
				<div class="content">
					<span>안녕하세요 서울에서 코딩공부를 하고 있는 김자바라고 합니다.
						코딩공부를 시작한지는 이제 6개월정도 되었고 java, js, spring, mysql을 조금 알고 있습니다.
						웹 프로그래머가 되는 것이 목표입니다.</span>
				</div>
			</div>
			<div class="language">
				<div class="menu-name">
					<span>Language</span>
				</div>
				<ul class="language-list">
					<c:forEach var="pl" items="${p.languageList }">
						<li class="language-items">
							<div>
								<img src="/images/language/${pl.image}">
								<div>${pl.languageName}</div>
							</div>
							<input type="text" value="${pl.level}" class="language-level"> 
							<i class="fas fa-minus-circle"></i>
							<i class="fas fa-plus-circle"></i>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="skill">
				<div class="menu-name">
					<span>Skill</span>
				</div>
				<ul class="language-list">
					<c:forEach var="ps" items="${p.skillList }" varStatus="status">
						<li class="skill-items">
							<div>
								<img src="/images/profileImg/profileSkill/${status.index}.png">
								<div>${ps.skillName}</div>
							</div>
							<input type="text" value="${ps.level}" class="skill-level"> 
							<i class="fas fa-minus-circle"></i>
							<i class="fas fa-plus-circle"></i>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="career">
				<div class="menu-name">
					<span>Career</span>
				</div>
			</div>
			<input type="button" value="제출" id="submit">
		</div>
	</div>
</body>
</html>