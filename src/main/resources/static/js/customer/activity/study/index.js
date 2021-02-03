window.addEventListener("load", (e) => {
	
	const info = document.querySelector(".info");
	const applyBtn = document.querySelector(".apply-Btn");

	//console.log(e.target);

	let win;

	info.addEventListener("click", (e) => {

		let id = e.target.previousElementSibling.value;
		//console.log(id);

		win = open("/customer/activity/group/study/" + id + "/info", "_blank", "width=500px,height=500px");

	});
	
	applyBtn.addEventListener("click", (e) => {
		console.log("apply");
	});

});