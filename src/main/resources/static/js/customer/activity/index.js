window.addEventListener("load",function(){
	const groupPage = document.querySelectorAll(".group-page");
	console.log(groupPage);
	let win;
	
	for(let i=0; i<groupPage.length; i++){
		groupPage[i].addEventListener("click",(e)=>{
			e.preventDefault();
			console.log(e.currentTarget.href);
			let hr = e.currentTarget.href.split("/");
			let kind = hr[6];
			id = parseInt(hr[7]);
			win = open(`group/${kind}/${id}/index`,"_blank","width = 1500px, height = 900px");
		
	});
	}
	
});