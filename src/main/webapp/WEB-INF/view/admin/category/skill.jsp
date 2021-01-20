<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<main id="main" class="main">
	<h1 class="d-none">Category - Languages</h1>
	
	<section>
		<h1 class="d-none">스킬 리스트</h1>

		<input class="button addBtn" type="button" value="+ Add">

		<form action="language" method="post">

			<table class="list-table">
				<thead>
					<tr>
						<td>번호</td>
						<td>스킬</td>
						<td>삭제</td>
					</tr>
				</thead>

				<tbody>
					<c:forEach var="sl" items="${list}">
					<tr>
						<td>${sl.id}</td>
						<td>${sl.name}</td>
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