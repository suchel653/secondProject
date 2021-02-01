<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="/js/customer/activity/index.js"></script>
<main id="main" class="main">

	<h1 class="d-none">메인이다</h1>
	<div class="container">

		<section class="act-box" style="display:flex; justify-content:space-around;">
			<div>
				<h1 style="padding: 30px;">지원자 목록</h1>
				<div style="width: 600px; height: 200px; border: 1px solid red; overflow: auto; align-items: center;">
					<c:forEach var="s" items="${sav}">
						<div>
							<span>${s.memberNickname}님이 ${s.studyTitle}에 지원하였습니다.</span> <span style="font-size: 5px; color:#c1c1c1;"><fmt:formatDate value="${s.regDate}" pattern="yyyy-MM-dd a hh:mm:ss"/></span>
						</div>
					</c:forEach>
					
					<c:forEach var="p" items="${pav}">
						<div>
							<span>${p.memberNickname}님이 ${p.projectTitle}에 지원하였습니다. ${p.regDate}</span>
						</div>
					</c:forEach>
				</div>
			</div>
			
			<div>
				<h1 style="padding: 30px;">신청 결과</h1>
				<div style="width: 600px; height: 200px; border: 1px solid red; overflow: auto; align-items: center;">
					<c:forEach var="s" items="${sarv}">
						<div>
							<span>${s.memberNickname}님이 ${s.studyTitle}에 지원하신 결과 ${s.resultStatus==1?"수락":"거절"}되었습니다.</span> <span style="font-size: 5px; color:#c1c1c1;"><fmt:formatDate value="${s.resultDate}" pattern="yyyy-MM-dd a hh:mm:ss"/></span>
						</div>
					</c:forEach>
					
					<c:forEach var="p" items="${parv}">
						<div>
							<span>${p.memberNickname}님이 ${p.projectTitle}에 지원하신 결과 ${p.resultStatus==1?"수락":"거절"}되었습니다. ${p.resultDate}</span>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>
		
		<section class="act-box" style="display:flex; justify-content:space-around;">
			<div>
				<h1 style="padding: 30px;">진행중인 스터디</h1>
				<div style="width: 600px; height: 200px; border: 1px solid red; display: flex; overflow: auto; align-items: center;">
					<c:forEach var="osv" items="${osv}">
						<a class="group-page" href="group/study/${osv.id}/index">
							<div style="flex-basis: 33%; flex-shrink: 0; height: 160px; border: 1px solid black;">
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
						</a>
					</c:forEach>
				</div>
			</div>
	 	    <div>
				<h1 style="padding: 30px;">진행중인 프로젝트</h1>
				<div style="width: 600px; height: 200px; border: 1px solid red; display: flex; overflow: auto; align-items: center;">
					<c:forEach var="opv" items="${opv}">
						<a class="group-page" href="group/project/${opv.id}/index">
							<div style="flex-basis: 33%; flex-shrink: 0; height: 160px; border: 1px solid black;">
								<div style="display: flex;">
									<img src="/images/projectImg/${opv.image}" style="width: 100px; height: 100px;">
									<div style="width: 100px; height: 100px;">
										<span>인원 : ${opv.memberCount}/${opv.limitNumber}</span><br> 
										<span>기간<br>
											<fmt:formatDate value="${opv.startDate}" pattern="yyyy-MM-dd"/><br>~<br><fmt:formatDate value="${opv.endDate}" pattern="yyyy-MM-dd"/>
										</span>
									</div>
								</div>
								<div>
									<span>제목 : ${opv.title}</span>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</div>
		</section>
		
		<section class="act-box" style="display:flex; justify-content:space-around;">
			<div>
				<h1 style="padding: 30px;">대기중인 스터디</h1>
				<div style="width: 600px; height: 200px; border: 1px solid red; display: flex; overflow: auto; align-items: center;">
					<c:forEach var="wsv" items="${wsv}">
						<div style="flex-basis: 33%; flex-shrink: 0; height: 160px; border: 1px solid black;">
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
			</div>
			<div>
				<h1 style="padding: 30px;">대기중인 프로젝트</h1>
				<div style="width: 600px; height: 200px; border: 1px solid red; display: flex; overflow: auto; align-items: center;">
					<c:forEach var="wpv" items="${wpv}">
						<div style="flex-basis: 33%; flex-shrink: 0; height: 160px; border: 1px solid black;">
							<div style="display: flex;">
								<img src="/images/projectImg/${wpv.image}" style="width: 100px; height: 100px;">
								<div style="width: 100px; height: 100px;">
									<span>인원 : ${wpv.memberCount}/${wpv.limitNumber}</span><br> 
									<span>기간<br>
										<fmt:formatDate value="${wpv.startDate}" pattern="yyyy-MM-dd"/><br>~<br><fmt:formatDate value="${wpv.endDate}" pattern="yyyy-MM-dd"/>
									</span>
								</div>
							</div>
							<div>
								<span>제목 : ${wpv.title}</span>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>

		<section class="act-box" style="padding-bottom: 50px; display:flex; justify-content:space-around;">
			<div>
				<h1 style="padding: 30px;">완료 스터디</h1>
				<div style="width: 600px; height: 200px; border: 1px solid red; display: flex; overflow: auto; align-items: center;">
					<c:forEach var="esv" items="${esv}">
						<div style="flex-basis: 33%; flex-shrink: 0; height: 160px; border: 1px solid black;">
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
			</div>
			<div>
				<h1 style="padding: 30px;">완료 프로젝트</h1>
				<div style="width: 600px; height: 200px; border: 1px solid red; display: flex; overflow: auto; align-items: center;">
					<c:forEach var="epv" items="${epv}">
						<div style="flex-basis: 33%; flex-shrink: 0; height: 160px; border: 1px solid black;">
							<div style="display: flex;">
								<img src="/images/projectImg/${epv.image}" style="width: 100px; height: 100px;">
								<div style="width: 100px; height: 100px;">
									<span>인원 : ${epv.memberCount}/${epv.limitNumber}</span><br> 
									<span>기간<br>
										<fmt:formatDate value="${epv.startDate}" pattern="yyyy-MM-dd"/><br>~<br><fmt:formatDate value="${epv.endDate}" pattern="yyyy-MM-dd"/>
									</span>
								</div>
							</div>
							<div>
								<span>제목 : ${epv.title}</span>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</section>

	</div>
</main>