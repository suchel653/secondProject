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
		let addressContent = document.querySelector(".intro-hangout>.content>.address");
		let gitContent = document.querySelector(".intro-hangout>.content>.git")
		let nick = nickname.firstElementChild.innerHTML;

		let languagePlus = document.querySelectorAll(".language-plus");
		let languageMinus = document.querySelectorAll(".language-minus");
		let languageLevelBar = document.querySelectorAll(".language-level-bar")
		
		let skillPlus = document.querySelectorAll(".skill-plus");
		let skillMinus = document.querySelectorAll(".skill-minus");
		let skillLevelBar = document.querySelectorAll(".skill-level-bar");
		
		let introContentReg = 0;
		let address;
		let git;
		if(mypage.value == 1){
			let div = `<input value="${nick}" class="nickname-input">`;
				nickname.insertAdjacentHTML('beforeEnd',div);
				
			let div2 = `<div id="submit">save<i class="fas fa-save"></i></div>`;
				detail.insertAdjacentHTML("afterEnd", div2);
			addressValue = addressContent.innerHTML.trim();
			
				let addressClick = 0;
				addressContent.firstElementChild.addEventListener("click", (e)=>{
					let div4 = `<div class="reg">주소:
									<select class="metro">
										<option value="서울특별시">서울특별시</option>
										<option value="경기도">경기도</option>
										<option value="인천광역시">인천광역시</option>
										<option value="강원도">강원도</option>
										<option value="충청남도">충청남도</option>
										<option value="충청북도">충청북도</option>
										<option value="대전광역시">대전광역시</option>
										<option value="전라북도">전라북도</option>
										<option value="전라남도">전라남도</option>
										<option value="광주광역시">광주광역시</option>
										<option value="경상북도">경상북도</option>
										<option value="경상남도">경상남도</option>
										<option value="울산광역시">울산광역시</option>
										<option value="대구광역시">대구광역시</option>
										<option value="부산광역시">부산광역시</option>
										<option value="제주도">제주도</option>
									</select>
									<input type="text" class="local" placeholder="시/군/구 까지만">
									<button>입력</button>
								</div>`;
					if(addressClick == 0){
						addressContent.firstElementChild.insertAdjacentHTML('afterEnd',div4);
						addressClick++;	
						
						let regAddress = addressContent.firstElementChild.nextElementSibling;
				
						
						regAddress.lastElementChild.addEventListener("click", (e)=>{
							let metro = regAddress.firstElementChild.value;
							let detail = regAddress.firstElementChild.nextElementSibling.value;
							address = metro + " " + detail;
							
							div5 = `<div class="address">${address}</div>`
							addressContent.insertAdjacentHTML('afterBegin',div5);
							addressContent.removeChild(addressContent.firstElementChild.nextElementSibling.nextElementSibling);
							addressContent.removeChild(addressContent.firstElementChild.nextElementSibling);
						})
					}else{
						addressContent.removeChild(addressContent.firstElementChild.nextElementSibling);
						addressClick--;
					}
				
				})
			
			
				
			
				
			gitValue = gitContent.firstElementChild.innerHTML.trim();
				let alreadyGit = 1;
				if (gitValue == "깃 주소 등록하기") {
					alreadyGit = 0;
				}
				let gitClick = 0;
				let sendButton;
				gitContent.firstElementChild.addEventListener("click", (e) => {
					let div4 = `<div class="reg">깃 프로필 주소
									<input type="text" class="gitAdress" value="https://github.com/">
									<button>입력</button>
								</div>`;
					if (gitClick == 0) {
						gitContent.firstElementChild.insertAdjacentHTML('afterEnd', div4);
						gitClick++;

						sendButton = gitContent.lastElementChild.lastElementChild;
						
						if(alreadyGit == 1){
								sendButton = gitContent.lastElementChild.previousElementSibling.lastElementChild;
						}
						console.log(sendButton);
						console.log(alreadyGit);
						sendButton.addEventListener("click", (e) => {

							if(alreadyGit == 1){
								git = gitContent.lastElementChild.previousElementSibling.firstElementChild.value;
							
								gitContent.removeChild(gitContent.firstElementChild);
							}else{
								git = gitContent.lastElementChild.firstElementChild.value;
							}
							
							

							div5 = `<div>${git}</div>
									<div class="gitLink">바로가기</div>`
							gitContent.insertAdjacentHTML('afterBegin', div5);
							gitContent.removeChild(gitContent.lastElementChild.previousElementSibling);
							gitContent.removeChild(gitContent.lastElementChild);
							
							
							
							
							
						})
					} else {
						gitContent.removeChild(gitContent.firstElementChild.nextElementSibling);
						gitClick--;
					}

				})
				
			introContent.addEventListener("click", (e)=>{
				let introContentText = introContent.innerHTML;
				let introContentTextTrim = introContentText.trim();	
				console.log(introContentText);	
				let div = `<textarea>${introContentTextTrim}</textarea>`;
					introContent.insertAdjacentHTML('afterBegin',div);
				
				introContentReg = 1;
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
		let edit = document.querySelectorAll(".edit");
		
		if(gitContent.lastElementChild != edit[1]){
			
			gitContent.lastElementChild.addEventListener("click", (e)=>{
				win = open(gitContent.firstElementChild.innerHTML, "_blank", "width=900px,height=500px,top=200,left=400");
			})
		}	
		
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
			let introduce;
			if(introContentReg == 0){
				introduce = introContent.innerHTML;
			}else{
				introduce = introContent.firstElementChild.value;	
			}
			if(introduce == null || introduce == "")
				introduce = "이곳에 자기 소개글을 넣어주세요";
				
			if(addressContent.firstElementChild != null)
				address = addressContent.firstElementChild.innerHTML;
			if(address== "집 주소 등록하기")	
				address = null;
			if(gitContent.firstElementChild != null)
				repositoryLink = gitContent.firstElementChild.innerHTML;	
			if(repositoryLink== "깃 주소 등록하기")	
				repositoryLink = null;
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
				skillLevel,
				address,
				repositoryLink
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