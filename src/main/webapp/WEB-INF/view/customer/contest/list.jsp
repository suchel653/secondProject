<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<main id="main" class="main">
	<div class="container">
		<table>
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
		
		<form> 
			<div>
				<select name="f">
					<option value="title">공모전 명</option>
					<option value="startDate">시작일</option>
					<option value="endDate">마감일</option>
				</select>
				<input type="text" name="q" >
				<input type="submit" value="검색">
			</div>
		</form>
	</div>
</main>