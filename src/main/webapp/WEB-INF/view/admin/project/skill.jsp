<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<main id="main" class="main">
	<h1 class="d-none">Project - Skills</h1>
	
	<section>
		<h1 class="d-none">스킬 리스트</h1>

		<input class="button addBtn" type="button" value="+ Add">

		<form action="language" method="post">

			<table class="list-table">
				<thead>
					<tr>
						<td>번호</td>
						<td>언어명</td>
						<td>삭제</td>
					</tr>
				</thead>

				<tbody>

					<tr>
						<td>1</td>
						<td>Spring</td>
						<td><input name="del" type="checkbox"></td>
					</tr>

					<tr>
						<td>2</td>
						<td>Spring boot</td>
						<td><input name="del" type="checkbox"></td>
					</tr>
					
					<tr>
						<td>3</td>
						<td>Node.js</td>
						<td><input name="del" type="checkbox"></td>
					</tr>
					
					<tr>
						<td>4</td>
						<td>React</td>
						<td><input name="del" type="checkbox"></td>
					</tr>
					
					<tr>
						<td>5</td>
						<td>jsp/servlet</td>
						<td><input name="del" type="checkbox"></td>
					</tr>

				</tbody>
			</table>
		</form>
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