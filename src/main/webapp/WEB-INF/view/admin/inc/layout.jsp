<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/admin/default.css" type="text/css" rel="stylesheet" />
<script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
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

</body>
</html>