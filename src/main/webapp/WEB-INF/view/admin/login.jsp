<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/css/admin/components/login/login-form.css" type="text/css" rel="stylesheet">
<link href="/css/admin/default.css" type="text/css" rel="stylesheet" />
</head>
<body>
	 <div class="body">
        <main id="main" class="main">
            <h1 class="d-none">메인이다</h1>
            <div class="container">
                <h1 class="d-none">로그인 정보 입력</h3>
                <form class="login-form" method="post">
                    <fieldset class="login">
                        <legend class="d-none">로그인 폼</legend>
                        
                        <ul class="login-box">
                            <li>
                                <label for="uid" class="id">아이디 </label>
                                <input type="text" name="username" placeholder="아이디" />
                            </li>
                            <li class="pwd">
                                <label for="pwd">비밀번호</label>
                                <input type="password" name="password" placeholder="비밀번호" />
                            </li>
                        </ul>
                        
                        

                       
                       
                        <input type="submit" class="btn login-btn" value="login"/>
                       
                        
                    </fieldset>
                    <div class="kakao-login">
                        	카카오 로그인박스
                     </div>
                </form>

            </div>
        </main>
    </div>
</body>
</html>