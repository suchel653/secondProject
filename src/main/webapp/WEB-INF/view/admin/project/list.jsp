<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
<!-- <script src="/js/admin/project/list.js"></script> -->
<c:set var="fds" value="${paramValues.f }"></c:set>
<c:set var="sks" value="${paramValues.s }"></c:set>
<c:set var="lns" value="${paramValues.l }"></c:set>
	<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <section>
                    <h1 class="d-none">검색폼</h1>
                    <form action="list" method="get">
                    <table border="1">
                       <tr>
                           <th>필드</th>
                           <td>       
                           <c:forEach var="f" items="${f }">
	                           <c:set var="checked" value=""></c:set>
		                           <c:forEach var="fds" items="${paramValues.f }">
		                           	<c:if test="${fds==f.name }"> 
		                           	<c:set var="checked" value="checked"></c:set>
		                           </c:if>
	                           </c:forEach>
	                               <input type="checkbox" ${checked} name="f" value="${f.name }">${f.name }
                            </c:forEach>
                            </td>     
                       </tr>
                       
                       <tr>
                           <th>스킬</th>
                           <td>                   
                               <c:forEach var="s" items="${s }">   
                               <c:set var="checked" value=""></c:set>
                               <c:forEach var="sks" items="${paramValues.s }">
	                                <c:if test="${sks==s.name}">
	                                	<c:set var="checked" value="checked"></c:set>
	                                </c:if>
                              	 </c:forEach>         
                               <input type="checkbox" ${checked } name="s" value="${s.name }">${s.name }
                            </c:forEach>
                            </td>     
                       </tr>
                       <tr>
                           <th>언어</th>
                           <td>
                           	<c:forEach var="l" items="${l }">
                           	<c:set var="checked" value=""></c:set>
                           	<c:forEach var="lns" items="${paramValues.l }">
                           		<c:if test="${lns==l.name }">
                           			<c:set var="checked" value="checked"></c:set>
                           		</c:if>
                           	</c:forEach>            
                            	<input type="checkbox" ${checked } name="l" value="${l.name }">${l.name }
                           	</c:forEach>
                            </td>     
                       </tr>
                    </table>
                    
                     <div>
	                     <select name="t">
						 <option value="title">제목</option>
						 </select>
						 <input type="text" name="q" value="" />
						 <input class="button searchBtn" type="submit" value="검색" />
                    </div>
                    </form>
                </section>

                <section>
                    <div class="">
                        <table class="table" border="1">
                        <thead>
                            <tr>
                            <td>제목</td>
                            <td>분야</td>
                            <td>기술</td>
                            <td>언어</td>
                            <td>상태</td>
                            <td>작성자</td>
                            <td>등록일</td>
                            </tr>
                         </thead>
                         
                         <tbody class="tbody">
                         
                         <c:forEach var="pj" items="${list }">
							<tr>
								<%-- <td>${pj.id}</td> --%>
								<td><a href="${pj.id }">${pj.title}</a></td>
								<td>${pj.fieldName}</td>
								<td>
									<c:forEach var="sk" items="${pj.skills}" varStatus="st"> 
	                                ${sk.skillName}
	                                <c:if test="${!st.last }">
									 	/
									 </c:if>
	                                </c:forEach> 
                                </td>
                                <td> 
	                                <c:forEach var="l" items="${pj.languages}" varStatus="st"> 
	                                ${l.languageName} 
	                                <c:if test="${!st.last }">/</c:if>
	                                </c:forEach>
	                                </td>
								<%-- <td>${pj.requirement }</td>
								<td>${pj.limitNumber}</td>
								<td>
	                             	 <fmt:formatDate value="${pj.startDate}" pattern="yyyy-MM-dd"/>~
	                                <fmt:formatDate value="${pj.endDate }" pattern="yyyy-MM-dd"/>
                            	</td> --%>
								<td>${pj.statusName }</td>
								<td>${pj.leaderName }</td>
								<td>
								<fmt:formatDate value="${pj.regDate }" pattern="yyyy-MM-dd"/>
								</td>
							</tr>
							</c:forEach>
						
                         </tbody>
                        </table>
                    </div>
                </section>
                
                <c:set var="startNum" value="${page-(page-1)%5 }"></c:set>
                
                <div class="pager">
                    <div>
						<a href="?p=1&f=${param.f}&q=${param.q }"><i class="fas fa-angle-double-left"></i></a>
					</div>
                    
                    <c:if test="${startNum > 1 }">
	                    <div>
	                    	<a href="?p=${startNum-5}&f=${param.f}&q=${param.q}"><i class="fas fa-angle-left"></i></a>
	                    </div>
                    </c:if>
                    <c:if test="${startNum == 1 }">
	                    <div>
	                    	<a href=""><i class="fas fa-angle-left"></i></a>
	                    </div>
                    </c:if>
                    
                    <ul>
	                    <c:forEach var="i" begin="0" end="4">
	                    <c:if test="${i+startNum <= pageCount}">
	                    	<li><a class="${i+startNum==page? 'current':'' }" href="?p=${i+startNum}&f=${param.f }&q=${param.q }">${i+startNum}</a></li>
	                    </c:if>
	                    </c:forEach>
                    </ul>
                    
                    <c:if test="${startNum+5 <= pageCount}">
	                    <div>
	                    	<a href="?p=${startNum+5}&f=${param.f}&q=${param.q}"><i class="fas fa-angle-right"></i></a>
	                    </div>
                    </c:if>
                    <c:if test="${startNum+5 > pageCount}">
	                    <div>
	                    	<a href=""><i class="fas fa-angle-right"></i></a>
	                    </div>
                    </c:if>
                    <div>
						<a href="?p=${pageCount }&f=${param.f}&q=${param.q }"><i class="fas fa-angle-double-right"></i></a>
					</div>
                    
                </div>
                
                
            </main>