window.addEventListener("load", (e) => {

	const info = document.querySelector(".info");
	let tbody = document.querySelector(".tbody");

	let win;

	info.addEventListener("click", (e) => {

		let id = e.target.previousElementSibling.value;

		win = open("/customer/activity/group/project/" + id + "/info", "_blank", "width=500px,height=500px");

	});

	tbody.addEventListener("click", (e) => {

		e.preventDefault();
		
		console.log(e.target.value);
		let action = e.target.value;
		console.log(e.target.previousElementSibling.value);
		let id = e.target.previousElementSibling.value;
		console.log(e.target.previousElementSibling.previousElementSibling.value);
		let studyId = e.target.previousElementSibling.previousElementSibling.value;
		
		fetch(`/customer/activity/group/project/${studyId}/approve?action=${action}&id=${id}`
		, { method: "POST" })
		.then(window.location.reload());

	});

});