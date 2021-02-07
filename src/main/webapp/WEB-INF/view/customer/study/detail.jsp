<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="/js/customer/study/apply.js"></script>

	<main id="main" class="main detail dmain">
        <h1 class="d-none">메인이다</h1>
        
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
                  <th>field </th><td >${s.fieldName }</td>
                </tr>
                <tr>
                  <th>skill  </th>
                  <td >
								<c:forEach var="s" items="${s.skill }" varStatus="st">
								${s.skillName } 
								<c:if test="${!st.last }">
									/
								</c:if>
								</c:forEach>
							</td>
                </tr>
                <tr>
                  <th>language  </th>
                  	<td>
							<c:forEach var="l" items="${s.language}" varStatus="st">
					<img src="/images/language/${l.image}" style="width:40px; height:40px;"/>
					</c:forEach>
							</td>
                </tr>
                      <tr>
                  <th>file </th>
                  <td>
					<c:forEach var="f" items="${s.files}" varStatus="st">
					<a download href="/images/studyFile/${s.id}/${f.name}">${f.name}</a> 
					<c:if test="${!st.last }">
						/
					</c:if>
					</c:forEach>
				 </td>
                </tr>
                <tr>
                  <th>recruitment  </th>
                  <td >${s.limitNumber}</td>
                </tr>
                <tr>
                  <th>requirement </th>
                  <td>${s.requirement }</td>
                </tr>
                <tr>
                  <th>Progress Date  </th>
                  <td >
                  <fmt:formatDate value="${s.startDate}" pattern="yyyy-MM-dd"/>~
					<fmt:formatDate value="${s.endDate }" pattern="yyyy-MM-dd"/>
                  </td>
                </tr>
               
                <tr>
                  <th>leader  </th>
                  <td >${s.leaderName }</td>
                </tr>
                <tr>
                  <th>registration date </th>
                  <td >
                    <fmt:formatDate value="${s.regDate }" pattern="yyyy-MM-dd"/>
                  </td>
                </tr>
                </tbody>
                </table>
              </div>
              
              <div class="content">${s.content}</div>
          
            </section>
            
           <%--  <div class="p-s-regBtn-box">
            <div class="p-s-regBtn">
	                <input class="checkId" type=hidden value="${s.id}"/>
	                 <a class="apply neon-btn pink" href="">지원하기
	                   <span></span>
                        <span></span>
                        <span></span>
                        <span></span>
	                 </a>
	                 </div>
	                 </div> --%>

            <div class="btn prev-next-btn">
           
	                <a class="neon-btn green" href="list">목록
	                  	<span></span>
                        <span></span>
                        <span></span>
                        <span></span>
	                </a>
	                
	                 <input class="checkId" type=hidden value="${s.id}"/>
	                 <a class="apply neon-btn pink" href="">지원하기
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
	                <a class="neon-btn blue" >다음
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