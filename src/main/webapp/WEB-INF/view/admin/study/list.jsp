<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="fns" value = "${paramValues.f}" />
<c:set var="sns" value = "${paramValues.s}" />
<c:set var="lns" value = "${paramValues.l}" />
<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                 <section>
                <h1 class="d-none">검색 폼</h1>
                <form action="list" method="get">
                    <table border="1">
                       <tr>
                           <th>필드</th>
                           <td> 
                               <c:forEach var="f" items="${f}" varStatus="status">
	                               <c:set var="checked" value = "" />
	                               <c:forEach var="fns" items="${paramValues.f}">
	                               		<c:if test="${fns==f.name}">
	                               			<c:set var="checked" value = "checked" />
	                               		</c:if>
	                               </c:forEach>
                               		<input type="checkbox" ${checked} name="f" value="${f.name}">${f.name}
                               </c:forEach>
                            </td>     
                       </tr>
                       
                       <tr>
                           <th>스킬</th>
                           <td>                   
                               <c:forEach var="s" items="${s}">
                               	   <c:set var="checked" value = "" />
	                               <c:forEach var="sns" items="${paramValues.s}">
	                               		<c:if test="${sns==s.name}">
	                               			<c:set var="checked" value = "checked" />
	                               		</c:if>
	                               </c:forEach>      
                               		<input type="checkbox" ${checked} name="s" value="${s.name}">${s.name}
                               </c:forEach>      
                            </td>     
                       </tr>
                       <tr>
                           <th>언어</th>
                           <td>                   
                               <c:forEach var="l" items="${l}">   
                                	<c:set var="checked" value = "" />
	                               <c:forEach var="lns" items="${paramValues.l}">
	                               		<c:if test="${lns==l.name}">
	                               			<c:set var="checked" value = "checked" />
	                               		</c:if>
	                               </c:forEach>         
                               		<input type="checkbox" ${checked} name="l" value="${l.name}">${l.name}
                               </c:forEach>      
                            </td>     
                       </tr>
                    </table>
                    <div>
                       		<select name="t">
								<option value="title">제목</option>
							</select>
							<input type="text" name="q" value="" />
							<input type="submit" value="검색" />
                    </div>
                </form>
            </section>

                <section>
                    <h1 class="d-none">테이블</h1>
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>아이디</td>
                                <td>제목</td>
                                <td>필드</td>
                                <td>스킬</td>
                                <td>언어</td>
                                <td>스터디장</td>
                                <td>진행날짜</td>
                                <td>인원</td>
                                <td>상태</td>
                                <td>등록일</td>
                            </tr>
                        </thead>
                
                        <tbody>
                        <c:forEach var ="s" items="${list}">
                        
                            <tr>        
                                <td>${s.id}</td>
                                <td>${s.title}</td>
                                <td>${s.fieldName}</td>
                                <td>
                        <c:forEach var="sk" items="${s.skill}"> 
                                ${sk.skillName}
                                </c:forEach> 
                                </td>
                                <td> 
                               <c:forEach var="l" items="${s.language}"> 
                                ${l.languageName} 
                                </c:forEach>
                                </td>
                                <td>victor</td>
                                <td>
                             	 <fmt:formatDate value="${s.startDate}" pattern="yyyy-MM-dd"/>~
                                <fmt:formatDate value="${s.endDate }" pattern="yyyy-MM-dd"/>
                            	</td>
                                <td>${s.limitNumber}</td>
                                <td>진행중</td>
                                <td> <fmt:formatDate value="${s.regDate}" pattern="yyyy-MM-dd"/></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>

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