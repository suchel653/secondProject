window.addEventListener("load", function() {
	let reg = document.querySelector("#reg");
	let email = reg.querySelector("#email");
	let emailButton = email.querySelector("input[type=button]");
	let address = email.querySelector("input[type=text]")


	emailButton.onclick = function(e) {
		/*e.preventDefault();
		let mail = address.value;
		fetch("checkMail", {
			method: "POST",
			body: JSON.stringify({ "email": mail })
			
		})*/
	
		
		
		e.preventDefault();
		let mail = address.value;
		console.log(mail);
		fetch("checkMail?email="+mail, {
			method: "POST"
		})
		/*let request = new XMLHttpRequest();
      request.open("POST","checkMail?email="+address.value);
      request.send();*/
	}
})