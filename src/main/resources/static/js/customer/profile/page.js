window.addEventListener("load", function(){
	let container = document.querySelector(".container");
	let memberId = document.querySelector(".member-id");
	let mypage = document.querySelector(".mypage");
	
	if(memberId.value==null || memberId.value=="" || memberId.value == 0){
		let div = `
				<div class="profile-reg">
					<span>프로필이 아직 없으시네요 프로필을 생성해주세요</span>
					<button>생성</button>
				</div>`;
			container.insertAdjacentHTML('beforeBegin',div);
			
		let regProfile = container.previousElementSibling.lastElementChild;
		
		regProfile.addEventListener("click", (e)=>{
			fetch(`/customer/profile/reg`,{
			method: "POST"
		})
		.then(window.location.reload());
		})
	}else{
		
		let img = document.querySelector(".profile-img");
		let nickname = document.querySelector(".nickname");
		let menu = document.querySelector(".menu-bar");
		let detail = document.querySelector(".detail");
		let detailList = document.querySelectorAll(".detail>div");
		let content = document.querySelector(".content");
		let languagePlus = document.querySelectorAll(".language-plus");
		let languageMinus = document.querySelectorAll(".language-minus");
		let nick = nickname.firstElementChild.innerHTML;
		
		if(mypage.value == 1){
			let div = `<input value="${nick}" class="nickname-input">`;
				nickname.insertAdjacentHTML('beforeEnd',div);
				
			let div2 = `<input type="button" value="save" id="submit">`;
				detail.insertAdjacentHTML("AfterEnd", div2);
			
			content.addEventListener("click", (e)=>{
				let contentText = content.firstElementChild.innerHTML;		
				let div = `
						<textarea>${contentText}</textarea>`;
					content.insertAdjacentHTML('afterBegin',div);
		
			},{once: true})
		
		}
		
		nickname.addEventListener("blur", (e)=>{
			
		})
		
		menu.addEventListener("click", (e)=>{
			let selectMenu = document.getElementsByClassName(e.target.className);
			for(let i = 0; i<detailList.length; i++)
				detailList[i].classList.remove("selected");
			selectMenu[1].classList.add("selected");
		})

		for(let i=0; i<languageMinus.length; i++){
			languageMinus[i].addEventListener("click", (e)=>{
				languageMinus[i].previousElementSibling.value--;
				if(languageMinus[i].previousElementSibling.value < 0)
					languageMinus[i].previousElementSibling.value = 0;

			})
		}
		
		for(let i=0; i<languagePlus.length; i++){
			languagePlus[i].addEventListener("click", (e)=>{
				languageMinus[i].previousElementSibling.value++;
				if(languageMinus[i].previousElementSibling.value > 3)
					languageMinus[i].previousElementSibling.value = 3;
			})
		}
		
		let submitButton = detail.nextElementSibling;
		submitButton.addEventListener("click", (e)=>{
			let introduce = content.firstElementChild.value;
			if(introduce == undefined)
				introduce = content.firstElementChild.innerHTML;
			let languageValue = document.querySelectorAll(".language-level");
			let languageLevel = [];
			let nicknameValue = nickname.lastElementChild.value;
			
			for(let i=0; i<languageValue.length; i++)
				languageLevel.push(languageValue[i].value);
			
			
			let data = {
				introduce,
				nicknameValue,
				languageLevel
				
			}
			
			fetch(`/customer/profile/update`,
			{
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(data)
			})
			
			alert("123");
		})
		
	}
});




/*



let profile = document.querySelector(".profile-content");
	let button = profile.querySelector(".test");
	
	button.addEventListener("click", (e)=>{
		fetch(`/customer/profile/reg`,{
			method: "POST"
		});
	})*/