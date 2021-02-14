window.addEventListener("load", function(){
	let container = document.querySelector(".container");
	let memberId = document.querySelector(".member-id");
	let mypage = document.querySelector(".mypage");
	
	if(memberId.value==null || memberId.value=="" || memberId.value == 0){
		if(mypage.value == 1){
				let div = `
					<div class="profile-reg">
						<span>프로필이 아직 없으시네요<br>프로필을 생성해주세요</span><br>
						<button>생성하기</button>
					</div>`;
				container.insertAdjacentHTML('afterEnd',div);
				
			let regProfile = container.nextElementSibling.lastElementChild;
			
			regProfile.addEventListener("click", (e)=>{
				fetch(`/customer/profile/reg`,{
				method: "POST"
			})
			.then(()=>{
				window.location.reload();
			});
			})
		}
			
	}else{
		
		let img = document.querySelector(".profile-img");
		let nickname = document.querySelector(".nickname");
		let menu = document.querySelector(".menu-bar");
		let detail = document.querySelector(".detail");
		let detailList = document.querySelectorAll(".detail>div");
		let introContent = document.querySelector(".intro-introduce>.content");
		let hangoutContent = document.querySelector(".intro-hangout>.content");
		let nick = nickname.firstElementChild.innerHTML;
		
		let languagePlus = document.querySelectorAll(".language-plus");
		let languageMinus = document.querySelectorAll(".language-minus");
		let languageLevelBar = document.querySelectorAll(".language-level-bar")
		
		let skillPlus = document.querySelectorAll(".skill-plus");
		let skillMinus = document.querySelectorAll(".skill-minus");
		let skillLevelBar = document.querySelectorAll(".skill-level-bar");
		
		if(mypage.value == 1){
			let div = `<input value="${nick}" class="nickname-input">`;
				nickname.insertAdjacentHTML('beforeEnd',div);
				
			let div2 = `<div id="submit">save<i class="fas fa-save"></i></div>`;
				detail.insertAdjacentHTML("afterEnd", div2);
			
			let div3 = `<div>집 주소 등록하기</div>
						<div>깃 주소 등록하기</div>`;
				hangoutContent.insertAdjacentHTML("afterBegin", div3);
			
			hangoutContent.firstElementChild.addEventListener("click", (e)=>{
				
			})
				
			introContent.addEventListener("click", (e)=>{
				let introContentText = introContent.innerHTML;
				let introContentTextTrim = introContentText.trim();	
				console.log(introContentText);	
				let div = `<textarea>${introContentTextTrim}</textarea>`;
					introContent.insertAdjacentHTML('afterBegin',div);
		
			},{once: true})
		
			for(let i=0; i<languageMinus.length; i++){
				languageMinus[i].addEventListener("click", (e)=>{
					languageMinus[i].previousElementSibling.value--;
					if(languageMinus[i].previousElementSibling.value < 0)
						languageMinus[i].previousElementSibling.value = 0;
						
					let levelLange = Number(languageMinus[i].previousElementSibling.value);
					for(let j=i*3; j<i*3+3; j++)
						languageLevelBar[j].classList.remove("level-bright");
						
					for(let k=i*3; k<i*3+levelLange; k++)
						languageLevelBar[k].classList.add("level-bright");
						
				})
			}
			
			for(let i=0; i<languagePlus.length; i++){
				languagePlus[i].addEventListener("click", (e)=>{
					languageMinus[i].previousElementSibling.value++;
					if(languageMinus[i].previousElementSibling.value > 3)
						languageMinus[i].previousElementSibling.value = 3;
						
					let levelLange = Number(languageMinus[i].previousElementSibling.value);	
					for(let j=i*3; j<i*3+3; j++)
						languageLevelBar[j].classList.remove("level-bright");
						
					for(let k=i*3; k<i*3+levelLange; k++)
						languageLevelBar[k].classList.add("level-bright");
				})
			}
			
			for(let i=0; i<skillMinus.length; i++){
				skillMinus[i].addEventListener("click", (e)=>{
					skillMinus[i].previousElementSibling.value--;
					if(skillMinus[i].previousElementSibling.value < 0)
						skillMinus[i].previousElementSibling.value = 0;
						
					let levelLange = Number(skillMinus[i].previousElementSibling.value);
					for(let j=i*3; j<i*3+3; j++)
						skillLevelBar[j].classList.remove("level-bright");
						
					for(let k=i*3; k<i*3+levelLange; k++)
						skillLevelBar[k].classList.add("level-bright");
						
				})
			}
			
			for(let i=0; i<skillPlus.length; i++){
				skillPlus[i].addEventListener("click", (e)=>{
					skillMinus[i].previousElementSibling.value++;
					if(skillMinus[i].previousElementSibling.value > 3)
						skillMinus[i].previousElementSibling.value = 3;
						
					let levelLange = Number(skillMinus[i].previousElementSibling.value);	
					for(let j=i*3; j<i*3+3; j++)
						skillLevelBar[j].classList.remove("level-bright");
						
					for(let k=i*3; k<i*3+levelLange; k++)
						skillLevelBar[k].classList.add("level-bright");
				})
			}		
		}
		nickname.addEventListener("blur", (e)=>{
			
		})
		
		menu.addEventListener("click", (e)=>{
			let selectMenu = document.getElementsByClassName(e.target.className);
			for(let i = 0; i<detailList.length; i++)
				detailList[i].classList.remove("selected");
			selectMenu[1].classList.add("selected");
		})
		
		
		/*----------------------------------------------------------*/
		let languageValue = document.querySelectorAll(".language-level");		
		for(let i=0; i<languageMinus.length; i++){
			let levelLange = Number(languageValue[i].value);
			for(let j=i*3; j<i*3+levelLange; j++)
				languageLevelBar[j].classList.add("level-bright");
		}
		
		
		/*----------------------------------------------------------*/
		let skillValue = document.querySelectorAll(".skill-level");		
		for(let i=0; i<skillMinus.length; i++){
			let levelLange = Number(skillValue[i].value);
			for(let j=i*3; j<i*3+levelLange; j++)
				skillLevelBar[j].classList.add("level-bright");
		}
		
		
		/*----------------------------------------------------------*/
		let submitButton = detail.nextElementSibling;
		submitButton.addEventListener("click", (e)=>{
			let introduce = introContent.firstElementChild.value;
				if(introduce == null || introduce == "")
					introduce = "이곳에 자기 소개글을 넣어주세요";
			let languageValue = document.querySelectorAll(".language-level");
			let languageLevel = [];
			
			let skillValue = document.querySelectorAll(".skill-level");
			let skillLevel = [];
			
			
			let nicknameValue = nickname.lastElementChild.value;
			
			for(let i=0; i<languageValue.length; i++)
				languageLevel.push(languageValue[i].value);
			for(let i=0; i<skillValue.length; i++)
				skillLevel.push(skillValue[i].value);
				
			
			
			let data = {
				introduce,
				nicknameValue,
				languageLevel,
				skillLevel
				
			}
			
			fetch(`/customer/profile/update`,
			{
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				body: JSON.stringify(data)
			})
			
			alert("저장이 완료되었습니다.");
			window.location.reload();
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