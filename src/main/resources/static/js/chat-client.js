window.addEventListener("load",(e)=>{
	const section = document.querySelector(".chat-container");
	const sendButton = section.querySelector(".send-button");
	
	let username = "Su";
	let message = {
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
			let {username,chatData} = message;
			let chatItemTemplate = `<div>
										<span>profile</span>
										<span>${username}</span>
										<span>${chatData}</span>		
									</div>`;
			
			chatList.insertAdjacentHTML("beforeend",chatItemTemplate);
		});
	
	sendButton.addEventListener("click",(e)=>{
		let message ={
					username,
					chatData:chatInput.value
				};
		
		if(socket != undefined)
			socket.send(JSON.stringify(message));
	});
});