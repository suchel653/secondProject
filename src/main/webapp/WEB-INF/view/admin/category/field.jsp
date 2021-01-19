<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<main id="main" class="main">
	<h1 class="d-none">Project - Field</h1>
	
	<section>
		<h1 class="d-none">필드 리스트</h1>

		<form action="field" method="post">
			<input class="button addBtn" type="button" value="+ Add">
	
	
				<table>
					<thead>
						<tr>
							<td>번호</td>
							<td>분야명</td>
							<td>삭제</td>
						</tr>
					</thead>
	
					<tbody>
	
						<tr>
							<td>1</td>
							<td>웹</td>
							<td><input name="del" type="checkbox"></td>
						</tr>
	
						<tr>
							<td>2</td>
							<td>모바일 앱</td>
							<td><input name="del" type="checkbox"></td>
						</tr>
						
						<tr>
							<td>3</td>
							<td>임베디드</td>
							<td><input name="del" type="checkbox"></td>
						</tr>
						
						<tr>
							<td>4</td>
							<td>게임</td>
							<td><input name="del" type="checkbox"></td>
						</tr>
						
						<tr>
							<td>5</td>
							<td>보안</td>
							<td><input name="del" type="checkbox"></td>
						</tr>
	
					</tbody>
				</table>
			<section>
				<h1 class="d-none">이벤트 버튼</h1>
				<input class="button" name="button" type="submit" value="저장">
				<input class="button" name="button" type="submit" value="삭제">
			</section>
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