window.addEventListener("load", function(){
	let container = document.querySelector(".container");
	let memberId = document.querySelector(".member-id");
	console.log(memberId.value);
	if(memberId.value==null || memberId.value==""){
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
		let languagePlus = document.querySelectorAll(".fa-plus-circle");
		let languageMinus = document.querySelectorAll(".fa-minus-circle");
		
		
		let submitButton = document.querySelector("#submit")
		
		menu.addEventListener("click", (e)=>{
			let selectMenu = document.getElementsByClassName(e.target.className);
			for(let i = 0; i<detailList.length; i++)
				detailList[i].classList.remove("selected");
			selectMenu[1].classList.add("selected");
		})
		
		content.addEventListener("click", (e)=>{
			let div = `
					<textarea>123123</textarea>`;
				content.insertAdjacentHTML('afterBegin',div);
		},{once: true})

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
		
		submitButton.addEventListener("click", (e)=>{
			let languageValue = document.querySelectorAll(".language-level");
			let languageLevel = [];
			
			for(let i=0; i<languageValue.length; i++)
				languageLevel.push(languageValue[i].value);
			
			
			let data = {
				
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