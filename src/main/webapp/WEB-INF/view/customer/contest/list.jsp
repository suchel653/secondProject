<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<main id="main" class="main">
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>공모전 명</th>
				<th>작성자</th>
				<th>시작일</th>
				<th>마감일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td>끼리끼리</td>
				<td>전지전능한 관리자</td>
				<td>2020-12-26</td>
				<td>2020-02-16</td>
				<td>7</td>
			</tr>
			<tr>
				<td>2</td>
				<td>끼리끼리</td>
				<td>전지전능한 관리자</td>
				<td>2020-12-26</td>
				<td>2020-02-16</td>
				<td>7</td>
			</tr>
		</tbody>
	</table>
	
	<form> 
		<div>
			<select name="f">
				<option value="title">공모전 명</option>
				<option value="startDate">시작일</option>
				<option value="endDate">마감일</option>
			</select>
			<input type="text" name="q" >
			<input type="submit" value="검색">
		</div>
	</form>
</main>