<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <table>
                    <tr>
                        <th>이름</th>
                        <td>
                           ${c.title }
                        </td>
                    </tr>
                    <tr>
                        <th>시작일</th>
                        <td>
                            <fmt:formatDate value="${c.startDate }" pattern="yyyy-MM-dd"/>	
                        </td>
                    </tr>
                    <tr>
                        <th>마감일</th>
                        <td>
                            <fmt:formatDate value="${c.endDate }" pattern="yyyy-MM-dd"/>
                        </td>
                    </tr>
                    <tr>
                        <th>첨부파일</th>
                        <td></td>
                    </tr>
                    <tr>
                        <th>이미지</th>
                        <td></td>
                    </tr>
                    <tr>
		                <td colspan="2">
		                    ${c.content }
		                </td>
	                </tr>
                </table>
                
                <div>
                	<a href="list"><input type="button" value="목록"></a>
                	<a href="${c.id}/edit"><input type="button" value="수정"></a>
                </div>
            </main>