<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<link rel="stylesheet" href="/css/customer/project-study-list.css"></link>
<script src="https://kit.fontawesome.com/b280fc7aa7.js"
	crossorigin="anonymous"></script>
<c:set var="page" value="${param.p}" />
<c:if test="${empty param.p}">
	<c:set var="page" value="1" />
</c:if>
<main id="main" class="main">
	<div class="container contest">
		<form class="contest-search search-form"> 
			<div class="search-query">
				<select name="f">
					<option value="title">공모전 명</option>
					<option value="startDate">시작일</option>
					<option value="endDate">마감일</option>
				</select>
				<input class="query" type="text" name="q" >
				<input class="button searchBtn search-btn" type="submit" value="검색">
			</div>
		</form>
		
		<table class="contest-list">
			<thead>
				<tr>
					<th>번호</th>
					<th>공모전 명</th>
					<th>시작일</th>
					<th>마감일</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="c" items="${list}">
				<tr>
					<td>${c.id}</td>
					<td><a href="${c.id}">${c.title}</a></td>
					<td>
						<fmt:formatDate value="${c.startDate}" pattern="yyyy-MM-dd"/>	
					</td>
					<td>
						<fmt:formatDate value="${c.endDate}" pattern="yyyy-MM-dd"/>	
					</td>
					<td>${c.writerName}</td>
					<td>
						<fmt:formatDate value="${c.regDate}" pattern="yyyy-MM-dd"/>	
					</td>
					<td>${c.hit}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		
		<c:set var="startNum" value="${page-(page-1)%5}" />

		<div class="pager">
			<div>
				<a
					href="?p=${1}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}"><i
					class="fas fa-angle-double-left"></i></a>
			</div>
			<div>
				<c:if test="${startNum>1}">
					<a
						href="?p=${startNum-5}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}"><i
						class="fas fa-angle-left"></i></a>
				</c:if>

				<c:if test="${startNum<=1}">
					<a
						href="?p=${1}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}"><i
						class="fas fa-angle-left"></i></a>
				</c:if>

			</div>

			<ul>
				<c:forEach var="i" begin="0" end="4">

					<c:if test="${i+startNum <= pageCount}">
						<li><a class="${i+startNum==page?"
							current":""}" href="?p=${i+startNum}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}">${i+startNum}</a></li>
					</c:if>
				</c:forEach>
			</ul>
			<div>
				<c:if test="${startNum+5<=pageCount}">
					<a
						href="?p=${startNum+5}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}"><i
						class="fas fa-angle-right"></i></a>
				</c:if>

				<c:if test="${startNum+5>pageCount}">
					<a
						href="?p=${pageCount}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}"><i
						class="fas fa-angle-right"></i></a>
				</c:if>

			</div>
			<div>
				<a
					href="?p=${pageCount}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}"><i
					class="fas fa-angle-double-right"></i></a>
			</div>
		</div>
		
	</div>
</main>