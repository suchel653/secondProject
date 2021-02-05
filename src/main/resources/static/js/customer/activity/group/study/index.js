window.addEventListener("load", (e) => {

	let info = document.querySelector(".info");
	let tbody = document.querySelector(".tbody");
	let pageStatus = document.querySelector(".pageStatus");
	let win;
	
	console.log(pageStatus.value);

	let applyBtn = document.querySelector(".apply-Btn");
	let table = document.querySelector(".table")
	let clicked = false;

	if (pageStatus.value == 0) {
		table.style.display = "none";
	} else {
		table.style.display = "block";
	}


	info.addEventListener("click", (e) => {

		let id = e.target.previousElementSibling.value;

		win = open("/customer/activity/group/study/" + id + "/info", "_blank", "width=500px,height=500px");

	});

	tbody.addEventListener("click", (e) => {

		e.preventDefault();

		console.log(e.target);
		let action = e.target.value;
		console.log(e.target.previousElementSibling.value);
		let memberId = e.target.previousElementSibling.value;
		console.log(e.target.previousElementSibling.previousElementSibling.value);
		let studyId = e.target.previousElementSibling.previousElementSibling.value;
		
		pageStatus.value = 1;

		fetch(`/customer/activity/group/study/${studyId}/approve?action=${action}&memberId=${memberId}`, { method: "POST" })
			/*.then(fetch(`/customer/activity/group/study/${studyId}/index?pageStatus=${pageStatus.value}`))*/
			.then(window.location=`index?pageStatus=${pageStatus.value}`);

	});

	applyBtn.addEventListener("click", (e) => {
		if (clicked) {
			table.style.display = "none";
			clicked = false;
		} else {
			table.style.display = "block";
			clicked = true;
		}
	});

});