<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="https://kit.fontawesome.com/b280fc7aa7.js" crossorigin="anonymous"></script>
<!-- <script src="/js/admin/project/list.js"></script> -->
	<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <section>
                    <h1 class="d-none">검색폼</h1>
                    <form action="list" method="get">
                    <table border="1">
                       <tr>
                           <th>필드</th>
                           <td>                   
                               <input type="checkbox" name="field" value="1">웹 개발
                               <input type="checkbox" name="field" value="2">인공지능
                               <input type="checkbox" name="field" value="3">블록체인
                               <input type="checkbox" name="field" value="4">IOS
                            </td>     
                       </tr>
                       
                       <tr>
                           <th>스킬</th>
                           <td>                   
                               <input type="checkbox" name="skill" value="1">Spring
                               <input type="checkbox" name="skill" value="2">Django
                               <input type="checkbox" name="skill" value="3">Vue
                               <input type="checkbox" name="skill" value="4">React
                            </td>     
                       </tr>
                       <tr>
                           <th>언어</th>
                           <td>                   
                               <input type="checkbox" name="language" value="1">C
                               <input type="checkbox" name="language" value="2">C++
                               <input type="checkbox" name="language" value="3">Python
                               <input type="checkbox" name="language" value="4">Java
                            </td>     
                       </tr>
                    </table>
                    
                     <div>
	                     <select name="f">
						 <option value="title">제목</option>
						 </select>
						 <input type="text" name="q" value="" />
						 <input type="submit" value="검색" />
                    </div>
                    </form>
                </section>

                <section>
                    <div class="">
                        <table border="1">
                        <thead>
                            <tr>
                            <td>번호</td>
                            <td>제목</td>
                            <td>작성자</td>
                            <td>요구사항</td>
                            <td>등록일</td>
                            </tr>
                         </thead>
                         
                         <tbody>
                         
                         <c:forEach var="pj" items="${list }">
							<tr>
								<td>${pj.id}</td>
								<td><a href="${pj.id }">${pj.title}</a></td>
								<td>${pj.leaderId }</td>
								<td>${pj.requirement }</td>
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
	                    	<li><a href="?p=${i+startNum}&f=${param.f }&q=${param.q }">${i+startNum}</a></li>
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