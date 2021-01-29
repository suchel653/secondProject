<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>      
<main id="main" class="main">
	<div class="container">
		<table>
			<tr>
				<th>공모전 명</th>
				<td colspan="3">${c.title}</td>
			</tr>
			<tr>
				<th>시작일</th>
				<td>
					<fmt:formatDate value="${c.startDate}" pattern="yyyy-MM-dd"/>	
				</td>
				<th>마감일</th>
				<td>
					<fmt:formatDate value="${c.endDate}" pattern="yyyy-MM-dd"/>	
				</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${c.writerName}</td>
				<th>조회수</th>
				<td>${c.hit}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td colspan="3">
					<fmt:formatDate value="${c.regDate}" pattern="yyyy-MM-dd"/>	
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="3">
				<c:forEach var="f" items="${c.contestFiles}">
					<a download href="/images/contestFile/${c.id }/${f.name}">${f.name} </a>
				</c:forEach>
				</td>
			</tr>
		
		</table>
	
		<div>
			${c.content }
			<c:forEach var="i" items="${c.contestImages}">
				<img src="/images/contestImg/${c.id}/${i.name}">
			</c:forEach>
		</div>
	
		<div>
			<a href="list">목록</a>
			
			<c:if test="${empty prev }">
				이전글이 없습니다.
			</c:if>
			
			<c:if test="${not empty prev}">
	        	<a href="${prev.id}">이전글 : ${prev.title}</a>
	        </c:if>
	        
	        <c:if test="${empty next }">
	        	다음글이 없습니다.
	        </c:if>
		
			<c:if test="${not empty next}">
				<a href="${next.id}">다음글 : ${next.title }</a>
			</c:if>
		</div>
	</div>
	
</main>