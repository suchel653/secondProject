<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
<c:set var="fns" value = "${paramValues.f}" />
<c:set var="sns" value = "${paramValues.s}" />
<c:set var="lns" value = "${paramValues.l}" />
<c:set var="fnsList" value=""/>
<c:set var="snsList" value=""/>
<c:set var="lnsList" value=""/>
<c:set var="page" value = "${param.p}" />
<c:if test="${empty param.p}">
   <c:set var="page" value = "1" />
</c:if>

<c:forEach var="fns" items="${paramValues.f}" varStatus="st">

	<c:set var="fnsList" value="${st.last ? (fnsList+=fns):(fnsList+=fns+='&f=')}"/>
    <%-- <c:if test="${!st.last}">
        <c:set var="fnsList" value="${fnsList}${fns}&f="/>
    </c:if>
    <c:if test="${st.last}">
    	<c:set var="fnsList" value="${fnsList}${fns}"/>
    </c:if> --%>
</c:forEach>

<c:forEach var="sns" items="${paramValues.s}" varStatus="st">
	<c:set var="snsList" value="${st.last ? (snsList+=sns):(snsList+=sns+='&s=')}"/>
</c:forEach>

<c:forEach var="lns" items="${paramValues.l}" varStatus="st">
	<c:set var="lnsList" value="${st.last ? (lnsList+=lns):(lnsList+=lns+='&l=')}"/>
</c:forEach>

<main id="main" class="main">

                <h1 class="d-none">메인이다</h1>
                 <section>
                <h1 class="d-none">검색 폼</h1>
                <form action="list" method="get">
                    <table border="1">
                       <tr>
                           <th>필드</th>
                           <td> 
                               <c:forEach var="f" items="${f}">
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
							<input type="text" name="q" value="${param.q}" />
							<select name="size">
						
								<option value="10" ${param.size==10?"selected":""}>10개</option>
								<option value="20" ${param.size==20?"selected":""}>20개</option>
								<option value="50" ${param.size==50?"selected":""}>50개</option>
								<option value="100" ${param.size==100?"selected":""}>100개</option>
						
							</select>
							<input type="submit" value="검색" />
                    </div>
                </form>
            </section>

                <section>
                    <h1 class="d-none">테이블</h1>
                    <table class="list-table" border="1">
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
                                <td><a href="${s.id}/detail">${s.title}</a></td>
                                <td>${s.fieldName}</td>
                                <td>
                                	<c:forEach var="sk" items="${s.skill}" varStatus="st">
                        				${sk.skillName}
                        			<c:if test="${!st.last}">
                        				,       
                        			</c:if>
                      
                                	</c:forEach> 
                                </td>
                                <td> 
                               		<c:forEach var="l" items="${s.language}" varStatus="st"> 
                                		${l.languageName}
                                		<c:if test="${!st.last}">
                        				,       
                        			</c:if>
                                	</c:forEach>
                                </td>
                                <td>${s.leaderName}</td>
                                <td>
                             	 <fmt:formatDate value="${s.startDate}" pattern="yyyy-MM-dd"/>~
                                <fmt:formatDate value="${s.endDate }" pattern="yyyy-MM-dd"/>
                            	</td>
                                <td>${s.limitNumber}</td>
                                <td>${s.statusName}</td>
                                <td> <fmt:formatDate value="${s.regDate}" pattern="yyyy-MM-dd"/></td>
                            </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </section>
               
                <c:set var = "startNum" value="${page-(page-1)%5}"/>
                
                <div class="pager">
                    <div>
                      <a href="?p=${1}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}"><i class="fas fa-angle-double-left"></i></a>
                    </div>
                    <div>
                    <c:if test="${startNum>1}">
                    	 <a href="?p=${startNum-5}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}"><i class="fas fa-angle-left"></i></a>
                    </c:if>
                    
                    <c:if test="${startNum<=1}">
                    	<a href="?p=${1}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}"><i class="fas fa-angle-left"></i></a>
                    </c:if>
                     
                    </div>
                    
                    <ul>
	                    <c:forEach var="i" begin="0" end="4">
	                    	
	                    	<c:if test="${i+startNum <= pageCount}">
	                      		<li><a class="${i+startNum==page?"current":""}" href="?p=${i+startNum}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}">${i+startNum}</a></li>
	                    	</c:if>
	                    </c:forEach>
                    </ul>
                    <div>
                    <c:if test="${startNum+5<=pageCount}">
                    	<a href="?p=${startNum+5}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}"><i class="fas fa-angle-right"></i></a>
                    </c:if>
                    
                    <c:if test="${startNum+5>pageCount}">
                    	<a href="?p=${pageCount}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}"><i class="fas fa-angle-right"></i></a>
                    </c:if>
                    
                    </div>
                    <div>
                      <a href="?p=${pageCount}&f=${fnsList}&s=${snsList}&l=${lnsList}&t=${param.t}&q=${param.q}"><i class="fas fa-angle-double-right"></i></a>
                    </div>
                  </div>
            </main>
            
