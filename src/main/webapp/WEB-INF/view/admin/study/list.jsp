<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main id="main" class="main">
                <h1 class="d-none">메인이다</h1>
                <section>
                    <h1 class="d-none">검색폼</h1>
                    <form>
                        <div>
                            <select>
                                <option>닉네임</option>
                            </select>
                            <input type="text">
                        </div>

                        <label>견종</label>
                        <select>
                          <option>견종</option>
                          <option>푸들</option>
                          <option>비숑</option>
                          <option>말티즈</option>
                      </select>
                        <input type="submit" value="검색">

                    </form>
                </section>

                <section>
                    <h1 class="d-none">테이블</h1>
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>아이디</td>
                                <td>제목</td>
                                <td>필드</td>
                                <td>스킬</td>
                                <td>언어</td>
                                <td>스터디장</td>
                                <td>진행날짜</td>
                          
                                <td>인원</td>
                                <td>상태</td>
                                <td>등록일</td>
                            </tr>
                        </thead>
                
                        <tbody>
                            <tr>
                              
                                 <td>1</td>
                                <td>C스터디에여</td>
                                <td>기타</td>
                                <td>기타</td>
                                <td>C</td>
                                <td>victor</td>
                                <td>2020-12-31~2021-03-05</td>
                            
                                <td>3</td>
                                <td>진행중</td>
                                <td>2020-12-01</td>
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