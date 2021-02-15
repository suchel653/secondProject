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
		alert("인증 번호가 발송되었습니다. 이메일 도착까지 다소 시간이 소요될 수 있습니다.")
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
			alert("회원가입이 완료되었습니다.");
			return true;
		}else if(check1 && check2){
			alert("비밀번호를 입력해주세요");
			return false;
		}else if(check1 && password.value != ""){
			alert("닉네임 중복확인을 다시 해주세요");
			return false;
		}else{
			alert("이메일 인증에 오류가 있습니다. 인증번호를 다시 확인해주세요");
			return false;
		}
	}
})