window.addEventListener("load",function(){
	const listTable = document.querySelector(".list-table");
	const detail = listTable.querySelector(".detail");
	
	let win;
	
	detail.addEventListener("click",(e)=>{
		e.preventDefault();
		
		let id = e.target.value;
		
		win = open("/admin/member/"+id+"/detail","width = 800px, height = 700px");
	});
});