window.addEventListener("load", (e) => {

	let id = document.querySelector(".boardId").value;

	let editBtn = document.querySelector(".edit-btn");
	let cancelBtn = document.querySelector(".cancel-btn");
	editBtn.addEventListener("click", (e) => {
		let result = confirm("수정하시겠습니까?");
		if (!result)
			return;
			
		
		let title = document.querySelector(".title").value;
		let content = document.querySelector(".content").value;
		let board = {
			id,
			title,
			content
		};
		let detailContent = opener.document.querySelector(".detail-content");
		let titleContent = opener.document.querySelector(".detail").previousElementSibling.children[0].childNodes[4];
		fetch(`/api/projectBoardController/edit`,
			{
				method: "POST",
				headers: {
					"Content-Type": "application/json",
				},
				
				body: JSON.stringify(board)
			})
			.then(response=>response.json())
			.then(cmtCnt=>{
				detailContent.innerText = board.content;
				titleContent.data= `${board.title}(${cmtCnt})`;
				self.close();
			});
	})

	cancelBtn.addEventListener("click", (e) => {

		self.close();
	})
});