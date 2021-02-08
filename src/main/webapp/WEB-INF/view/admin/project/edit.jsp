<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<script src="/js/admin/project/edit.js"></script>


	<main id="main" class="main detail">
			<h1 class="d-none">메인이다</h1>
			<div class="container">
				
				
				
				<section class="edit-section">
				
				<form method="post" enctype="multipart/form-data">
					<h1>제목:<input type="text" name="title" value="${pj.title}"/></h1>
					<div class="detail-container">
					
					
					
						<div style="display:flex; flex-direction: column;">
							<img src="/images/projectImg/${pj.image }" style="width:300px; height:300px;"></img>
							<input type="file" name="image"/>
						</div>
						
						
						<table border="1">
							<tbody>
							<tr>
								<th>분야 : </th>
								<td >
								<select  name="field">
									<c:forEach var="fi" items="${f}">
									<c:set var="selected" value=""></c:set>
									<c:if test="${fi.name==pj.fieldName}">
									<c:set var="selected" value="selected"></c:set>
									</c:if>
										<option ${selected } value="${fi.id }">${fi.name }</option>
									</c:forEach>
								</select>
								</td>
							</tr>
							<tr>
								<th>기술 : </th>
								<td>
								
									<c:forEach var="si" items="${s}" varStatus="st">
									<c:set var="checked" value=""></c:set>
									<c:forEach var="ps" items="${pj.skills}">
	                                <c:if test="${si.name==ps.skillName}">
	                                	<c:set var="checked" value="checked"></c:set>
	                                </c:if>
                              	 	</c:forEach>
									<input type="checkbox" ${checked } name="skill" value="${si.id }">${si.name }
									</c:forEach>
								
								</td>
							</tr>
							<tr>
								<th>언어 : </th>
								<td>
									<c:forEach var="li" items="${l}" varStatus="st">
									<c:set var="checked" value=""></c:set>
									<c:forEach var="pl" items="${pj.languages}">
	                                <c:if test="${li.name==pl.languageName}">
	                                	<c:set var="checked" value="checked"></c:set>
	                                </c:if>
                              	 	</c:forEach>
									<input type="checkbox" ${checked } name="language" value="${li.id }">${li.name }
									</c:forEach>
								</td>
							</tr>
							<tr>
			                  <th>파일 : </th>
			                  <td>
			                  	<input type="file" name="files" multiple>
								<c:forEach var="f" items="${pj.files }" varStatus="st">
									<div class="file-container">
										<a download href="/images/projectFile/${f.name }">${f.name }</a>
										<input class="x-btn" type="button" value="X">
									</div>
								</c:forEach>
							 </td>
			                </tr>
							<tr>
								<th>인원 : </th>
								<td ><input type="text" name="limitNumber" value="${pj.limitNumber}"/>명</td>
							</tr>
							<tr>
								<th>요구사항 :</th>
								<td ><input type="text" name="requirement" value="${pj.requirement}"/></td>
							</tr>
							<tr>
								<th>진행일 : </th>
								<td >
								
								<input type="text" name="startDate" value="<fmt:formatDate value="${pj.startDate }" pattern="yyyy-MM-dd"/>" />~
								<input type="text" name="endDate" value="<fmt:formatDate value="${pj.endDate }" pattern="yyyy-MM-dd"/>" />
								</td>
							</tr>
							<tr>
								<th>상태 : </th>
								<td >
								<select name="status">
								<option value="1">모집중</option>
								<option value="2">진행중</option>
								<option value="3">마감</option>
								</select>
								</td>
							</tr>
							<tr>
								<th>작성자 : </th><td >${pj.leaderName }</td>
							</tr>
							<tr>
								<th>등록일  :</th>
								<td >
									<fmt:formatDate value="${pj.regDate }" pattern="yyyy-MM-dd"/>
								</td>
							</tr>
							</tbody>
							</table>
						</div>
						
						<textarea name="content" class="content" >${pj.content }</textarea>
						
						<c:forEach var="f" items="${pj.files }" varStatus="st">
							<input hidden name="oldFiles" type="text" value="${f.name }"/>
						</c:forEach>
						
						<c:forEach var="l" items="${pj.languages }" varStatus="st">
							<input hidden name="oldSLanguages" type="text" value="${l.languageId } "/>
						</c:forEach>
						
						<c:forEach var="s" items="${pj.skills }" varStatus="st">
							<input hidden name="oldSkills" type="text" value="${s.skillId }"/>
						</c:forEach>
									
						<c:forEach var="l" items="${pj.languages }" varStatus="st">
							<input hidden name="oldSLanguages" type="text" value="${l.languageId } "/>
						</c:forEach>
							
				
	              		<div style="display: flex; justify-content: flex-end; margin-right: 60px; margin-top: 20px">
	              		 	<a class="button searchBtn" href="../list">목록</a>
		                	<input type="submit" class="button searchBtn" value="저장" style="margin-left: 20px;"/>
		                	<a class="button searchBtn" href="../${pj.id }" style="margin-left: 20px;">뒤로가기</a>
		                </div>
		                </form>
				</section>
                </div>
            </main>