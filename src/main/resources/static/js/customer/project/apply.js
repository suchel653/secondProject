window.addEventListener("load",function(){
	const applyBtn = document.querySelector(".apply-btn");
	const id = document.querySelector(".projectId").value;
	
	
	let left = Math.floor(window.innerWidth/3);
	let top = Math.floor(window.innerHeight/6);

	let popup;
	
	applyBtn.addEventListener("click",(e)=>{
		e.preventDefault();
		if(e.target.classList.contains(applyBtn))
				return;
		popup = open("/customer/project/apply/"+id,"_blank",`left=${left}px,top=${top}px,width=500px,height=400px`);
		
	});
	
	
});

