window.addEventListener("load", (e) => {
	
	const info = document.querySelector(".info");

	let win;

	info.addEventListener("click", (e) => {

		let id = e.target.previousElementSibling.value;

		win = open("/customer/activity/group/project/" + id + "/info", "_blank", "width=500px,height=500px");

	});

});