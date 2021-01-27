window.addEventListener("load",function(){
	const memberList = document.querySelector(".member-list");
	
	let win;
	
	memberList.addEventListener("click",(e)=>{
		e.preventDefault();
		if(!e.target.classList.contains("detail"))
			return;
			
		console.log(e.target.tagName);	
		
		let id = e.target.parentElement.previousElementSibling.innerText;
		console.log(id);
		
		win = open("/admin/member/"+id,"_blank","width = 800px, height = 700px");
		
	});
});