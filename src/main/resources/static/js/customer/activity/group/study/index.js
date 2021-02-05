window.addEventListener("load", (e) => {

	let info = document.querySelector(".info");
	let tbody = document.querySelector(".tbody");
	let pageStatus = document.querySelector(".pageStatus");
	let win;

	let applyBtn = document.querySelector(".apply-Btn");
	let table = document.querySelector(".table")
	let clicked;

	if (pageStatus.value == 0) {
		table.style.display = "none";
		clicked = false;
	} else {
		table.style.display = "block";
		clicked = true;
	}

	info.addEventListener("click", (e) => {

		let id = e.target.previousElementSibling.value;

		win = open("/customer/activity/group/study/" + id + "/info", "_blank", "width=500px,height=500px");

	});

	tbody.addEventListener("click", (e) => {

		e.preventDefault();

		if (e.target.tagName == "INPUT") {
			let action = e.target.value;
			let memberId = e.target.previousElementSibling.value;
			let studyId = e.target.previousElementSibling.previousElementSibling.value;

			pageStatus.value = 1;

			fetch(`/customer/activity/group/study/${studyId}/approve?action=${action}&memberId=${memberId}`, { method: "POST" })
			.then(window.location = `index?pageStatus=${pageStatus.value}`);
		} else if (e.target.tagName == "SPAN" && e.target.nextElementSibling.nextElementSibling.value == 0) {
			e.target.nextElementSibling.style.display = "block";
			e.target.nextElementSibling.nextElementSibling.value = 1;
		} else if (e.target.tagName == "SPAN" && e.target.nextElementSibling.nextElementSibling.value == 1) {
			e.target.nextElementSibling.style.display = "none";
			e.target.nextElementSibling.nextElementSibling.value = 0;
		}
		
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