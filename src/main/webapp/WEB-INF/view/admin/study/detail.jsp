<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                
                <section>
                        <table border="1">
                        <thead>
	                       
                           <tr>
		                        <td>
			                     <img src="/images/language/${s.image}" style="width:300px; height:300px;"></img>
		                        </td>
	                            <td>번호</td>
	                            <td>제목</td>
	                            <td>분야</td>
	                            <td>기술</td>
	                            <td>언어</td>
	                            <td>요구사항</td>
	                            <td>인원</td>
	                            <td>진행일</td>
	                            <td>상태</td>
	                            <td>작성자</td>
	                            <td>등록일</td>
	                            <td>내용</td>
                           </tr>
                         </thead>
                         
                         <tbody>
							<tr>
								<td></td>
								<td>${s.id}</td>
								<td>${s.title}</td>
								<td>${s.fieldName }</td>
								<td>
									<c:forEach var="s" items="${s.skill}">
									 ${s.skillName } /
									</c:forEach>
								</td>
								<td>
									<c:forEach var="l" items="${s.language }">
									 ${l.languageName } /
									</c:forEach>
								</td>
								<td>${s.requirement }</td>
								<td>${s.limitNumber }</td>
								<td>
	                             	<fmt:formatDate value="${s.startDate}" pattern="yyyy-MM-dd"/>~
	                                <fmt:formatDate value="${s.endDate }" pattern="yyyy-MM-dd"/>
                            	</td>
								<td>${s.statusName }</td>
								<td>${s.leaderName }</td>
								<td>
									<fmt:formatDate value="${s.regDate }" pattern="yyyy-MM-dd"/>
								</td>
								<td>${s.content }</td>
							</tr>
                         </tbody>
                        </table>
                </section>
                
                
            </main>