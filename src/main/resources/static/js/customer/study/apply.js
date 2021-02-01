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
/*	window.addEventListener("load",function(){
		const apply= document.querySelector(".applyBtn");
	
	apply.addEventListener("click",(e)=>{
		e.preventDefault();
		let comment = document.querySelector(".comment").value;
		let id = document.querySelector(".id").value;
		fetch("/customer/study/apply/"+id+"?comment="+comment,{
			method:"POST"
		})
		.then(()=>{
			window.close();
		});
	});
	
	
	
});
	*/
	window.addEventListener("load",function(){
		const check= document.querySelector(".applyBtn");
		check=false;
	check.addEventListener("click",(e)=>{
		e.preventDefault();
		let comment = document.querySelector(".comment").value;
		let id = document.querySelector(".id").value;
		
		fetch("/customer/study/apply/"+id+"?comment="+comment,{
			method:"POST"
		})
		.then((response)=>{
			return response.json();
		})
		.then((data)=>{
			let result = data.checkResult;
			if(result ==0){
				check =true;
				alert("지원되었습니다.");
			}
			else{
				alert("중복지원이불가능합니다");
			}
		})
		.then(()=>{
			window.close();
		})
	});
	
	
});
	
	

