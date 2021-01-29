window.addEventListener("load",function(){
	const applyBtn = document.querySelector(".apply-btn");
	const cid = document.querySelector(".id");
	
	
	let win;
	
	applyBtn.addEventListener("click",(e)=>{
		e.preventDefault();
		if(e.target.classList.contains(".apply-btn"))
				return;
				
				let id = cid.value;
				console.log(id);
		win = open("/customer/project/apply/"+id,"_blank","width=500px,height=500px");
		
	});
	
});

