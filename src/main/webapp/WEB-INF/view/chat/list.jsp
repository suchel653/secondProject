<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    


<main id="main" class="main">
	
   		
   		<div style="width:300px;height:300px;background:white">
   		<ul>
   		<c:forEach var="r" items="${list}">
   			<li><a href="${r.id}">${r.name}</a></li>
   		</c:forEach>
   		</ul>
   		</div>
   
</main>