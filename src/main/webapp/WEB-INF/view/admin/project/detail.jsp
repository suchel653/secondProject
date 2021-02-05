<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<main id="main" class="main detail">
			<h1 class="d-none">메인이다</h1>
			
			<div class="container">
				
				<section>
				<div class="del-btn" style="margin-left:30px;">
					<a href="${pj.id }/del" class="button delBtn">삭제</a>
				</div>
				
					<h1>${pj.title}</h1>
	
					<div class="detail-container">
						<img src="/images/projectImg/${pj.image }" style="width:300px; height:300px;"></img>
						<table border="1">
							<tbody>
							<tr>
								<th>분야 : </th><td >${pj.fieldName }</td>
							</tr>
							<tr>
								<th>기술 : </th>
								<td>
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
								<td>
									<c:forEach var="l" items="${pj.languages }" varStatus="st">
									${l.languageName } 
									<c:if test="${!st.last }">
										/
									</c:if>
									</c:forEach>
								</td>
							</tr>
							<tr>
			                  <th>파일 : </th>
			                  <td>
								<c:forEach var="f" items="${pj.files }" varStatus="st">
								<a download href="/images/projectFile/${f.name }">${f.name }</a> 
								<c:if test="${!st.last }">
									/
								</c:if>
								</c:forEach>
							 </td>
			                </tr>
							<tr>
								<th>인원 : </th>
								<td >${pj.limitNumber }</td>
							</tr>
							<tr>
								<th>요구사항 :</th>
								<td >${pj.requirement }</td>
							</tr>
							<tr>
								<th>진행일 : </th>
								<td >
									<fmt:formatDate value="${pj.startDate}" pattern="yyyy-MM-dd"/>~
									<fmt:formatDate value="${pj.endDate }" pattern="yyyy-MM-dd"/>
								</td>
							</tr>
							<tr>
								<th>상태 : </th><td >${pj.statusName }</td>
							</tr>
							<tr>
								<th>작성자 : </th><td >${pj.leaderName }</td>
							</tr>
							<tr>
								<th>등록일  :</th>
								<td >
									<fmt:formatDate value="${pj.regDate }" pattern="yyyy-MM-dd"/>
								</td>
							</tr>
							</tbody>
							</table>
						</div>
						
						<div class="content" >${pj.content }</div>
				
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