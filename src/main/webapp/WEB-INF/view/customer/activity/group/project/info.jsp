<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="/js/customer/activity/group/project/info.js"></script>
<link href="/css/reset.css" type="text/css" rel="stylesheet" />
<link href="/css/customer/activity/group/info/index.css" type="text/css" rel="stylesheet" />

<main id="main" class="main detail dmain">
	<!-- <h1 class="d-none">프로젝트 정보</h1> -->

	<div class="container">
		<section>

			<div class="title">
				<h1 class="flux">${pv.title}</h1>
			</div>

			<div class="detail-container">
				<img class="p-image" src="/images/projectImg/${pv.image }"
					style="width: 300px; height: 300px;"></img>
				
				<table>
					<tbody>
						<tr>
							<th>Field :</th>
							<td>${pv.fieldName }</td>
						</tr>
						<tr>
							<th>skill :</th>
							<td><c:forEach var="s" items="${pv.skills }" varStatus="st">
						${s.skillName } 
						<c:if test="${!st.last }">
							/
						</c:if>
								</c:forEach></td>
						</tr>
						<tr>
							<th>language :</th>
							<td><c:forEach var="l" items="${pv.languages }"
									varStatus="st">
									<img src="/images/language/${l.image}"
										style="width: 40px; height: 40px;" />
								</c:forEach></td>
						</tr>
						<tr>
							<th>File :</th>
							<td><c:forEach var="f" items="${pv.files }" varStatus="st">
									<a download href="/images/projectFile/${f.name }">${f.name }</a>
									<c:if test="${!st.last }">
						/
					</c:if>
								</c:forEach></td>
						</tr>
						<tr>
							<th>recruitment :</th>
							<td>${pv.memberCount}/${pv.limitNumber }</td>
						</tr>
						<tr>
							<th>requirement :</th>
							<td>${pv.requirement }</td>
						</tr>
						<tr>
							<th>Progress Date :</th>
							<td><fmt:formatDate value="${pv.startDate}"
									pattern="yyyy-MM-dd" />~ <fmt:formatDate value="${pv.endDate }"
									pattern="yyyy-MM-dd" /></td>
						</tr>
						<tr>
							<th>status :</th>
							<td>${pv.statusName}</td>
						</tr>
						<tr>
							<th>leader :</th>
							<td>${pv.leaderName }</td>
						</tr>
						<tr>
							<th>registration date :</th>
							<td><fmt:formatDate value="${pv.regDate }"
									pattern="yyyy-MM-dd" /></td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="content-box content">${pv.content }</div>
			
			<a value="창 닫기" class="close-Btn neon-btn blue" >창 닫기
			<span></span>
			<span></span>
			<span></span>
			<span></span>
			</a>

		</section>

	</div>
</main>