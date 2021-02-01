<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<main id="main" class="main">
 <div class="container">
    <h1>프로젝트 등록</h1>
 <section>

<form action="reg" method="post" enctype="multipart/form-data">

    <table border="1">
      <tbody>
        <tr>
	         <select name="field">
	         <c:forEach var="f" items="${f }">
	           <option value="${f.id }">${f.name }</option>
	         </c:forEach>
	        </select> 
    	</tr>
    <tr>
        <th>스킬선택</th>
        <td>
        	<c:forEach var="s" items="${s }">
            <input name="skill" type="checkbox" value="${s.id }">${s.name }
            </c:forEach>
        </td>

    </tr>
    <tr>
        <th>언어선택</th>
        <td>
            <c:forEach var="l" items="${l }">
            <input name="language" type="checkbox" value="${l.id }">${l.name }
            </c:forEach>
        </td>

    </tr>
    <tr>
       <th>제목</th>
       <td><input type="text" name="title"></td>

    </tr>
    
    <tr>
         <th>인원수</th>
         <td>
             <input type="text" name="limitNumber">명
         </td>
     </tr>
     
     <tr>
         <th>시작일</th>
         <td>
             <input type="text" name="startDate" placeholder="yyyy-dd-mm">
         </td>
     </tr>

	<tr>
         <th>마감일</th>
         <td>
             <input type="text" name="endDate" placeholder="yyyy-dd-mm">
         </td>
     </tr>
     
     
     <tr>
        <th>첨부파일</th>
        <td><input multiple="multiple" type="file" name="files"></td>
        
 
     </tr>

     <tr>
        <th>이미지파일</th>
        <td><input type="file" name="image"></td>
        
     </tr>
     <tr>
        <td colspan="4">
            <textarea name="content"></textarea>
        </td>
    </tr>
 
   <tr>
        <td colspan="4">
            <textarea name="requirement" placeholder="요구조건"></textarea>
        </td>
    </tr>
    
</tbody>
    </table>
	    <div class="buttons">
			<input type="submit" value="등록"/>
			<a href="list">뒤로가기</a>
		</div>
    </form>
    </section>
</div>
</main>