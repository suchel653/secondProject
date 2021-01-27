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
		                           <th>분야</th>
		                           <th> 
		                               <input type="checkbox"name="f" value="웹">
		                            </th>     
		                       </tr>
		                       
		                       <tr>
		                           <th>기술</th>
		                           <th>                   
		                                 <input type="checkbox"name="s" value="React">
		                            </th>     
		                       </tr>
		                       <tr>
		                           <th>언어</th>
		                           <th>                   
		                              <input type="checkbox"name="l" value="Javascript">
		                            </th>     
		                       </tr>
		                    </table>
		                    <div>
		                       		<select name="t">
										<option value="title">제목</option>
									</select>
									<input type="text" name="q" value="" />
									<select name="size">
										<option value="10" >10</option>
										<option value="20" >20</option>
										<option value="50" >50</option>
										<option value="100">100개</option>
									</select>
									<input type="submit" value="검색" />
		                    </div>
		                </form>
		            </section>

                <section>
                    <h1 class="d-none">리스트</h1>
                    <ul class="list">
	                    <li>
		                    <img class="p-image" src="/images/language/Go.png">
		                    
		                    <table border="1">
			                    <tbody>
				                    <tr>
				                    	 <th>제목:</th>
				                    	 <td>Spring Boot 기반 플젝 파티원 구함
				                    	 </td>
				                    </tr>
				                    <tr>
				                    	 <th>분야:</th>
				                    	 <td>웹</td>
				                    </tr>
				                    <tr>
				                    	 <th>기술:</th>
				                    	 <td>Spring Boot</td>
				                    </tr>
				                    <tr>
				                    	 <th>언어:</th>
				                    	 <td>Java</td>
				                    </tr>
				                    <tr>
				                    	 <th>인원수:</th>
				                    	 <td> 3 / 5</td>
				                    </tr>
			                    </tbody>
		                    </table>
	                    </li>
                    </ul>
                </section>
               
                
                <div class="pager">
                    <div>
                    	 <a href=""><i class="fas fa-angle-left"></i></a>
                    </div>
                    <ul>
	                  <li><a class="" href="">1</a></li>
                    </ul>
                    <div>
                    	<a href=""><i class="fas fa-angle-right"></i></a>
                    </div>
                  </div>
            </main>