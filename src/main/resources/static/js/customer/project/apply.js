window.addEventListener("load",function(){
	const applyBtn = document.querySelector(".apply-btn");
	const pId = document.querySelector(".projectId");
	let commentValue = document.querySelector(".opener-comment").value;
	
	let popup;
	let id;
	
	applyBtn.addEventListener("click",(e)=>{
		e.preventDefault();
		if(e.target.classList.contains(applyBtn))
				return;
				
				id = pId.value;
				console.log(id);
				
		popup = open("/customer/project/apply/"+id,"_blank","width=500px,height=100px");


		/*setTimeout(()=>{
			if(typeof(popup)=='undefined' || popup.closed) 
			console.log("closed");
		},500);*/
		
	});
	
});

