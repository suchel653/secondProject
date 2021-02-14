<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<script src="/js/customer/header.js"></script>
<header id="header" class="header">
	<div class="container">
		<div class="logo">
			<a href="/index">
				<h1>B.E.O</h1>
			</a>
		</div>

		<nav class="header-list">
			<h1 class="d-none">헤더 목록</h1>
			<ul>
				<li><a href="/customer/project/list">프로젝트</a></li>
				<li><a href="/customer/study/list">스터디</a></li>
				<li><a href="/customer/contest/list">공모전</a></li>
			</ul>
		</nav>

		<nav class="member-list">
			<h1 class="d-none">멤버</h1>
			<ul class="member-info">

				<s:authorize access="isAnonymous()">
					<li><a href="/customer/login">로그인</a></li>
					<li><a href="/customer/join">회원가입</a></li>
				</s:authorize>
				<s:authorize access="isAuthenticated()">
					<div class="profile-box">
						<div class="profile-box2">
							<div class="profile">

								<img class="profile-img" src="/images/language/c.png" /> 
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