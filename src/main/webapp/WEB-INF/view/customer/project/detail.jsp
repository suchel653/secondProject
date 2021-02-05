<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <script src="/js/customer/project/apply.js"></script>
 
	<main id="main" class="main detail dmain">
        <h1 class="d-none">메인이다</h1>
        
        <div class="container">
          <section>
          <h1 class="d-none">메인이다</h1>
          
            <div class="title">
              <h1 class="flux">${pv.title}</h1>
            </div>
            
            <div class="detail-container">
              <img class="p-image" src="/images/projectImg/${pv.image }" style="width:300px; height:300px;"></img>
              <table border="1">
                <tbody>
                <tr>
					<th>Field : </th><td >${pv.fieldName }</td>
				</tr>
                <tr>
	                <th>skill : </th>
					<td>
						<c:forEach var="s" items="${pv.skills }" varStatus="st">
						${s.skillName } 
						<c:if test="${!st.last }">
							/
						</c:if>
						</c:forEach>
					</td>
                </tr>
                <tr>
                  <th>language : </th>
                  <td>
					<c:forEach var="l" items="${pv.languages }" varStatus="st">
					<img src="/images/language/${l.image}" style="width:40px; height:40px;"/>
					</c:forEach>
				 </td>
                </tr>
                <tr>
                  <th>File : </th>
                  <td>
					<c:forEach var="f" items="${pv.files }" varStatus="st">
					<a download href="/images/projectFile/${f.name }">${f.name }</a> 
					<c:if test="${!st.last }">
						/
					</c:if>
					</c:forEach>
				 </td>
                </tr>
                <tr>
                  <th>recruitment : </th>
                  <td>${pv.limitNumber }</td>
                </tr>
                <tr>
                  <th>requirement :</th>
                  <td>${pv.requirement } </td>
                </tr>
                <tr>
                  <th>Progress Date : </th>
	                <td >
						<fmt:formatDate value="${pv.startDate}" pattern="yyyy-MM-dd"/>~
						<fmt:formatDate value="${pv.endDate }" pattern="yyyy-MM-dd"/>
					</td>
                </tr>
                <tr>
	                  <th>status : </th><td >${pv.statusName}</td>
                </tr>
                <tr>
                  <th>leader : </th><td >${pv.leaderName }</td>
                </tr>
                <tr>
                  <th>registration date :</th>
                  <td >
                    <fmt:formatDate value="${pv.regDate }" pattern="yyyy-MM-dd"/>
                  </td>
                </tr>
                </tbody>
                </table>
              </div>
              
              <div class="content-box content">${pv.content }</div>
          
            </section>

			<input class="projectId" type="hidden" value="${pv.id }"/>
			
            
            <div class="btn prev-next-btn">
            
				<c:if test="${pv.memberCount < pv.limitNumber }">
				<a class="apply-btn neon-btn pink" href="">지원하기
					<span></span>
	                <span></span>
	                <span></span>
	                <span></span>
				</a>
				</c:if>
            
                <a class="neon-btn green" href="list">목록
                	<span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </a>
                <c:if test="${empty prev }">
                <a class="neon-btn blue">이전
                	<span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </a>
                </c:if>
                <c:if test="${not empty prev}">
                <a class="neon-btn blue" href="${prev.id}">이전
                	<span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </a>
                </c:if>
                <c:if test="${empty next }">
                <a class="neon-btn blue">다음
                	<span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </a>
                </c:if>
                <c:if test="${not empty next }">
                <a class="neon-btn blue" href="${next.id }">다음
                	<span></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </a>
                </c:if>
             </div>

        </div>
      </main>
      
     