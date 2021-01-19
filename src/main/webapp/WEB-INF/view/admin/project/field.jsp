<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
	<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <section>
                    <h1 class="d-none">검색폼</h1>
                    <form>
                    
                        <div>
                            <select>
                                <option>제목</option>
                                <option>분야</option>
                                <option>기술</option>
                                <option>언어</option>
                            </select>
                            <input type="text">
                        </div>
                        <input type="submit" value="검색">
                    </form>
                </section>

                <section>
                    <div class="">
                        <table border="1">
                        <thead>
                            <tr>
                            <td>번호</td>
                            <td>제목</td>
                            <td>분야</td>
                            <td>기술</td>
                            <td>언어</td>
                            <td>등록일</td>
                            <td></td>
                            </tr>
                         </thead>
                         
                         <tbody>
                         </tbody>
                        </table>
                    </div>
                </section>
                
                <div class="pager">
                    <div>
                    <a href="#"><i class="fas fa-angle-double-left"></i></a>
                    </div>
                    <div>
                    <a href="#"><i class="fas fa-angle-left"></i></a>
                    </div>
                    <ul>
                    <li><a href="#">1</a></li>
                    </ul>
                    <div>
                    <a href="#"><i class="fas fa-angle-right"></i></a>
                    </div>
                    <div>
                    <a href="#"><i class="fas fa-angle-double-right"></i></a>
                    </div>
                </div>
                
            </main>