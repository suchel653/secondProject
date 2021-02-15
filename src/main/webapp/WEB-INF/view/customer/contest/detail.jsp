<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="/css/customer/contest-detail.css"></link> 
<main id="main" class="main detail dmain">
	<div class="container">
		<section class="contest-detail">
		
			<div class="title">
				<h1 class="flux">${c.title}</h1>
			</div>

			<div class="detail-container">
				<table class="contest-list">
					<tbody>
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
					</tbody>
				</table>
			</div>

			<div class="content">
				<c:forEach var="i" items="${c.contestImages}">
				<img src="/images/contestImg/${c.id}/${i.name}">
				</c:forEach>
				<span>
					${c.content}
				</span>
			</div>

		</section>

		<div class="btn prev-next-btn">

			<a class="neon-btn green" href="list">목록 <span></span> <span></span>
				<span></span> <span></span>
			</a> 


			<c:if test="${empty prev }">
				<a class="neon-btn blue">이전 <span></span> <span></span> <span></span>
					<span></span>
				</a>
			</c:if>
			<c:if test="${not empty prev}">
				<a class="neon-btn blue" href="${prev.id}">이전 <span></span> <span></span>
					<span></span> <span></span>
				</a>
			</c:if>
			<c:if test="${empty next }">
				<a class="neon-btn blue">다음 <span></span> <span></span> <span></span>
					<span></span>
				</a>
			</c:if>
			<c:if test="${not empty next }">
				<a class="neon-btn blue" href="${next.id }">다음 <span></span> <span></span>
					<span></span> <span></span>
				</a>
			</c:if>
		</div>

	</div>
	
</main>