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
<script src="https://kit.fontawesome.com/b280fc7aa7.js"
	crossorigin="anonymous"></script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<input type="hidden" class="member-id" value=${p.memberId }>
	<input type="hidden" class="mypage" value=${mypage }>

	<div class="container">
		<div class="menu">
			<div class="profile-img">
				<img src="/images/profileImg/profileBasic.png">
			</div>
			<div class="nickname">
				<span>${m.nickname }</span>
			</div>
			<div class="menu-bar">
				<div class="intro">Intro</div>
				<div class="language">Language</div>
				<div class="skill">Skill</div>
			</div>
		</div>
		<div class="detail">
			<div class="intro selected">
				<div class="menu-name">
					<span>Intro</span>
				</div>
				<div class="intro-list">
					<div class="ability">
						<div class="intro-language">
							<div class="title">Language</div>
							<div class="content">
								<c:set var="langCount" value="0" />
								<c:forEach var="pl" items="${p.languageList }">
									<c:if test="${langCount < 3 }">
										<c:if test="${pl.level > 0}">
											<img src="/images/language/${pl.image}">
											<c:set var="langCount" value="${langCount + 1 }" />
										</c:if>
									</c:if>
								</c:forEach>
							</div>
						</div>
						<div class="intro-skill">
							<div class="title">Skill</div>
							<div class="content">
								<c:set var="skillCount" value="0" />
								<c:forEach var="ps" items="${p.skillList }" varStatus="status">
									<c:if test="${skillCount < 3 }">
										<c:if test="${ps.level > 0}">
											<img
												src="/images/profileImg/profileSkill/${status.index}.png">
											<c:set var="skillCount" value="${skillCount + 1 }" />
										</c:if>
									</c:if>
								</c:forEach>
							</div>
						</div>
					</div>
					<div class="intro-introduce">
						<div class="title">Introduce</div>
						<div class="content">
							<c:choose>
								<c:when test="${empty p.introduction || p.introduction == null}">이곳에 자기 소개글을 넣어주세요</c:when>
								<c:otherwise>${p.introduction}</c:otherwise>
							</c:choose>
						</div>
					</div>
					<div class="intro-hangout">
						<div class="title">Hang-out</div>
						<div class="content">
							<div class="address">
								<c:choose>
									<c:when test="${empty p.address || p.address == null}"><div class="edit">집 주소 등록하기</div></c:when>
									<c:otherwise><div>${p.address}</div></c:otherwise>
								</c:choose>
							</div>
							<div class="git">
								<c:choose>
									<c:when test="${empty p.repositoryLink || p.repositoryLink == null}"><div class="edit">깃 주소 등록하기</div></c:when>
									<c:otherwise><div>${p.repositoryLink}</div><div class="gitLink">바로가기</div></c:otherwise>
								</c:choose>
							</div>
						</div>
					</div>
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
							</div> <input type="hidden" value="${pl.level}" class="language-level">
							<i class="fas fa-minus-circle language-minus"></i> 
							<i class="fas fa-square language-level-bar"></i> 
							<i class="fas fa-square language-level-bar"></i> 
							<i class="fas fa-square language-level-bar"></i> 
							<i class="fas fa-plus-circle language-plus"></i>
						</li>
					</c:forEach>
				</ul>
			</div>
			<div class="skill">
				<div class="menu-name">
					<span>Skill</span>
				</div>
				<ul class="skill-list">
					<c:forEach var="ps" items="${p.skillList }" varStatus="status">
						<li class="skill-items">
							<div>
								<img src="/images/profileImg/profileSkill/${status.index}.png">
								<div>${ps.skillName}</div>
							</div> <input type="hidden" value="${ps.level}" class="skill-level">
							<i class="fas fa-minus-circle skill-minus"></i> 
							<i class="fas fa-square skill-level-bar"></i> 
							<i class="fas fa-square skill-level-bar"></i> 
							<i class="fas fa-square skill-level-bar"></i> 
							<i class="fas fa-plus-circle skill-plus"></i>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>