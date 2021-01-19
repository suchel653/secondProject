<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/admin/default.css" type="text/css" rel="stylesheet" />

</head>
<body>
	 <!-- header 부분 -->
	<tiles:insertAttribute name="header" />

	<!-- --------------------------- <body> --------------------------------------- -->
	<div id="body" class="body">
		<div class="container">

			<!-- --------------------------- aside --------------------------------------- -->
			<!-- aside 부분 -->
			<tiles:insertAttribute name="aside" />

			
			<!-- --------------------------- main --------------------------------------- -->


			<tiles:insertAttribute name="main" />
		</div>
	</div>
	
	 <!-- ------------------- <footer> --------------------------------------- -->
	<tiles:insertAttribute name="footer" />
</body>
</html>