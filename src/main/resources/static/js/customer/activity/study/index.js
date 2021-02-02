window.addEventListener("load",function(){
	const info = document.querySelector(".info");
	
	let win;
	let id = e.target.previousElementSibling.value;
	
	info.addEventListener("click",(e)=>{
		
		//e.preventDefault();
		console.log(id);
		
		win=open("/customer/activity/group/study/"+id+"/info","_blank","width=500px,height=500px");
			
	});
	
});