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
			container.insertAdjacentHTML('beforeEnd',div);
			
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
	let test = document.querySelectorAll(".detail>div");
	
	
	menu.addEventListener("click", (e)=>{
		let selectMenu = document.getElementsByClassName(e.target.className);
		selectMenu.className += "selected";
	})

	
	}});




/*



let profile = document.querySelector(".profile-content");
	let button = profile.querySelector(".test");
	
	button.addEventListener("click", (e)=>{
		fetch(`/customer/profile/reg`,{
			method: "POST"
		});
	})*/