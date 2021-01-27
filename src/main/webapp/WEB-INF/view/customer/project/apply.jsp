<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

	<main id="main" class="main">
        <h1 class="d-none">메인이다</h1>
        
        <div class="container">
          <section>
          <h1 class="d-none">메인이다</h1>
          
            <div class="title">
              <h1>Spring Boot 기반 플젝 파티원 구함</h1>
            </div>
            
            <div>
              <img src="../images/img1.jpg" ></img>
              <table border="1">
                <tbody>
                <tr>
                  <th>분야 : </th><td >웹</td>
                </tr>
                <tr>
                  <th>기술 : </th>
                  <td>
                    Spring Boot
                  </td>
                </tr>
                <tr>
                  <th>언어 : </th>
                  <td>
                    Java
                  </td>
                </tr>
                <tr>
                  <th>인원 : </th>
                  <td >	3 / 5</td>
                </tr>
                <tr>
                  <th>요구사항 :</th>
                  <td> </td>
                </tr>
                <tr>
                  <th>진행일 : </th>
                  <td >
                  </td>
                </tr>
                <tr>
                  <th>상태 : </th><td ></td>
                </tr>
                <tr>
                  <th>작성자 : </th><td ></td>
                </tr>
                <tr>
                  <th>등록일 :</th>
                  <td >
                    <fmt:formatDate value="${pj.regDate }" pattern="yyyy-MM-dd"/>
                  </td>
                </tr>
                </tbody>
                </table>
              </div>
              
              <div class="content-box"></div>
          
            </section>

            <div class="apply-cancel-button">
              <a class="" href="">뒤로가기</a>
              <a class="" href="">지원하기</a>
            </div>

            <div class="prev-next-button">
              <a class="" href="">이전글</a>
              <a class="" href="">다음글</a>
            </div>

        </div>
      </main>