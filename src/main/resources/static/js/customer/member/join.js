window.addEventListener("load", function() {
	let reg = document.querySelector("#reg");
	let email = reg.querySelector("#email");
	let emailButton = email.querySelector("input[type=button]");
	let address = email.querySelector("input[type=text]")
	let confirm = reg.querySelector("#confirm");
	let confirmButton = confirm.querySelector("input[type=button]");

	emailButton.onclick = function(e) {
		e.preventDefault();
		/*fetch("checkMail", {
			headers { "Content-Type":}
			method: "POST",
			body: JSON.stringify({ "email": mail })
			
		})
		.then((response)=>{
			return response.json();
		})
		.then((data)=>{
			console.log(data);
		})*/
		
		e.preventDefault();
		let mail = address.value;
		console.log(mail);
		fetch("checkMail?email="+mail, {
			method: "POST"
		})
		.then((response)=>{
			console.log(response);
			
		})
		
		/*let request = new XMLHttpRequest();
      request.open("POST","checkMail?email="+address.value);
      request.send();*/
	}
	
	confirmButton.onclick = function(){
		
		
	}
})