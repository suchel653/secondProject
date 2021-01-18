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
                            </select>
                            <input type="text">
                        </div>

                        <label>견종</label>
                        <select>
                          <option>견종</option>
                      </select>
                        <input type="submit" value="검색">

                    </form>
                </section>

                <section>
                    <h1 class="d-none">테이블</h1>
                    <table class="list-table">
                        <thead>
                            <tr>
                                <td>닉네임</td>
                                <td>이름</td>
                                <td>성별</td>
                                <td>생일</td>
                                <td>성격</td>
                                <td>몸무게</td>
                                <td>견종</td>
                            </tr>
                        </thead>
                
                        <tbody>
                            <tr>
                              
                                <td>현지</td> 
                                <td>아띠</td>
                                <td>여</td>
                                <td>20.04.21</td>
                                <td>활발</td>
                                <td>3.8kg</td>
                                <td>비숑</td>
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