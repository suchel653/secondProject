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
               <td>회사명</td>
               <td>기간</td>
               <td>업무사항</td>
           </tr>
       </thead>

       <tbody class="tbody">
           <tr>
               <td>
               	<a href="">sdf</a>
               </td>
               <td>
               	<fmt:formatDate value="" pattern="yyyy-MM-dd"/>	sdf~
               	<fmt:formatDate value="" pattern="yyyy-MM-dd"/>	sdf
               </td>
               <td>
               		컴퓨터가 되도록 java하기
               </td>
           </tr>
       </tbody>
   </table>
</main>