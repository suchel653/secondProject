<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <section>
                    <h1 class="d-none">검색폼</h1>
                    <form>
                        <div>
                            <select>
                                <option>공모전 이름</option>
                                <option>작성자</option>
                                <option>시작일</option>
                                <option>마감일</option>
                            </select>
                            <input type="text">
                        </div>
                        <input type="submit" value="검색">

                    </form>
                </section>

                <section>
                    <h1 class="d-none">테이블</h1>
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>번호</td>
                                <td>공모전 이름</td>
                                <td>시작일</td>
                                <td>마감일</td>
                                <td>작성자</td>
                                <td>등록일</td>
                                <td>조회수</td>
                            </tr>
                        </thead>
                
                        <tbody>
                            <tr>
                                <td>1</td> 
                                <td>끼리끼리 프로젝트</td>
                                <td>2021-01-04</td>
                                <td>2021-02-12</td>
                                <td>김미뇽</td>
                                <td>2021-01-04</td>
                                <td>7</td>
                            </tr>
                        </tbody>
                    </table>

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