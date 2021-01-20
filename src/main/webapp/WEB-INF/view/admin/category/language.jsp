<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="/js/admin/category/language.js"></script>
<main id="main" class="main">
	<h1 class="d-none">Category - Languages</h1>
	
	<section>
		<h1 class="d-none">언어 리스트</h1>

		<input class="button addBtn" type="button" value="+ Add">

		<form action="language" method="post">

			<table class="list-table">
				<thead>
					<tr>
						<td>번호</td>
						<td>언어명</td>
						<td>이미지</td>
						<td>삭제</td>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="l" items="${list}">
					<tr>
						<td>${l.id}</td>
						<td>
							<input hidden type="text" name="id" value="${l.id}">
							<input type="text" name="name" value="${l.name}">
						</td>
						<td>${l.image}</td>
						<td><input name="del" type="checkbox"></td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</form>
	</section>

	<section>
		<h1 class="d-none">이벤트 버튼</h1>
		<input class="button" name="button" type="submit" value="저장">
		<input class="button" name="button" type="submit" value="삭제">
	</section>

	<div class="pager">
		<div>
			<a href="#"><i class="fas fa-angle-double-left"></i></a>
		</div>
		<div>
			<a href="#"><i class="fas fa-angle-left"></i></a>
		</div>
		<ul>
			<li><a href="#">1</a></li>
		</ul>
		<div>
			<a href="#"><i class="fas fa-angle-right"></i></a>
		</div>
		<div>
			<a href="#"><i class="fas fa-angle-double-right"></i></a>
		</div>
	</div>

</main>