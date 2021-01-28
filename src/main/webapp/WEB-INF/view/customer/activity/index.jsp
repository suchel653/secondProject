<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<main id="main" class="main">

	<h1 class="d-none">메인이다</h1>
	<div class="container">

		<section class="act-box">
			<h1 style="padding: 30px;">신청 목록</h1>
			<div style="width: 1000px; height: 200px; border: 1px solid red; display: flex; overflow: auto; align-items: center;">
			</div>
		</section>
		
		<section class="act-box">
			<h1 style="padding: 30px;">진행중인 스터디</h1>
			<div style="width: 1000px; height: 200px; border: 1px solid red; display: flex; overflow: auto; align-items: center;">
				<c:forEach var="osv" items="${osv}">
					<div style="flex-basis: 25%; flex-shrink: 0; height: 160px; border: 1px solid black;">
						<div style="display: flex;">
							<img src="/images/language/${osv.image}" style="width: 100px; height: 100px;">
							<div style="width: 100px; height: 100px;">
								<span>인원 : ${osv.memberCount}/${osv.limitNumber}</span><br> 
								<span>기간<br>
									<fmt:formatDate value="${osv.startDate}" pattern="yyyy-MM-dd"/><br>~<br><fmt:formatDate value="${osv.endDate}" pattern="yyyy-MM-dd"/>
								</span>
							</div>
						</div>
						<div>
							<span>제목 : ${osv.title}</span>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>
		
		<section class="act-box">
			<h1 style="padding: 30px;">대기중인 스터디</h1>
			<div style="width: 1000px; height: 200px; border: 1px solid red; display: flex; overflow: auto; align-items: center;">
				<c:forEach var="wsv" items="${wsv}">
					<div style="flex-basis: 25%; flex-shrink: 0; height: 160px; border: 1px solid black;">
						<div style="display: flex;">
							<img src="/images/language/${wsv.image}" style="width: 100px; height: 100px;">
							<div style="width: 100px; height: 100px;">
								<span>인원 : ${wsv.memberCount}/${wsv.limitNumber}</span><br> 
								<span>기간<br>
									<fmt:formatDate value="${wsv.startDate}" pattern="yyyy-MM-dd"/><br>~<br><fmt:formatDate value="${wsv.endDate}" pattern="yyyy-MM-dd"/>
								</span>
							</div>
						</div>
						<div>
							<span>제목 : ${wsv.title}</span>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>

		<section class="act-box" style="padding-bottom: 50px;">
			<h1 style="padding: 30px;">완료 스터디</h1>
			<div style="width: 1000px; height: 200px; border: 1px solid red; display: flex; overflow: auto; align-items: center;">
				<c:forEach var="esv" items="${esv}">
					<div style="flex-basis: 25%; flex-shrink: 0; height: 160px; border: 1px solid black;">
						<div style="display: flex;">
							<img src="/images/language/${esv.image}" style="width: 100px; height: 100px;">
							<div style="width: 100px; height: 100px;">
								<span>인원 : ${esv.memberCount}/${esv.limitNumber}</span><br> 
								<span>기간<br>
									<fmt:formatDate value="${esv.startDate}" pattern="yyyy-MM-dd"/><br>~<br><fmt:formatDate value="${esv.endDate}" pattern="yyyy-MM-dd"/>
								</span>
							</div>
						</div>
						<div>
							<span>제목 : ${esv.title}</span>
						</div>
					</div>
				</c:forEach>
			</div>
		</section>

	</div>
</main>