<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
			 <script src="/js/customer/join.js"></script>
			<main id="main" class="main">
				<h1 class="d-none">메인이다</h1>
				<section>
					<form id="reg" method="post" onsubmit="return submitCheck();">
						<label>아이디</label>
						<div id="email">
							<input type="text" name="email">
							<input type="button" value="인중">
						</div>
						<label>인증번호</label>
						<div id="confirm">
							<input type="text">
							<input type="button" value="확인">
						</div>
						<label>비밀번호</label>
						<div id="password">
							<input type="password" name="password">
						</div>
						<label>닉네임</label>
						<div id="nickname">
							<input type="text" name="nickname">
							<input type="button" value="중복확인">
						</div>
							<input type="submit" value="가입">
						</div>
					</form>
				</section>
			</main>