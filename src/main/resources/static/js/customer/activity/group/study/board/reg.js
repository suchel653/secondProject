window.addEventListener("load", (e) => {

	let studyId = document.querySelector(".studyId").value;
	let writerId = document.querySelector(".writerId").value;



	let regBtn = document.querySelector(".reg-btn");
	let cancelBtn = document.querySelector(".cancel-btn");

	regBtn.addEventListener("click", (e) => {
		let title = document.querySelector(".title").value;
		let content = document.querySelector(".content").value;
		let board = {
			studyId,
			writerId,
			title,
			content
		};
		fetch(`/api/studyBoardController/reg`,
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