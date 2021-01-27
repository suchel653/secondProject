<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main id="main" class="main detail">
                <h1 class="d-none">메인이다</h1>
                <section>
				<h1>${m.nickname}</h1>
				<nav>
					<ul>
						<li><a href="${m.id }" >기본정보</a></li>
						<li><a href="${m.id }/exper" >경력사항</a></li>
						<li><a href="${m.id }/project" >참여 프로젝트</a></li>
					</ul>
				</nav>
				<div class="detail-container">
					<img src="">${p.image}</img>
					<table border="1">
						<tbody>
						<tr>
							<th>제목 :</th>
							<td >${p.title }</td>
						</tr>
						<tr>
							<th>사용가능 기술 :</th>
							<td>
								<c:forEach var="s" items="${p.skillList }">
										${s}
								</c:forEach>
							</td>
						</tr>
						<tr>
							<th>사용가능 언어 :</th>
							<td>
								<c:forEach var="l" items="${p.languageList }">
										${s}
								</c:forEach>
							</td>
						</tr>
						<tr>
							<th>주소 :</th>
							<td >${p.address }</td>
						</tr>
						<tr>
							<th>깃 주소 :</th>
							<td >${p.repositoryLink }</td>
						</tr>
						<tr>
							<th>등록일  :</th>
							<td >
								<fmt:formatDate value="${p.regDate}" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
						<tr>
							<th>마지막 수정일 :</th>
							<td >
								<fmt:formatDate value="${p.editDate}" pattern="yyyy-MM-dd"/>
							</td>
						</tr>
						</tbody>
						</table>
					</div>
					
					<div class="content">${p.introduction}</div>
			
			</section>
            </main>