<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <table>
                    <tr>
                        <th>이름</th>
                        <td>
                           ${c.title}
                        </td>
                    </tr>
                    <tr>
                        <th>시작일</th>
                        <td>
                            <fmt:formatDate value="${c.startDate}" pattern="yyyy-MM-dd"/>	
                        </td>
                    </tr>
                    <tr>
                        <th>마감일</th>
                        <td>
                            <fmt:formatDate value="${c.endDate}" pattern="yyyy-MM-dd"/>
                        </td>
                    </tr>
                    <tr>
                        <th>등록일</th>
                        <td>
                            <fmt:formatDate value="${c.regDate}" pattern="yyyy-MM-dd"/>
                        </td>
                    </tr>
                    <tr>
                        <th>조회수</th>
                        <td>
                            ${c.hit}
                        </td>
                    </tr>
                    <tr>
                        <th>첨부파일</th>
                        <td>
                       	<c:forEach var="f" items="${c.contestFiles}">
                       		<!--<a download href="">${f.name} </a>  -->
                       		${f.name }
                       	</c:forEach>
                        </td>
                    </tr>
                    <tr>
                        <th>이미지</th>
                        <td>
                       	<c:forEach var="img" items="${c.contestImages}">
                       		<img src="/images/contestImg/${c.id}/${img.name}" />
                       	</c:forEach>
                        </td>
                    </tr>
                    <tr>
		                <td colspan="2">
		                    ${c.content}
		                </td>
	                </tr>
                </table>
                
                <table>
					<tbody>
						<tr>
							<th>다음글</th>
							<td colspan="3">
								<c:if test="${empty next}">
								다음글이 없습니다.
								</c:if>
								<c:if test="${not empty next}">
								<a href="${next.id}">${next.title}</a>
								</c:if>
							</td>
						</tr>
						
						<tr>
							<th>이전글</th>
							<td colspan="3">
								<c:if test="${empty prev}">
								이전글이 없습니다.
								</c:if>
								<c:if test="${not empty prev}">
								<a href="${prev.id}">${prev.title}</a>
								</c:if>
							</td>
						</tr>
					</tbody>
				</table>
                
                <div>
                	<a href="list"><input type="button" value="목록"></a>
                	<a href="${c.id}/edit"><input type="button" value="수정"></a>
                </div>
                
                
            </main>