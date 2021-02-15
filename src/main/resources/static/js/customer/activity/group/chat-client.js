window.addEventListener("load",(e)=>{
	const section = document.querySelector(".chat");
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
		let myMsg = "black";
		
		if(username === nickname.value)
			myMsg = "blue";
			
		let src = `/images/profileImg/${id}/${img}`;
		
		if(img == "profileBasic.png")
			src = `/images/profileImg/${img}`;
			
		
		
		let chatItemTemplate = `<div>
									<img src="${src}" />
									<span style="color:${myMsg}">${username} : </span>
									<span style="color:${myMsg}">${chatData}</span>	
									<span>${time}</span>	
								</div>`;
		
		section.insertAdjacentHTML("beforeend",chatItemTemplate);
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