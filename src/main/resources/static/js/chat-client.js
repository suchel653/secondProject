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
		socket = new WebSocket('ws://localhost:8080/chat');
		
	socket.addEventListener('open',(e)=>{

	});
	
	socket.addEventListener('message',(e)=>{
			let message = JSON.parse(e.data);
			let {chatId,username,chatData} = message;
			let chatItemTemplate = `<div>
										<span>${chatId}</span>
										<span>${username}</span>
										<span>${chatData}</span>		
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