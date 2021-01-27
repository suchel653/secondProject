<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<main id="main" class="main">
	<nav>
		<ul>
			<li><a href="../${m.id }" >기본정보</a></li>
			<li><a href="../${m.id }/exper" >경력사항</a></li>
			<li><a href="../${m.id }/project" >참여 프로젝트</a></li>
		</ul>
	</nav>
	<form method="post" class="search-form">
        <div class="search-query">
            <select name="f">
                <option value="title">공모전 이름</option>
                <option value="writerName">작성자</option>
                <option value="startDate">시작일</option>
                <option value="endDate">마감일</option>
            </select>
            <input type="text" name="q">
         <input class="button searchBtn search-btn" type="submit" value="검색">
        </div>
    </form>
    
    <table class="list-table table">
       <thead>
           <tr>
               <td>번호</td>
               <td>공모전 이름</td>
               <td>시작일</td>
               <td>마감일</td>
               <td>작성자</td>
               <td>등록일</td>
               <td>조회수</td>
           </tr>
       </thead>

       <tbody class="tbody">
           <tr>
               <td>sdf</td> 
               <td>
               	<a href="">sdf</a>
               </td>
               <td>
               	<fmt:formatDate value="" pattern="yyyy-MM-dd"/>	sdf
               </td>
               <td>
               	<fmt:formatDate value="" pattern="yyyy-MM-dd"/>	sdf
               </td>
               <td>sdf</td>
               <td>
               	<fmt:formatDate value="" pattern="yyyy-MM-dd"/>	sdfg
               </td>
               <td>sdfg</td>
           </tr>
       </tbody>
   </table>
</main>