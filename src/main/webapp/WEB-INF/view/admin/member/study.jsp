<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main id="main" class="main">
<h1>${m.nickname}님의 프로필입니다.</h1>
	<nav>
		<ul>
			<li><a href="../${m.id }" >기본정보</a></li>
			<li><a href="../${m.id }/exper" >경력사항</a></li>
			<li><a href="../${m.id }/project" >참여 프로젝트</a></li>
			<li><a href="../${m.id }/study" >참여 스터디</a></li>
		</ul>
	</nav>
    <table class="list-table table">
        <thead>
            <tr>
                <td>스터디 이름</td>
                <td>주요내용</td>
                <td>시작일</td>
                <td>마감일</td>
                <td>진행상태</td>
            </tr>
        </thead>

        <tbody class="tbody">
        	<c:forEach var="s" items="${p.studyList }">
            <tr>
                <td>${s.title }</td>
                <td>${s.content }</td>
                <td>
                	<fmt:formatDate value="${s.startDate }" pattern="yyyy-MM-dd"/>
                </td>
                <td>
                	<fmt:formatDate value="${s.endDate }" pattern="yyyy-MM-dd"/>
                </td>
                <td>${s.status }</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</main>