<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <script src="/js/customer/project/apply.js"></script>
 
	<main id="main" class="main">
        <h1 class="d-none">메인이다</h1>
        
        <div class="container">
          <section>
          <h1 class="d-none">메인이다</h1>
          
            <div class="title">
              <h1>${pv.title}</h1>
            </div>
            
            <div>
              <img src="/images/projectImg/${pv.image }" style="width:300px; height:300px;"></img>
              <table border="1">
                <tbody>
                <tr>
					<th>분야 : </th><td >${pv.fieldName }</td>
				</tr>
                <tr>
	                <th>기술 : </th>
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
                  <th>언어 : </th>
                  <td>
					<c:forEach var="l" items="${pv.languages }" varStatus="st">
					<img src="/images/language/${l.image}" style="width:40px; height:40px;"/>
					</c:forEach>
				 </td>
                </tr>
                <tr>
                  <th>첨부파일 : </th>
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
                  <th>인원 : </th>
                  <td>${pv.limitNumber }</td>
                </tr>
                <tr>
                  <th>요구사항 :</th>
                  <td>${pv.requirement } </td>
                </tr>
                <tr>
                  <th>진행일 : </th>
	                <td >
						<fmt:formatDate value="${pv.startDate}" pattern="yyyy-MM-dd"/>~
						<fmt:formatDate value="${pv.endDate }" pattern="yyyy-MM-dd"/>
					</td>
                </tr>
                <tr>
	                  <th>상태 : </th><td >${pv.statusName}</td>
                </tr>
                <tr>
                  <th>작성자 : </th><td >${pv.leaderName }</td>
                </tr>
                <tr>
                  <th>등록일 :</th>
                  <td >
                    <fmt:formatDate value="${pv.regDate }" pattern="yyyy-MM-dd"/>
                  </td>
                </tr>
                </tbody>
                </table>
              </div>
              
              <div class="content-box">${pv.content }</div>
          
            </section>

			<input class="projectId" type="hidden" value="${pv.id }"/>
			
			<c:if test="${pv.memberCount < pv.limitNumber }">
			<a class="apply-btn" href="">지원하기</a>
			</c:if>
            
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

        </div>
      </main>
      
     