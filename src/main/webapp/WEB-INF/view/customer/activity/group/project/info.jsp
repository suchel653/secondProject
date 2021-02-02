<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="/js/customer/activity/project/info.js"></script>

<main id="main" class="main">
	<h1 class="d-none">프로젝트 정보</h1>

	<div class="container">
		<section>

			<div class="title">
				<h1>${p.title}</h1>
			</div>

			<div>
				<img src="/images/projectImg/${p.image }"></img>
				<table border="1">
					<tbody>
						<tr>
							<th>분야 :</th>
							<td>${p.fieldName }</td>
						</tr>
						<tr>
							<th>기술 :</th>
							<td><c:forEach var="s" items="${p.skills}" varStatus="st">
								${p.skillName } 
								<c:if test="${!st.last }">
									/
								</c:if>
								</c:forEach></td>
						</tr>
						<tr>
							<th>언어 :</th>
							<td><c:forEach var="l" items="${p.languages}" varStatus="st">
								${l.languageName } 
								<c:if test="${!st.last }">
									/
								</c:if>
								</c:forEach></td>
						</tr>
						<tr>
							<th>인원 :</th>
							<td>${p.limitNumber}</td>
						</tr>
						<tr>
							<th>요구사항 :</th>
							<td>${p.requirement }</td>
						</tr>
						<tr>
							<th>진행일 :</th>
							<td><fmt:formatDate value="${p.startDate}"
									pattern="yyyy-MM-dd" />~ <fmt:formatDate value="${p.endDate }"
									pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<th>상태 :</th>
							<td>${p.statusName }</td>
						</tr>
						<tr>
							<th>작성자 :</th>
							<td>${p.leaderName }</td>
						</tr>
						<tr>
							<th>등록일 :</th>
							<td><fmt:formatDate value="${p.regDate }"
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