<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<c:set var="page" value="${param.p}" />
<c:if test="${empty param.p}">
	<c:set var="page" value="1" />
</c:if>
<c:set var="startNum" value="${page - (page-1)%10}" />
<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <section>
                    <h1 class="d-none">검색폼</h1>
                    <form method="post">
                        <div>
                            <select name="f">
                                <option value="title">공모전 이름</option>
                                <option value="writerName">작성자</option>
                                <option value="startDate">시작일</option>
                                <option value="endDate">마감일</option>
                            </select>
                            <input type="text" name="q">
	                        <input type="submit" value="검색">
                        </div>

                    </form>
                </section>

                <section>
                    <h1 class="d-none">테이블</h1>
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>공모전 이름</td>
                                <td>시작일</td>
                                <td>마감일</td>
                                <td>작성자</td>
                                <td>등록일</td>
                                <td>조회수</td>
                                <td>삭제</td>
                            </tr>
                        </thead>
                
                        <tbody>
                        <c:forEach var="c" items="${list }">
                            <tr>
                                <td>${c.id}</td> 
                                <td>
                                	<a href="${c.id }">${c.title }</a>
                                </td>
                                <td>
                                	<fmt:formatDate value="${c.startDate }" pattern="yyyy-MM-dd"/>	
                                </td>
                                <td>
                                	<fmt:formatDate value="${c.endDate }" pattern="yyyy-MM-dd"/>	
                                </td>
                                <td>${c.writerName }</td>
                                <td>
                                	<fmt:formatDate value="${c.regDate }" pattern="yyyy-MM-dd"/>	
                                </td>
                                <td>${c.hit }</td>
                               	<td>
                               		<a href="${c.id}/del"><input type="button" value="삭제"/></a>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </section>
                <div>
					<a href="reg">글쓰기</a>	
                </div>
				<div>
					${page}/ ${pageCount} 페이지
				</div>
                <div class="pager">
                    <div>
                      <a href="#"><i class="fas fa-angle-double-left"></i></a>
                    </div>
                    <div>
                      <a href="#"><i class="fas fa-angle-left"></i></a>
                    </div>
                    <ul>
	                <c:forEach var="i" begin="0" end="4" varStatus="st">
						<c:set var="current" value="" />
						<c:if test="${i+startNum == page }" >
							<c:set var="current" value="orange bold" />
						</c:if>
						
						<c:if test="${i+startNum <= pageCount }">
							<li><a class="-text- ${current }" href="?p=${i+startNum}&f=${param.f }&q=${param.q}" >${i+startNum}</a></li>
						</c:if>
					</c:forEach>
                    </ul>
                    <div>
                      <a href="#"><i class="fas fa-angle-right"></i></a>
                    </div>
                    <div>
                      <a href="#"><i class="fas fa-angle-double-right"></i></a>
                    </div>
                  </div>
            </main>