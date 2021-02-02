<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="/js/customer/activity/study/info.js"></script>

<main id="main" class="main">
	<h1 class="d-none">스터디 정보</h1>

	<div class="container">
		<section>

			<div class="title">
				<h1>${s.title}</h1>
			</div>

			<div>
				<img src="/images/language/${s.image }"></img>
				<table border="1">
					<tbody>
						<tr>
							<th>분야 :</th>
							<td>${s.fieldName }</td>
						</tr>
						<tr>
							<th>기술 :</th>
							<td><c:forEach var="s" items="${s.skill }" varStatus="st">
								${s.skillName } 
								<c:if test="${!st.last }">
									/
								</c:if>
								</c:forEach></td>
						</tr>
						<tr>
							<th>언어 :</th>
							<td><c:forEach var="l" items="${s.language }" varStatus="st">
								${l.languageName } 
								<c:if test="${!st.last }">
									/
								</c:if>
								</c:forEach></td>
						</tr>
						<tr>
							<th>인원 :</th>
							<td>${s.limitNumber}</td>
						</tr>
						<tr>
							<th>요구사항 :</th>
							<td>${s.requirement }</td>
						</tr>
						<tr>
							<th>진행일 :</th>
							<td><fmt:formatDate value="${s.startDate}"
									pattern="yyyy-MM-dd" />~ <fmt:formatDate value="${s.endDate }"
									pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<th>상태 :</th>
							<td>${s.statusName }</td>
						</tr>
						<tr>
							<th>작성자 :</th>
							<td>${s.leaderName }</td>
						</tr>
						<tr>
							<th>등록일 :</th>
							<td><fmt:formatDate value="${s.regDate }"
									pattern="yyyy-MM-dd" /></td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="content-box"></div>

			<div>
				<input type="button" value="창 닫기" class="close-Btn" />
			</div>

		</section>
	</div>
</main>