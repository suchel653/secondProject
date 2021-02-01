window.addEventListener("load", function() {
	let reg = document.querySelector("#reg");
	let email = reg.querySelector("#email");
	let emailButton = email.querySelector("input[type=button]");
	let address = email.querySelector("input[type=text]")
	let confirm = reg.querySelector("#confirm");
	let confirmButton = confirm.querySelector("input[type=button]");
	let confirmKey = confirm.querySelector("input[type=text]");
	let nickname = reg.querySelector("#nickname");
	let nicknameKey = nickname.querySelector("input[type=text]");
	let nicknameButton = nickname.querySelector("input[type=button]");
	let password = reg.querySelector("#password");
	let submitButton = reg.querySelector("input[type=submit]");
	let emailKey;
	
	let check1 = false;
	let check2 = false;
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
			return response.json();
		})
		.then((data)=>{
			emailKey = data.key;
		})
		
		/*let request = new XMLHttpRequest();
      request.open("POST","checkMail?email="+address.value);
      request.send();*/
	}
	
	confirmButton.onclick = function(){
		if(confirmKey.value == emailKey){
			alert("인증번호가 일치합니다.");
			check1 = true;
		}else{
			alert("인증번호가 일치하지 않습니다. 다시 확인해주세요");
		}
	}
	
	nicknameButton.onclick = function(){
		fetch("checkDuplicate?checkKey="+nicknameKey.value, {
			method: "POST"
		})
		.then((response)=>{
			return response.json();
		})
		.then((data)=>{
			let result = data.checkResult;
			
			if(result == 0){
				alert("사용하실 수 있는 닉네임입니다.");
				check2 = true;
			}else{
				alert("중복");
			}
		})
	}
	
	submitButton.onclick = function submitCheck(){
		if(check1 && check2 && password.value != ""){
			return true;
		}else{
			alert("이메일 인증 혹은 닉네임이 중복됩니다.");
			return false;
		}
	}
})