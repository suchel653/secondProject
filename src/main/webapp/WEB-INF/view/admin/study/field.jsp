<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<main class="main">
	<h1 class="d-none">Main Content</h1>

	<!-- <section class="main-section"> -->
	<section>
		<h1 class="d-none">필드 리스트</h1>

		<input class="button addBtn" type="button" value="+ Add">

		<form action="field" method="post">

			<table>
				<thead>
					<tr>
						<td>번호</td>
						<td>필드명</td>
		
						<td>삭제</td>
					</tr>
				</thead>

				<tbody>
					
						<tr>
							<td>1</td>
							<td>웹 개발</td>
							<td><input name="del" type="checkbox"></td>
						</tr>
						
						<tr>
							<td>2</td>
							<td>인공지능</td>
							<td><input name="del" type="checkbox"></td>
						</tr>
		
				</tbody>
			</table>
	</section>

	<section>
		<h1 class="d-none">이벤트 버튼</h1>

		<input class="button" name="button" type="submit" value="저장">
		<input class="button" name="button" type="submit" value="삭제">
	</section>
	</form>
	<!-- </section> -->

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