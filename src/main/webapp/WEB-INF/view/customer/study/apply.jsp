<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="/js/customer/study/apply.js">

</script>

	<main id="main" class="main" onsubmit="return submitCheck();">
        <h1 class="d-none">메인이다</h1>
        
        
          <section>
          <h1 class="d-none">지원하기</h1>
          
         <form action="" method="post" >
          <div>
          <h1>comment</h1>
         
          <textarea class="comment" name="comment"></textarea>

        </div>
        <div>
        <input class="id" type="hidden" value="${id}">
      
        <input class="applyBtn" type="submit" value="지원" />
         
         
   
        </div>
        </form> 
        </section>
      </main>