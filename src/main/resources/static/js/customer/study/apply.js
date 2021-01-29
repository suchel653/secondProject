window.addEventListener("load",function(){
	const apply = document.querySelector(".btn");
	
	
	let win;
	
	apply.addEventListener("click",(e)=>{
		e.preventDefault();
		if(!e.target.classList.contains("apply"))
				return;
		let id = e.target.previousElementSibling.value;
		console.log(id);
		
		win=open("/customer/study/apply/"+id,"_blank","width=500px,height=500px");
	});
	
	

	
	
});

