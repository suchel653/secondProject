<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="/css/admin/contest/reg.css" type="text/css" rel="stylesheet" />
<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <form class="reg" method="post" enctype="multipart/form-data">
	                <table>
	                    <tr>
	                        <th>이름</th>
	                        <td class="title" colspan="3">
	                           <input type="text" name="title" value="${c.title }">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>시작일</th>
	                        <td  class="date">
	                            <%-- <input type="text" name="startDate" value="<fmt:formatDate value="${c.startDate }" pattern="yyyy-MM-dd"/>"> --%>
	                            <input type="text" name="startDate"
	                            	value="<fmt:formatDate value="${c.startDate }" pattern="yyyy-MM-dd"/>"
	                            >(yyyy-dd-mm)
	                        </td>
	                        <th>마감일</th>
	                        <td  class="date">
	                            <%-- <input type="text" name="endDate" value="<fmt:formatDate value="${c.endDate }" pattern="yyyy-MM-dd"/>"> --%>
	                            <input type="text" name="endDate"
	                            	value="<fmt:formatDate value="${c.endDate }" pattern="yyyy-MM-dd"/>"
	                            >(yyyy-dd-mm)
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>첨부파일</th>
	                        <td colspan="3">
	                        <c:forEach var="f" items="${c.contestFiles}">
                        		${f.name }
                        	</c:forEach>
	                        </td>
	                    </tr>
	                </table>
	            
	                <div class="img-list">
                        <h1>이미지</h1>
                        <div class="img">
                        <c:forEach var="img" items="${c.contestImages}">
                       		<img src="/images/contestImg/${c.id}/${img.name}" />
                       	</c:forEach>
                        </div>
                    </div>
	                        
	                <div class="content">
	                    <textarea name="content">
	                        ${c.content}
	                    </textarea>
                    </div>
	                
	                <div class="submit-btn">
	                	<input type="hidden" name="id" value="${c.id}" />
	                    <input class="button" type="submit" value="저장" />
	                    <a class="button" href="../${c.id }">취소</a>
	                </div>
                </form>
            </main>