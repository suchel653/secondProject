<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main id="main" class="main detail">
                <h1 class="d-none">메인이다</h1>
                
                <section>
                <h1>${c.title }</h1>
                <div class="detail-container">
                <table>
	                <tbody>
	                    <tr>
	                        <th>시작일 :</th>
	                        <td>
	                            <fmt:formatDate value="${c.startDate}" pattern="yyyy-MM-dd"/>	
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>마감일 :</th>
	                        <td>
	                            <fmt:formatDate value="${c.endDate}" pattern="yyyy-MM-dd"/>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>등록일 :</th>
	                        <td>
	                            <fmt:formatDate value="${c.regDate}" pattern="yyyy-MM-dd"/>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>조회수 :</th>
	                        <td>
	                            ${c.hit}
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>첨부파일 :</th>
	                        <td>
	                       	<c:forEach var="f" items="${c.contestFiles}">
	                       		<!--<a download href="">${f.name} </a>  -->
	                       		${f.name }
	                       	</c:forEach>
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>이미지 :</th>
	                        <td>
	                       	<c:forEach var="img" items="${c.contestImages}">
	                       		<img src="/images/contestImg/${c.id}/${img.name}" />
	                       	</c:forEach>
	                        </td>
	                    </tr>
                    </tbody>
                </table>
                </div>
              <div class="content" >${c.content }</div>
                
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
                		<a class="button searchBtn " href="${c.id}/edit">수정</a>
	                </div>
                </section>
                
                
            </main>