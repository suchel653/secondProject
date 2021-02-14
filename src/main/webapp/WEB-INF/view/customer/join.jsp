<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
	<link rel="stylesheet" href="/css/customer/login.css"></link>
	 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script> 
			 	 <script src="/js/customer/login.js"></script>
			 <script src="/js/customer/join.js"></script>
				  <main id="main" class="main">
    <div class="login-container">
        <div class="move">
          <div class="p-button normal signin animated pulse">SIGN IN</div>
        </div>
        <div class="welcome">
          <h4 class="bold welcome-text">Welcome Back!</h4>
          <p class="normal text">To keep connected with us please login with your personal info</p>
        </div>
        <div class="hello">
          <h4 class="bold welcome-text">Hello Friend</h4>
          <p class="normal text">Enter your personal details and start journey with us</p>
        </div>

        <div class="form">
        <form id="reg" method="post" class="join-form" onsubmit="return submitCheck();" action="join">
            
          <h4 class="bold title">Create Account</h4>
         
          <p class="normal light">Or use your email for registration</p>

          
        <div id="email">
        <input type="text" name="email" class="normal" placeholder="Email">
        <input type="button" value="e-mail 인증">
        </div>

        
        <div id="confirm">
            <input type="text" class="normal" placeholder="인증번호입력">
            <input type="button" value="확인">
        </div>


        <div id="password">
            <input type="password" name="password" placeholder="password" class="normal">
        </div>


        <div id="nickname">
            <input type="text" name="nickname" class="normal name" placeholder="NicName">
            <input type="button" value="닉네임 중복확인">
        </div>
        

        <input type="submit" class="b-button normal" value="SING UP">
        </form>
        
               <div class="login-div">
            <form class="login-form" method="post" action="login">
            
             <h4 class="bold title">Create Account</h4>
         
          	<p class="normal light">Or use your email for registration</p>
          	
                  <div id="email">
                     <input type="text" name="username" class="normal" placeholder="Email">
                  </div>
                
                  <div id="password">
                     <input type="password" name="password" class="normal" placeholder="Password">
                  </div>
                  <input type="submit" class="b-button normal" value="SIGN IN">
               </form>
                  </div>
        </div>
    </div>
  
    </main>