window.addEventListener("load",function(){
	const groupPage = document.querySelector(".group-page");
	
	let win;
	
	groupPage.addEventListener("click",(e)=>{
		e.preventDefault();
		console.log(e.tagName);
		e.stopPropagation();
		
		
	
		
		win = open("group/study/3/index","_blank","width = 900px, height = 700px");
		
	});
});