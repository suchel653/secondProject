<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="/js/admin/member/list.js"></script>    
<c:set var="page" value="${param.p}" />
<c:if test="${empty param.p}">
	<c:set var="page" value="1" />
</c:if>
<c:set var="startNum" value="${page - (page-1)%10}" />
			<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <section>
                    <h1 class="d-none">검색폼</h1>
                    <form class="search-form" method="post">
                        <div class="search-query">
                            <select name="f">
                                <option value="nickname">닉네임</option>
                                <option value="email">이메일</option>
                            </select>
                            <input name="q" type="text">
                        <input class="button searchBtn search-btn"  type="submit" value="검색">
                        </div>

                    </form>
                </section>

                <section>
                    <h1 class="d-none">테이블</h1>
                    <table class="list-table table">
                        <thead>
                            <tr>
                                <td>회원번호</td>
                                <td>닉네임</td>
                                <td>이메일 주소</td>
                                <td>가입일</td>
                            </tr>
                        </thead>
                
                        <tbody class="member-list tbody">
                        <c:forEach var="m" items="${list }">
                            <tr>
                                <td>${m.id }</td> 
                                <td><a href="${m.id }" class="detail">${m.nickname }</a></td>
                                <td>${m.email }</td>
                                <td>
                                	<fmt:formatDate value="${m.regDate }" pattern="yyyy-MM-dd"/>	
                                </td>
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