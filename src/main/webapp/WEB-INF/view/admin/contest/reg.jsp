<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/css/admin/contest/reg.css" type="text/css" rel="stylesheet" />
<main id="main" class="main">
                <form class="reg" method="post" enctype="multipart/form-data">
                <h1>등록</h1>
	                <table>
	                    <tr>
	                        <th>이름</th>
	                        <td class="title" colspan="3">
	                            <input type="text" name="title">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>시작일</th>
	                        <td class="date">
	                            <input type="text" name="startDate"> (yyyy-dd-mm)
	                        </td>
	                        <th>마감일</th>
	                        <td class="date">
	                            <input type="text" name="endDate"> (yyyy-dd-mm)
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>첨부파일</th>
	                        <td colspan="3">
	                        	<input multiple="multiple" type="file" name="files">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>이미지</th>
	                        <td colspan="3">
	                        	<input multiple="multiple" type="file"  name="imgs">
	                        </td>
	                    </tr>
	                </table>
	                
	                <div class="content">
                    	<textarea name="content"></textarea>
	                </div>
	                
	                <div class="submit-btn">
                        <input class="button" type="submit" value="등록" />
                        <a class="button" href="list">취소</a>
                    </div>
                </form>
            </main>