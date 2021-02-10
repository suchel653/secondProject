<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="/js/chat-client.js"></script>    
    
<main id="main" class="main">

	<div class="chat" style="width:300px;height:300px;background:white">
  		<input class="nickname" type="hidden" value="${nickname}" >
  		<input class="chat-id" type="hidden" value="${room.id}" >
   		<input class="chat-input" autofocus="autofocus" type = "text" id = "message" style = "height : 30px; width : 340px" placeholder="내용을 입력하세요" autofocus>
		<button class = "send-btn" id = "send">전송</button>
		<a href="list">목록</a>
	</div>
</main>