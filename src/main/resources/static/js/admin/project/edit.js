window.addEventListener("load",function(){
	const section = document.querySelector(".edit-section");
	const fileContainer = section.querySelector(".file-container");
	const delBtn = section.querySelector(".x-btn");
	
	fileContainer.addEventListener('click',(e)=>{
		console.log(e.target.classList.contains('x-btn'));
		if(!e.target.classList.contains(delBtn)){
		console.log(e.target);
		e.target.parentNode.remove();
		}
	});
	
});