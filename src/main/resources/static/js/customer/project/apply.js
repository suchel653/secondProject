window.addEventListener("load",function(){
	const applyBtn = document.querySelector(".apply-btn");
	
	
	let win;
	
	applyBtn.addEventListener("click",(e)=>{
		e.preventDefault();
		if(e.target.classList.contains(applyBtn))
				return;
				
				console.log("btn");
		win=open("/customer/project/apply/"+id,"_blank","width=500px,height=500px");
	});
	
});

