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
	         <select style="width: 900px; height: 30px;">
	            <option value=""  selected disabled hidden>필드선택</option>
	            <option value="웹">웹</option>
	            <option value="게임">게임</option>
	        </select> 
    	</tr>
    <tr>
        <th>스킬선택</th>
        <td>
            <input type="checkbox">JSP
        </td>

    </tr>
    <tr>
        <th>언어선택</th>
        <td>
            <input type="checkbox">자바
        </td>

    </tr>
    <tr>
       <th>제목</th>
       <td><input type="text" naem="title"></td>
   

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