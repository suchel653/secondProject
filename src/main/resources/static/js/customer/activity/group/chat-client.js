window.addEventListener("load",(e)=>{
	const section = document.querySelector(".chatbox");
	const chatWindow = document.querySelector(".chat-window")
	const chatInput = section.querySelector(".chat-input");
	const sendButton = section.querySelector(".send-btn");
	const nickname = section.querySelector(".nickname");
	const chatId = section.querySelector(".chat-id").value;
	const type = section.querySelector(".type").value;
	const img = section.querySelector(".img").value;
	const id = section.querySelector(".id").value;
	console.log(id);
	let username = nickname.value;
	let message = {
		id,
		img,
		type,
		chatId,
		username,
		chatData:"",
		time:""
	};
	let socket;
	
	if(socket == undefined)
		socket = new WebSocket(`ws://localhost:8080/chat/${type}/${chatId}`);
		
	socket.addEventListener('open',(e)=>{

	});
	
	socket.addEventListener('message',(e)=>{
		
		let message = JSON.parse(e.data);
		let {id,img,type,chatId,username,chatData,time} = message;
		let myMsg ="Msg";

	
		if(username === nickname.value)
			myMsg = "myMsg";
			
		let src = `/images/profileImg/${id}/${img}`;
		
		if(img == "profileBasic.png")
			src = `/images/profileImg/${img}`;
			
		
		
		let chatItemTemplate = `	
									<div class="msg-box ${myMsg}">
									
									<img class="user-img" src="${src}" />
									<span class="username">${username}</span>
									
									
									<span class="msg">:${chatData}
									</span>	
									
									
									<span class="timestamp">${time}</span>	
								
								</div>`;
		
		chatWindow.insertAdjacentHTML("beforeend",chatItemTemplate);
	});
	
	sendButton.addEventListener("click",(e)=>{
		let today = new Date();
		let hour = today.getHours();
		let minutes = today.getMinutes();
		
		if(minutes<10)
			minutes = "0"+minutes
		
		let time = "오전"+hour + ":" + minutes;
		if(hour>12){
			hour = hour-12;
			time = "오후"+hour + ":" + minutes;
		}
		let message ={
					id,
					img,
					type,
					chatId,
					username,
					chatData:chatInput.value,
					time
				};
		chatInput.value="";
		if(socket != undefined)
			socket.send(JSON.stringify(message));
	});
});