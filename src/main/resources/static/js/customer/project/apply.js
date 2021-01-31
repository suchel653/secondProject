window.addEventListener("load",function(){
	const applyBtn = document.querySelector(".apply-btn");
	const pId = document.querySelector(".projectId");
	
	let left = Math.ceil(window.innerWidth/2);
	let top = Math.ceil(window.innerHeight/4);

	let popup;
	let id;
	
	applyBtn.addEventListener("click",(e)=>{
		e.preventDefault();
		if(e.target.classList.contains(applyBtn))
				return;
				
				id = pId.value;
				
		popup = open("/customer/project/apply/"+id,"_blank",`left=${left}px,top=${top}px,width=500px,height=500px`);
		
	});
	
});

