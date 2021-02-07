window.addEventListener("load", (e) => {

	const info = document.querySelector(".info");
	let tbody = document.querySelector(".tbody");
	let boardTableTbody = document.querySelector(".boardTbody");
	let board = document.querySelector(".board");
	let list = null;
	let boardPlusBtn = document.querySelector(".board-plus-btn");

	let projectId = document.querySelector("input").value;


	let boardCnt = 0;
	let currentCnt = 0;
	getBoardList();

	let win;
	let boardRegWin;
	let boardRegBtn = document.querySelector(".board-reg");
	info.addEventListener("click", (e) => {

		let id = e.target.previousElementSibling.value;

		win = open("/customer/activity/group/project/" + id + "/info", "_blank", "width=500px,height=500px");

	});

	tbody.addEventListener("click", (e) => {

		e.preventDefault();

		let action = e.target.value;
		let id = e.target.previousElementSibling.value;
		let projectId = e.target.previousElementSibling.previousElementSibling.value;

		fetch(`/customer/activity/group/project/${projectId}/approve?action=${action}&id=${id}`
			, { method: "POST" })
			.then(window.location.reload());

	});

	function getBoardList() {
		fetch(`/api/projectBoardController/list?projectId=${projectId}`)
			.then(response => response.json())
			.then(json => {
				boardCnt = json.count;
				list = json.list;
				addListView();
			});
	};

	boardPlusBtn.addEventListener("click", (e) => {
		addListView();
	})

	function addListView() {
		if (boardCnt > currentCnt + 5) {
			for (let i = 0; i < 5; i++) {
				let tr = `<tr>
							<td class="title"><input type="hidden" value="${i + currentCnt}"/>${list[i + currentCnt].title}(${list[i + currentCnt].cmtCnt})</td>
							<td>${list[i + currentCnt].writerNickname}</td>
							<td>${list[i + currentCnt].regDate}</td>
						</tr>`;
				boardTableTbody.insertAdjacentHTML("beforeend", tr);
			}
			currentCnt += 5;

		}
		else {
			console.log(list);
			for (let i = 0; i < boardCnt - currentCnt; i++) {
				let tr = `<tr>
							<td class="title"><input type="hidden" value="${i + currentCnt}"/>${list[i + currentCnt].title}(${list[i + currentCnt].cmtCnt})</td>
							<td>${list[i + currentCnt].writerNickname}</td>
							<td>${list[i + currentCnt].regDate}</td>
						</tr>`;
				boardTableTbody.insertAdjacentHTML("beforeend", tr);
			}
			boardPlusBtn.type = "hidden";
		}
	}

	boardTableTbody.addEventListener("click", (e) => {

		let clicked = true;
		if (e.target.className == "title") {
			for (let i = 0; i < e.currentTarget.children.length; i++) {
				if (e.currentTarget.children[i].className == "detail") {
					if(e.currentTarget.children[i].previousElementSibling.children[0].children[0].value==
					e.target.children[0].value){
						clicked=false;
					}
					e.currentTarget.children[i].nextElementSibling.remove();
					e.currentTarget.children[i].remove();

				}
			}

			if (clicked) {
				let index = e.target.children[0].value;
				let tr = `<tr class="detail">
							<td colspan="4" style="border:1px solid black; height:100px;">${list[index].content}</td>
						</tr>
						<tr>
							<td colspan="4" style="border:1px solid black;">
								<div>댓글1</div>
								<div>댓글2</div>
							</td>
						</tr>`;
				e.target.parentElement.insertAdjacentHTML("afterend", tr);
			}
		}


	})
	
	boardRegBtn.addEventListener("click",(e)=>{
		boardRegWin = open("/customer/activity/group/project/" +projectId+ "/board/reg", "_blank", "width=500px,height=500px");
	})


});