window.addEventListener("load",function(){
	const applyBtn = document.querySelector(".apply-btn");
	const id = document.querySelector(".projectId").value;
	
	
	let left = Math.ceil(window.innerWidth/3);
	let top = Math.ceil(window.innerHeight/2);

	let popup;
	
	applyBtn.addEventListener("click",(e)=>{
		e.preventDefault();
		if(e.target.classList.contains(applyBtn))
				return;
				
		popup = open("/customer/project/apply/"+id,"_blank",`left=${left}px,top=${top}px,width=500px,height=500px`);
		
	});
	
	
});

