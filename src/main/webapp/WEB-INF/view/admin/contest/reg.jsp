<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <form method="post" enctype="multipart/form-data">
	                <table>
	                    <tr>
	                        <th>이름</th>
	                        <td>
	                            <input type="text" name="title">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>시작일</th>
	                        <td>
	                            <input type="text" name="startDate">(yyyy-dd-mm)
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>마감일</th>
	                        <td>
	                            <input type="text" name="endDate">(yyyy-dd-mm)
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>첨부파일</th>
	                        <td>
	                        	<input multiple="multiple" type="file" name="files">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>이미지</th>
	                        <td>
	                        	<input multiple="multiple" type="file"  name="imgs">
	                        </td>
	                    </tr>
	                </table>
	                
                    <textarea name="content"></textarea>
	                
	                <div>
                        <input type="submit" value="등록" />
                        <a href="list">취소</a>
                    </div>
                </form>
            </main>