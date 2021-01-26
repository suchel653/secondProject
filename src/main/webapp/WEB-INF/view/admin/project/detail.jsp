<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<main id="main" class="main detail">
			<h1 class="d-none">메인이다</h1>
			
			<section>
				<h1>${pj.title}</h1>

				<div class="detail-container">
					<img src="/images/language/${pj.image }"></img>
					<table border="1">
						<tbody>
						<tr>
							<th>분야 : </th><td colspan="2">${pj.fieldName }</td>
						</tr>
						<tr>
							<th>기술 : </th>
							<td colspan="2">
								<c:forEach var="s" items="${pj.skills }" varStatus="st">
								${s.skillName } 
								<c:if test="${!st.last }">
									/
								</c:if>
								</c:forEach>
							</td>
						</tr>
						<tr>
							<th>언어 : </th>
							<td colspan="2">
								<c:forEach var="l" items="${pj.languages }" varStatus="st">
								${l.languageName } 
								<c:if test="${!st.last }">
									/
								</c:if>
								</c:forEach>
							</td>
						</tr>
						<tr>
							<th>인원 : </th>
							<td colspan="2">${pj.limitNumber }</td>
						</tr>
						<tr>
							<th>요구사항 :</th>
							<td colspan="2">${pj.requirement }</td>
						</tr>
						<tr>
							<th>진행일 : </th>
							<td colspan="2">
								<fmt:formatDate value="${pj.startDate}" pattern="yyyy-MM-dd"/>~
								<fmt:formatDate value="${pj.endDate }" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
							<th>상태 : </th><td colspan="2">${pj.statusName }</td>
						</tr>
						<tr>
							<th>작성자 : </th><td colspan="2">${pj.leaderName }</td>
						</tr>
						<tr>
							<th>등록일  :</th>
							<td colspan="2">
								<fmt:formatDate value="${pj.regDate }" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
						</tbody>
						</table>
					</div>
					
					<div class="content" colspan="2">${pj.content }</td></div>
			
			</section>
                
                
            </main>