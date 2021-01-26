<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="/js/admin/member/detail.js"></script>    
			<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <section>
                    <h1 class="d-none">검색폼</h1>
                    <form>
                        <div>
                            <select>
                                <option>닉네임</option>
                                <option>이메일</option>
                            </select>
                            <input type="text">
                        </div>
                        <input type="submit" value="검색">

                    </form>
                </section>

                <section>
                    <h1 class="d-none">테이블</h1>
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>회원번호</td>
                                <td>닉네임</td>
                                <td>이메일 주소</td>
                                <td>가입일</td>
                            </tr>
                        </thead>
                
                        <tbody>
                        <c:forEach var="m" items="${list }">
                            <tr>
                                <td>${m.id }</td> 
                                <td><a href="${m.id }/detail" class="detail">${m.nickname }</a></td>
                                <td>${m.email }</td>
                                <td>
                                	<fmt:formatDate value="${m.regDate }" pattern="yyyy-MM-dd"/>	
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>

                </section>
            </main>