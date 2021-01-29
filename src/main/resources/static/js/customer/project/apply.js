window.addEventListener("load",function(){
	const applyBtn = document.querySelector(".apply-btn");
	const pId = document.querySelector(".projectId");
	const apply = document.querySelector(".submit");
	
	
	let win;
	
	applyBtn.addEventListener("click",(e)=>{
		e.preventDefault();
		if(e.target.classList.contains(applyBtn))
				return;
				
				let id = pId.value;
				console.log(id);
		win = open("/customer/project/apply/"+id,"_blank","width=500px,height=500px");
		
	});
	
});

