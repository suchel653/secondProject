window.addEventListener("load",(e)=>{
	const section = document.querySelector(".chat");
	const chatInput = section.querySelector(".chat-input");
	const sendButton = section.querySelector(".send-btn");
	const nickname = section.querySelector(".nickname");
	const chatId = section.querySelector(".chat-id").value;
	
	let username = nickname.value;
	let message = {
		chatId,
		username,
		chatData:""
	};
	let socket;
	
	if(socket == undefined)
		socket = new WebSocket(`ws://localhost:8080/study/${chatId}/chat`);
		
		
	socket.addEventListener('open',(e)=>{

	});
	
	socket.addEventListener('message',(e)=>{
			let message = JSON.parse(e.data);
			let {chatId,username,chatData} = message;
			let myMsg = "black";
			if(username === nickname.value)
				myMsg = "blue";
			let chatItemTemplate = `<div>
										<span style="color:${myMsg}">${username} : </span>
										<span style="color:${myMsg}">${chatData}</span>		
									</div>`;
			
			section.insertAdjacentHTML("beforeend",chatItemTemplate);
		});
	
	sendButton.addEventListener("click",(e)=>{
		let message ={
					chatId,
					username,
					chatData:chatInput.value
				};
		chatInput.value="";
		if(socket != undefined)
			socket.send(JSON.stringify(message));
	});
});