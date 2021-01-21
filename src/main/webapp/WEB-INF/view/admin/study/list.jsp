<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                 <section>
                <h1 class="d-none">검색 폼</h1>
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
                                <td>웹</td>
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