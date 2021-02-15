<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="/js/customer/activity/group/study/info.js"></script>
<link href="/css/customer/activity/group/info/index.css" type="text/css" rel="stylesheet" />

<main id="main" class="main detail dmain">
	<!-- <h1 class="d-none">스터디 정보</h1> -->

	<div class="container">
		<section>
		
			<div class="title">
				<h1 class="flux">${s.title}</h1>
			</div>

			<div class="detail-container">
				<c:if test="${s.image != 'img1.jpg'}">
					<img class="p-image" src="/images/studyImg/${s.id}/${s.image}"></img>
				</c:if>
				<c:if test="${s.image == 'img1.jpg'}">
					<img class="p-image" src="/images/studyImg/${s.image}"></img>
				</c:if>

				<table>
					<tbody>
						<tr>
							<th>field</th>
							<td>${s.fieldName }</td>
						</tr>
						<tr>
							<th>skill</th>
							<td>
								<c:forEach var="s" items="${s.skill }" varStatus="st">
									${s.skillName } 
									<c:if test="${!st.last }">
										/
									</c:if>
								</c:forEach>
							</td>
						</tr>
						<tr>
							<th>language</th>
							<td><c:forEach var="l" items="${s.language}" varStatus="st">
									<img src="/images/language/${l.image}" style="width: 40px; height: 40px;" />
								</c:forEach>
							</td>
						</tr>
						<tr>
							<th>file</th>
							<td><c:forEach var="f" items="${s.files}" varStatus="st">
									<a download href="/images/studyFile/${s.id}/${f.name}">${f.name}</a>
									<c:if test="${!st.last }">
										/
									</c:if>
								</c:forEach>
							</td>
						</tr>
						<tr>
							<th>recruitment</th>
							<td>${s.limitNumber}</td>
						</tr>
						<tr>
							<th>requirement</th>
							<td>${s.requirement }</td>
						</tr>
						<tr>
							<th>Progress Date</th>
							<td>
								<fmt:formatDate value="${s.startDate}" pattern="yyyy-MM-dd" />
								~ 
								<fmt:formatDate value="${s.endDate }" pattern="yyyy-MM-dd" />
							</td>
						</tr>

						<tr>
							<th>leader</th>
							<td>${s.leaderName }</td>
						</tr>
						<tr>
							<th>registration date</th>
							<td><fmt:formatDate value="${s.regDate }"
									pattern="yyyy-MM-dd" />
							</td>
						</tr>
					</tbody>
				</table>
			</div>

			<div class="content">${s.content}</div>

			<a value="창 닫기" class="close-Btn neon-btn blue" > 창 닫기</a>
			
		</section>

</main>