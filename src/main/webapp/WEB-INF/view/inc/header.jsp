<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
<script src="/js/customer/header.js"></script>

<header id="header" class="header">
	<div class="container">
		<div class="logo">
			<a href="/index">
				<h1>GGIRIGGIRI</h1>
			</a>
		</div>

		<nav class="header-list">
			<h1 class="d-none">헤더 목록</h1>
			<ul>
				<li><a href="/customer/project/list">Project</a></li>
				<li><a href="/customer/study/list">Study</a></li>
				<li><a href="/customer/contest/list">Contest</a></li>
			</ul>
		</nav>

		<nav class="member-list">
			<h1 class="d-none">멤버</h1>
			<ul class="member-info">

				<s:authorize access="isAnonymous()">
					<li><a href="/customer/login">Login</a></li>
				</s:authorize>
				
				<s:authorize access="isAuthenticated()">
					<div class="profile-box">
					
						<div class="profile-box2">
						
							<div class="profile">

								<c:if test="${sessionScope.image =='profileBasic.png'}">
									<img class="profile-img" src="/images/profileImg/profileBasic.png" /> 
								</c:if>
								
								<c:if test="${sessionScope.image !='profileBasic.png'}">
									<img class="profile-img" src="/images/profileImg/${sessionScope.id}/${sessionScope.image}"/> 
								</c:if>
								
								<span class="profile-user-name">${nickname}</span>
							</div>
							
						</div>
						<input type="hidden" class="id" value=${sessionScope.id }>
					</div>
				</s:authorize>
			</ul>
		</nav>
		
		
	</div>
</header>