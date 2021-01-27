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
		</ul>
	</nav>
    <table class="list-table table">
        <thead>
            <tr>
                <td>프로젝트 이름</td>
                <td>주요내용</td>
                <td>시작일</td>
                <td>마감일</td>
                <td>진행상태</td>
            </tr>
        </thead>

        <tbody class="tbody">
            <tr>
                <td>끼리끼리</td>
                <td>웹페이지만들기</td>
                <td>
                	<fmt:formatDate value="" pattern="yyyy-MM-dd"/>	2020-01-02
                </td>
                <td>
                	<fmt:formatDate value="" pattern="yyyy-MM-dd"/>	2020-02-16
                </td>
                <td>진행중</td>
            </tr>
        </tbody>
    </table>
</main>