window.addEventListener("load", (e) => {

	let projectId = document.querySelector(".projectId").value;
	let writerId = document.querySelector(".writerId").value;



	let regBtn = document.querySelector(".reg-btn");
	let cancelBtn = document.querySelector(".cancel-btn");

	regBtn.addEventListener("click", (e) => {
		let title = document.querySelector(".title").value;
		let content = document.querySelector(".content").value;
		let board = {
			projectId,
			writerId,
			title,
			content
		};
		fetch(`/api/projectBoardController/reg`,
			{
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				/*data: JSON.stringify(board),*/
				body: JSON.stringify(board)
			})
			.then(() => {
				opener.window.location.reload();
				self.close();
			});
	})

	cancelBtn.addEventListener("click", (e) => {
		opener.window.location.reload();
		self.close();
	})
});