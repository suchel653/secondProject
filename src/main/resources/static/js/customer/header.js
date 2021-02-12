window.addEventListener("load", function() {
	let profile = document.querySelector(".profile");
	let id = document.querySelector(".id");
	let nickname = document.querySelector(".profile-user-name").innerHTML;
	
	profile.addEventListener("click",(e)=>{
		if(profile.nextElementSibling!= null)
			profile.nextElementSibling.remove();
		else if(nickname == "admin"){
			let div = `
				<div class="detail-menu">
					<div></div>
					<div><a href="/admin/index">어드민이시네요</a></div>
					<div><a href="/customer/logout">로그아웃</a></div>
				</div>`;
				profile.insertAdjacentHTML('afterEnd',div);
		}
		else{
			let div = `
				<div class="detail-menu">
					<div>마이페이지</div>
					<div><a href="/customer/activity/index">나의 활동</a></div>
					<div><a href="/customer/logout">로그아웃</a></div>
				</div>`;
			profile.insertAdjacentHTML('afterEnd',div);
		}
		let win;
		profilePage = profile.nextElementSibling.firstElementChild;
		profilePage.addEventListener("click", (e)=>{
			win = open("/customer/profile/" + id.value, "_blank", "width=900px,height=500px,top=200,left=400");
		})
	})
	
	
		
	
	
		
})
