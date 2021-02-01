
window.addEventListener("load",function(){

	const groupPage = document.querySelectorAll(".group-page");
	console.log(groupPage);
	let win;

	
/*	for(let i=0; i<groupPage.length; i++){
		groupPage[i].addEventListener("click",(e)=>{
			e.preventDefault();
			console.log(e.currentTarget.href);
			let hr = e.currentTarget.href.split("/");
			let kind = hr[6];
			id = parseInt(hr[7]);
			win = open(`group/${kind}/${id}/index`,"_blank","width = 1500px, height = 900px");
		
	});
	}*/
	


	for (let i = 0; i < groupPage.length; i++) {
		groupPage[i].addEventListener("click", (e) => {
			e.preventDefault();
			console.log(e.currentTarget.href);
			let hr = e.currentTarget.href.split("/");
			let kind = hr[6];
			id = parseInt(hr[7]);
			let w = 1500;
			let h = 900;
			var xPos = (document.body.offsetWidth / 2) - (w / 2); // 가운데 정렬
			//xPos += window.screenLeft; // 듀얼 모니터일 때
			var yPos = (document.body.offsetHeight / 2) - (h / 2);
			win = open(`group/${kind}/${id}/index`, "_blank", "width=" + w + "+px, height=" + h + "+px, left=" + xPos + ", top=" + yPos + ", menubar=yes, status=yes, titlebar=yes, resizable=yes");

		});
	}


});