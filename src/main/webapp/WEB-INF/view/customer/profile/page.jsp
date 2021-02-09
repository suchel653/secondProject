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
			<div class="introduce">
				<div class="menu-name">
					<span>Introduce</span>
				</div>
				<div class="content">
					<span>안녕하세요 서울에서 코딩공부를 하고 있는 김자바라고 합니다.
						코딩공부를 시작한지는 이제 6개월정도 되었고 java, js, spring, mysql을 조금 알고 있습니다.
						웹 프로그래머가 되는 것이 목표입니다.</span>
				</div>
			</div>
			<div class="language selected">
				<div class="menu-name">
					<span>Language</span>
				</div>
				<table class="language-table">
					<tr>
						<td>
							<img src="/images/language/c.png">
							<div>c</div>
						</td>
						<td>
							<img src="/images/language/c++.png">
							<div>c++</div>
						</td>
						<td>
							<img src="/images/language/cSharp.png">
							<div>c#</div>
						</td>
					</tr>					
					<tr>
						<td>
							<img src="/images/language/css.png">
							<div>css</div>
						</td>
						<td>
							<img src="/images/language/go.png">
							<div>go</div>
						</td>
						<td>
							<img src="/images/language/html.png">
							<div>html</div>
						</td>
					</tr>
					<tr>
						<td>
							<img src="/images/language/java.png">
							<div>java</div>
						</td>
						<td>
							<img src="/images/language/javaScript.png">
							<div>js</div>
						</td>
						<td>
							<img src="/images/language/swift.png">
							<div>swift</div>
						</td>
					</tr>
				</table>
			</div>
			<div class="skill">
				<div class="menu-name">
					<span>Skill</span>
				</div>
			</div>
			<div class="career">
				<div class="menu-name">
					<span>Career</span>
				</div>
			</div>
		</div>
	</div>
</body>
</html>