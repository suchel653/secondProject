<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>



	<main id="main" class="main detail">
                <h1 class="d-none">메인이다</h1>
                <div class="container">
                
              <section>
				<h1>${s.title}</h1>

				<div class="detail-container">
					<img src="/images/studyImg/${s.image }"></img>
					<table border="1">
						<tbody>
						<tr>
							<th>분야 : </th><td colspan="2">${s.fieldName }</td>
						</tr>
						<tr>
							<th>기술 : </th>
							<td colspan="2">
								<c:forEach var="s" items="${s.skill }" varStatus="st">
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
								<c:forEach var="l" items="${s.language }" varStatus="st">
								${l.languageName } 
								<c:if test="${!st.last }">
									/
								</c:if>
								</c:forEach>
							</td>
						</tr>
						<tr>
							<th>인원 : </th>
							<td colspan="2">${s.limitNumber }</td>
						</tr>
						<tr>
							<th>요구사항 :</th>
							<td colspan="2">${s.requirement }</td>
						</tr>
						<tr>
							<th>진행일 : </th>
							<td colspan="2">
								<fmt:formatDate value="${s.startDate}" pattern="yyyy-MM-dd"/>~
								<fmt:formatDate value="${s.endDate }" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
							<th>상태 : </th><td colspan="2">${s.statusName }</td>
						</tr>
						<tr>
							<th>작성자 : </th><td colspan="2">${s.leaderName }</td>
						</tr>
						<tr>
							<th>등록일  :</th>
							<td colspan="2">
								<fmt:formatDate value="${s.regDate }" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
						</tbody>
						</table>
					</div>
					
					<div class="content" colspan="2">${s.content }</td></div>
			
			
			 <div class="btn prev-next-btn">
	                <a class="button searchBtn" href="list">목록</a>
	                <c:if test="${empty prev }">
	                <a class="button searchBtn" >이전</a>
	                </c:if>
	                <c:if test="${not empty prev}">
	                <a class="button searchBtn" href="${prev.id}">이전</a>
	                </c:if>
	                <c:if test="${empty next }">
	                <a class="button searchBtn" >다음</a>
	                </c:if>
	                <c:if test="${not empty next }">
	                <a class="button searchBtn" href="${next.id }">다음</a>
	                </c:if>
                </div>
			</section>
                
               </div>
                

                
            </main>