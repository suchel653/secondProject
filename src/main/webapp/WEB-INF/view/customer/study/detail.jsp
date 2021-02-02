<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="/js/customer/study/apply.js"></script>

	<main id="main" class="main">
        <h1 class="d-none">메인이다</h1>
        
        <div class="container">
          <section>
        
          
            <div class="title">
              <h1>${s.title}</h1>
            </div>
            
            <div>
              <img src="/images/language/${s.image }" ></img>
              <table border="1">
                <tbody>
                <tr>
                  <th>분야 : </th><td >${s.fieldName }</td>
                </tr>
                <tr>
                  <th>기술 : </th>
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
                  <th>언어 : </th>
                  	<td>
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
                  <td >${s.limitNumber}</td>
                </tr>
                <tr>
                  <th>요구사항 :</th>
                  <td>${s.requirement }</td>
                </tr>
                <tr>
                  <th>진행일 : </th>
                  <td >
                  <fmt:formatDate value="${s.startDate}" pattern="yyyy-MM-dd"/>~
					<fmt:formatDate value="${s.endDate }" pattern="yyyy-MM-dd"/>
                  </td>
                </tr>
                <tr>
                  <th>상태 : </th>
                  <td >${s.statusName }</td>
                </tr>
                <tr>
                  <th>작성자 : </th>
                  <td >${s.leaderName }</td>
                </tr>
                <tr>
                  <th>등록일 :</th>
                  <td >
                    <fmt:formatDate value="${s.regDate }" pattern="yyyy-MM-dd"/>
                  </td>
                </tr>
                </tbody>
                </table>
              </div>
              
              <div class="content-box"></div>
          
            </section>

            <div class="btn prev-next-btn">
	                <a class="button searchBtn" href="list">목록</a>
	                <input type=hidden value="${s.id}"/>
	                 <a class="apply" href="">지원하기</a>
	                
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

        </div>
      </main>