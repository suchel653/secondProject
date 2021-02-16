<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="/js/customer/activity/index.js"></script>
<link href="/css/customer/activity/index.css" type="text/css"
	rel="stylesheet" />

<main id="main" class="main">

	<h1 class="d-none">메인이다</h1>
	
	<div class="container">
	
	
		<div class="container-box">
		
		
			<section class="apply-list">
				<div>
					<h1>스터디 지원자 목록</h1>
					<div class="container-box2">
						<c:forEach var="s" items="${sav}">
							<div class="text-items">
								<span><a onclick="window.open('/customer/activity/group/study/${s.studyId}/index','_blank','width=1500,height=900')"><span class="user-name">${s.memberNickname}</span>님이 ${s.studyTitle}에 지원하였습니다.</a></span>
								<span class="date-fmt"><fmt:formatDate value="${s.regDate}" pattern="yyyy-MM-dd" /></span>
							</div>
						</c:forEach>
					</div>
				</div>
				 
			</section>
			
			<section class="apply-list">
				<div>
				<h1>프로젝트 지원자 목록</h1>
					<div class="container-box2">
					
						<c:forEach var="p" items="${pav}">
							<div class="text-items">
								<span><a onclick="window.open('/customer/activity/group/project/${p.projectId}/index','_blank','width=1500,height=900')"><span class="user-name">${p.memberNickname}</span>님이 ${p.projectTitle}에 지원하였습니다.</a></span>
								<span class="date-fmt"><fmt:formatDate value="${p.regDate}" pattern="yyyy-MM-dd" /></span>
							</div>
						</c:forEach>
						
					</div>
				</div>
				
			</section>

		</div>
		
		<div class="container-box">
		
			<section class="apply-result-list">
				<div>
					<h1>스터디 신청 결과</h1>
					<div class="container-box2">
						<c:forEach var="s" items="${sarv}">
							<div class="text-items result-items">
								<span><span class="user-name">${s.memberNickname}</span>님이 ${s.studyTitle}에 지원하신 결과
									${s.resultStatus==1?"수락":"거절"}되었습니다.</span> <span class="date-fmt result-date"><fmt:formatDate
										value="${s.resultDate}" pattern="yyyy-MM-dd" /></span>
							</div>
						</c:forEach>
	
					</div>
				</div>
				
				</section>
				
				<section class="apply-result-list">
					<div>
						<h1>프로젝트 신청 결과</h1>
						<div class="container-box2">
				
		
							<c:forEach var="p" items="${parv}">
								<div class="text-items result-items">
									<span><span class="user-name">${p.memberNickname}</span>님이 ${p.projectTitle}에 지원하신 결과
										${p.resultStatus==1?"수락":"거절"}되었습니다.</span><span
										class="date-fmt result-date"><fmt:formatDate value="${p.resultDate}"
											pattern="yyyy-MM-dd" /></span>
								</div>
							</c:forEach>
						</div>
					</div>
					
				</section>
		</div>
			
		<div class="container-box">
			<section class="ongoing-study">
			
				<h1>진행중인 스터디</h1>
				
				<div class="container-box2 sp-box">
					<c:forEach var="osv" items="${osv}">
						<a class="group-page" href="group/study/${osv.id}/index">
							
							<div class="sp-box2">
							<div class="sp-content-box">
								<c:if test="${osv.image != 'img1.jpg'}">
									<img src="/images/studyImg/${osv.id}/${osv.image}" class="img-size"></img>
								</c:if>
								<c:if test="${osv.image == 'img1.jpg'}">
									<img src="/images/studyImg/${osv.image}" class="img-size"></img>
								</c:if>
								<div class="img-size sp-box3">
									<span class="sp-title"> ${osv.title}</span>
									<span>인원 : ${osv.memberCount}/${osv.limitNumber}</span>
									<span>기간 <br /> <fmt:formatDate value="${osv.startDate}"
											pattern="yyyy-MM-dd" /><br />~<br />
									<fmt:formatDate value="${osv.endDate}" pattern="yyyy-MM-dd" />
									</span>
								</div>
							</div>
							
							</div>
							
						</a>
					</c:forEach>
				</div>
				
			</section>

			<section class="ongoing-project">
				<h1>진행중인 프로젝트</h1>
				
				<div class="container-box2 sp-box">
				
					<c:forEach var="opv" items="${opv}">
						<a class="group-page" href="group/project/${opv.id}/index">
							<div class="sp-box2">
								<div class="sp-content-box">
								
									<img src="/images/projectImg/${opv.image}" class="img-size">
									<div class="img-size sp-box3">
										<span class="sp-title"> ${opv.title}</span>
										<span>인원 : ${opv.memberCount}/${opv.limitNumber}</span>
										<span>기간 <br /> <fmt:formatDate value="${opv.startDate}"
												pattern="yyyy-MM-dd" /><br />~<br />
										<fmt:formatDate value="${opv.endDate}" pattern="yyyy-MM-dd" />
										</span>
									</div>
									
								</div>
							</div>
						</a>
					</c:forEach>
					
				</div>
			</section>
		</div>

		<div class="container-box">
		
			<section class="watting-study">
				<h1>대기중인 스터디</h1>
				<div class="container-box2 sp-box">
					<c:forEach var="wsv" items="${wsv}">
						<a class="group-page" href="group/study/${wsv.id}/index">
							<div class="sp-box2">
								<div class="sp-content-box">
									<c:if test="${wsv.image != 'img1.jpg'}">
										<img src="/images/studyImg/${wsv.id}/${wsv.image}" class="img-size"></img>
									</c:if>
									<c:if test="${wsv.image == 'img1.jpg'}">
										<img src="/images/studyImg/${wsv.image}" class="img-size"></img>
									</c:if>
									<div class="img-size sp-box3">
										<span class="sp-title"> ${wsv.title}</span>
										<span>인원 : ${wsv.memberCount}/${wsv.limitNumber}</span>
										<span>기간 <br /><fmt:formatDate value="${wsv.startDate}"
												pattern="yyyy-MM-dd" /><br />~<br />
										<fmt:formatDate value="${wsv.endDate}" pattern="yyyy-MM-dd" />
										</span>
									</div>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</section>
			
			<section class="watting-project">
				<h1>대기중인 프로젝트</h1>
				<div class="container-box2 sp-box">
					<c:forEach var="wpv" items="${wpv}">
						<a class="group-page" href="group/project/${wpv.id}/index">
							<div class="sp-box2">
								<div class="sp-content-box">
									<img src="/images/projectImg/${wpv.image}" class="img-size">
									<div class="img-size sp-box3">
										<span class="sp-title"> ${wpv.title}</span>
										<span>인원 : ${wpv.memberCount}/${wpv.limitNumber}</span>
										<span>기간 <br /> <fmt:formatDate value="${wpv.startDate}"
												pattern="yyyy-MM-dd" /><br />~<br />
										<fmt:formatDate value="${wpv.endDate}" pattern="yyyy-MM-dd" />
										</span>
									</div>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</section>
			
		</div>

		<div class="container-box last-box">
			<section class="ended-study">
				<h1>완료 스터디</h1>
				<div class="container-box2 sp-box">
					<c:forEach var="esv" items="${esv}">
						<a class="group-page" href="group/study/${esv.id}/index">
							<div class="sp-box2 ">
								<div class="sp-content-box">
									<c:if test="${esv.image != 'img1.jpg'}">
										<img src="/images/studyImg/${esv.id}/${esv.image}" class="img-size"></img>
									</c:if>
									<c:if test="${esv.image == 'img1.jpg'}">
										<img src="/images/studyImg/${esv.image}" class="img-size"></img>
									</c:if>
									<div class="img-size sp-box3">
										<span class="sp-title"> ${esv.title}</span>
										<span>인원 : ${esv.memberCount}/${esv.limitNumber}</span>
										<span>기간 <br /> <fmt:formatDate value="${esv.startDate}"
												pattern="yyyy-MM-dd" /><br />~<br />
										<fmt:formatDate value="${esv.endDate}" pattern="yyyy-MM-dd" />
										</span>
									</div>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</section>
			
			<section class="ended-project">
				<h1>완료 프로젝트</h1>
				<div class="container-box2 sp-box">
					<c:forEach var="epv" items="${epv}">
						<a class="group-page" href="group/project/${epv.id}/index">
							<div class="sp-box2">
								<div class="sp-content-box">
									<img src="/images/projectImg/${epv.image}" class="img-size">
									<div class="img-size sp-box3">
										<span class="sp-title"> ${epv.title}</span>
										<span>인원 : ${epv.memberCount}/${epv.limitNumber}</span>
										<span>기간 <br /> <fmt:formatDate value="${epv.startDate}"
												pattern="yyyy-MM-dd" /><br />~<br />
										<fmt:formatDate value="${epv.endDate}" pattern="yyyy-MM-dd" />
										</span>
									</div>
								</div>
							</div>
						</a>
					</c:forEach>
				</div>
			</section>
			
		</div>

	</div>
</main>