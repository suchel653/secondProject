<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <form method="post" enctype="multipart/form-data">
	                <table>
	                    <tr>
	                        <th>이름</th>
	                        <td>
	                           <input type="text" name="title" value="${c.title }">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>시작일</th>
	                        <td>
	                            <%-- <input type="text" name="startDate" value="<fmt:formatDate value="${c.startDate }" pattern="yyyy-MM-dd"/>"> --%>
	                            <input type="text" name="startDate"
	                            	value="<fmt:formatDate value="${c.startDate }" pattern="yyyy-MM-dd"/>"
	                            >(yyyy-dd-mm)
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>마감일</th>
	                        <td>
	                            <%-- <input type="text" name="endDate" value="<fmt:formatDate value="${c.endDate }" pattern="yyyy-MM-dd"/>"> --%>
	                            <input type="text" name="endDate"
	                            	value="<fmt:formatDate value="${c.endDate }" pattern="yyyy-MM-dd"/>"
	                            >(yyyy-dd-mm)
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
			                    <textarea name="content">
			                        ${c.content}
			                    </textarea>
			                </td>
		                </tr>
	                </table>
	                
	                <div>
	                	<input type="hidden" name="id" value="${c.id}" />
	                    <input type="submit" value="저장" />
	                    <a href="../${c.id }">취소</a>
	                </div>
                </form>
            </main>