window.addEventListener("load", function() {
	let profile = document.querySelector(".profile");
	profile.addEventListener("click",(e)=>{
		if(profile.nextElementSibling!= null)
			profile.nextElementSibling.remove();
		else{
			let div = `
				<div class="detail-menu">
					<div><a href="/customer/">마이페이지</a></div>
					<div><a href="/customer/activity/index">나의 활동</a></div>
					<div><a href="/customer/logout">로그아웃</a></div>
				</div>`;
			profile.insertAdjacentHTML('afterEnd',div);
		}
	})
})