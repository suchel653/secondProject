<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<main id="main" class="main reg">
 <div class="container">
    <h1 class="title">프로젝트 등록</h1>
 <section>

<form action="reg" method="post" enctype="multipart/form-data">

    <table class="reg-table">
      <tbody>
        <tr>
	        <td colspan="6" >
	         <select class="field" name="field">
	           <option selected disabled hidden> 필드 선택</option>
	         <c:forEach var="f" items="${f }">
	         
	           <option value="${f.id }" >${f.name }</option>
	         </c:forEach>
	        </select> 
	        </td>
    	</tr>
    <tr>
        <th>스킬</th>
        <td colspan="6">
        <div class="flex">
        	<c:forEach var="s" items="${s }">
        	<span>
            <input name="skill" type="checkbox" value="${s.id }">${s.name }
            </span>
            </c:forEach>
            </div>
        </td>

    </tr>
    <tr>
       <th>언어</th>
        <td colspan="6">
        <div class="flex">
        
            <c:forEach var="l" items="${l }">
            <span>
            <input name="language" type="checkbox" value="${l.id }">${l.name }
            </span>
            </c:forEach>
            </div>
        </td>

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
             <input type="date" name="startDate" placeholder="yyyy-dd-mm">
         </td>

         <th>마감일</th>
         <td>
             <input type="date" name="endDate" placeholder="yyyy-dd-mm">
         </td>
     </tr>
     <tr>
        <th>첨부파일</th>
        <td colspan="5"><input multiple="multiple" type="file" name="files"></td>
        
 
     </tr>

     <tr>
        <th>이미지파일</th>
        <td colspan="5"><input type="file" name="image"></td>
        
     </tr>
     
    <tr>
       <th>제목</th>
       <td colspan="5"><input class="reg-title" type="text" name="title" placeholder="제목을 입력하세요"></td>

    </tr>
    
     
     
     
     <tr>
        <td colspan="6">
            <textarea class="reg-content" name="content"></textarea>
        </td>
    </tr>
 
   <tr>
       <td colspan="6">
            <textarea class="reg-req" name="requirement" placeholder="요구조건"></textarea>
        </td>
    </tr>
    
</tbody>
    </table>
    
    
	    <div class="reg-btn" >
	    
	    
			<button class="neon-btn blue" type="submit" value="등록">등록하기
    			<span></span>
                <span></span>
                <span></span>
                <span></span>
            </button>
            
			<a href="list" class="neon-btn blue">뒤로가기
				<span></span>
                <span></span>
                <span></span>
                <span></span>
			</a>
			
			
		</div>
    </form>
    </section>
</div>
</main>