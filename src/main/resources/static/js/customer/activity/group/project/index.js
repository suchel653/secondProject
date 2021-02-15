window.addEventListener("load", (e) => {

	let infoBtn = document.querySelector(".info-Btn");
	let tbody = document.querySelector(".tbody");
	let pageStatus = document.querySelector(".pageStatus");
	let win;

	let applyBtn = document.querySelector(".apply-Btn");
	let applyTable = document.querySelector(".apply-table")
	let clicked;

	infoBtn.addEventListener("click", (e) => {

		let id = e.target.previousElementSibling.value;
		win = open("/customer/activity/group/project/" + id + "/info", "_blank", "width=1080px,height=650px");

	});

	if (tbody != null) {

		if (pageStatus.value == 0) {
			applyTable.style.display = "none";
			clicked = false;
		} else {
			applyTable.style.display = "block";
			clicked = true;
		}

		tbody.addEventListener("click", (e) => {
			e.preventDefault();
			console.log(e.target.nextElementSibling.childNodes);
			if (e.target.tagName == "INPUT") {
				let action = e.target.value;
				let memberId = e.target.previousElementSibling.value;
				let projectId = e.target.previousElementSibling.previousElementSibling.value;
				pageStatus.value = 1;

				fetch(`/customer/activity/group/project/${projectId}/approve?action=${action}&memberId=${memberId}`
					, { method: "POST" })
					.then(window.location = `index?pageStatus=${pageStatus.value}`);
			} else if (e.target.tagName == "P" && e.target.nextElementSibling.nextElementSibling.value == 0) {
				e.target.nextElementSibling.childNodes[1].style.display = "block";
				e.target.nextElementSibling.nextElementSibling.value = 1;
			} else if (e.target.tagName == "P" && e.target.nextElementSibling.nextElementSibling.value == 1) {
				e.target.nextElementSibling.childNodes[1].style.display = "none";
				e.target.nextElementSibling.nextElementSibling.value = 0;
			} else if (e.target.tagName == "A") {
				win = open(e.target.href, "win", "width=900, height=500");
			}

		});

		applyBtn.addEventListener("click", (e) => {
			if (clicked) {
				applyTable.style.display = "none";
				clicked = false;
			} else {
				applyTable.style.display = "block";
				clicked = true;
			}
		});
	}

});

// ====================================================== 게시판 ==========================================

window.addEventListener("load", (e) => {

	let boardTableTbody = document.querySelector(".boardTbody");
	let board = document.querySelector(".board");
	let list = null;
	let boardPlusBtn = document.querySelector(".board-plus-btn");
	let projectId = document.querySelector("input").value;
	let boardId = 0;
	let boardCnt = 0;
	let currentCnt = 0;

	let boardRegWin;
	let boardRegBtn = document.querySelector(".board-reg");
	let writerId = document.querySelector(".memberId").value;

	getBoardList();

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
				let tr = `<tr class="title-tr">
							<td class="title">
								<input type="hidden" value="${i + currentCnt}"/>
								<input class="board-id" type="hidden" value="${list[i + currentCnt].id}"/>
								${list[i + currentCnt].title}(${list[i + currentCnt].cmtCnt})
							</td>
							<td>${list[i + currentCnt].writerNickname}</td>
							<td>${moment(list[i + currentCnt].regDate).format("YYYY-MM-DD HH:mm")}</td>
						</tr>`;
				boardTableTbody.insertAdjacentHTML("beforeend", tr);
			}
			currentCnt += 5;

		}
		else {
			for (let i = 0; i < boardCnt - currentCnt; i++) {
				let tr = `<tr class="title-tr">
							<td class="title">
								<input type="hidden" value="${i + currentCnt}"/>
								<input class="board-id" type="hidden" value="${list[i + currentCnt].id}"/>
								${list[i + currentCnt].title}(${list[i + currentCnt].cmtCnt})
							</td>
							<td>${list[i + currentCnt].writerNickname}</td>
							<td>${moment(list[i + currentCnt].regDate).format("YYYY-MM-DD HH:mm")}</td>
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
					if (e.currentTarget.children[i].previousElementSibling.children[0].children[0].value ==
						e.target.children[0].value) {
						clicked = false;
					}
					e.currentTarget.children[i].nextElementSibling.remove();
					e.currentTarget.children[i].remove();

				}
			}

			if (clicked) {
				let index = e.target.children[0].value;
				boardId = e.target.children[1].value;
				console.log(boardId);
				let detailTr = `<tr class="detail">
							<td colspan="4">
								<div class="auth-box">
									<input class="detail-edit" type="button" value="수정"/>
									<input class="detail-del" type="button" value="삭제"/>
								</div>
								<span class="detail-content">
									${list[index].content}
								</span>
							
								</td>	
						</tr>`;
				e.target.parentElement.insertAdjacentHTML("afterend", detailTr);

				let authId = writerId;
				let boardWriterId = list[index].writerId;
				let dynamicNodes = [".auth-box", ".detail-edit", ".detail-del"];
				createDetailDynamicNode(authId, boardWriterId, ...dynamicNodes);





				getCommentList(e.target.parentElement.nextElementSibling, boardId);


			}
		}
	});

	boardRegBtn.addEventListener("click", (e) => {
		boardRegWin = open("/customer/activity/group/project/" + projectId + "/board/reg", "_blank", "width=500px,height=500px");
	});

	function getCommentList(detail, boardId) {
		fetch(`/api/projectCommentController/list?boardId=${boardId}`)
			.then(response => response.json())
			.then(json => {
				let commentList = "";
				let reged = false;
				console.log(json);
				for (let comment of json) {
					let cmtAuth = "";
					if (writerId == comment.writerId) {
						cmtAuth = `
									<span>
										<input class="cmt-del" type="button" value="삭제"/>
									</span>
								`;
						reged = true;
					}
					commentList += `<div>
									 <span>${comment.writerNickname}</span> 
									: <span>${comment.content}<span> 
									<span class="comment-regdate">${moment(comment.regDate).format("YYYY-MM-DD HH:mm")}</span>
									<input type="hidden" value="${comment.id}"/>
									${cmtAuth}
									 </div>`;
				}
				let commentTr = `<tr class="comment">
											<td colspan="4">`
					+ commentList +
					`<div><input class="cmt-content" type="text"/><input class="cmt-reg" type="button" value="등록"/></div>
											</td>
										</tr>`;
				detail.insertAdjacentHTML("afterend", commentTr);
				createNode(detail, boardId);
				if (reged) {
					createCmtDynamicNode();
				}

			});
	}

	function createNode(detail, boardId) {
		let cmtRegBtn = document.querySelector(".cmt-reg");
		cmtRegBtn.addEventListener("click", (e) => {
			let content = document.querySelector(".cmt-content").value;
			let comment = {
				boardId,
				writerId,
				content
			};

			fetch(`/api/projectCommentController/reg`,
				{
					method: "POST",
					headers: {
						"Content-Type": "application/json",
					},
					/*data: JSON.stringify(board),*/
					body: JSON.stringify(comment)
				})
				.then(() => {
					detail.nextElementSibling.remove();
					getCommentList(detail, boardId);
				})
				.then(() => {
					fetch(`/api/projectCommentController/cnt?boardId=${boardId}`)
						.then(response => response.json())
						.then(cnt => {
							let text = detail.previousElementSibling.children[0].childNodes[4].data.trim();
							let subLen = text.lastIndexOf("(");
							text = text.substring(0, subLen + 1);
							text += cnt + ")";
							detail.previousElementSibling.children[0].childNodes[4].data = text;

						});
				})


		})

	}

	function createDetailDynamicNode(authId, boardWriterId, ...nodes) {
		let authBox = document.querySelector(nodes[0]);
		let detailEdit = document.querySelector(nodes[1]);
		let detailDel = document.querySelector(nodes[2]);

		if (writerId != boardWriterId)
			authBox.style.display = "none";

		detailEdit.addEventListener("click", (e) => {

			let win = open("/customer/activity/group/project/" + projectId + "/board/edit?id=" + boardId, "_blank", "width=500px,height=500px");

		});

		detailDel.addEventListener("click", (e) => {
			let result = confirm("삭제하시겠습니까?");
			if (!result)
				return;
			let id = boardId;
			fetch(`/api/projectBoardController/delete?id=${id}`)
				.then(() => {
					window.location.reload();
				})
		});


	}

	function createCmtDynamicNode() {
		let commentTable = document.querySelector(".comment");

		commentTable.addEventListener("click", (e) => {
			let action = e.target.className;

			if (action == "cmt-del") {
				let result = confirm("삭제하시겠습니까?");
				if (!result)
					return;
				let id = e.target.parentElement.previousElementSibling.value;
				fetch(`/api/projectCommentController/delete?id=${id}`)
					.then(() => {
						document.querySelector(".comment").innerText = "";
						getCommentList(document.querySelector(".detail"), boardId)
					})
			}

		})
	}

});



// =================================== 프로젝트 상태 변경 ====================

window.addEventListener("load", (e) => {
	let statusBox = document.querySelector(".status-box");
	let id = document.querySelector("input").value;
	if (statusBox != null) {
		let statusId = statusBox.querySelector(".status-id").value;
		if (statusId == 1) {
			let startBtn = statusBox.querySelector(".status-box .start-btn");
			startBtn.addEventListener("click", (e) => {
				let result = confirm("프로젝트를 진행하시겠습니까?");
				if (!result)
					return;

				fetch(`/api/projectController/updateStatus?id=${id}&statusId=2`)
					.then(() => {
						window.location.reload();
					})

			});
		}
		else if (statusId == 2) {
			let endBtn = statusBox.querySelector(".status-box .end-btn");
			endBtn.addEventListener("click", (e) => {
				let result = confirm("프로젝트를 종료하시겠습니까?");
				if (!result)
					return;
				
				fetch(`/api/projectController/updateStatus?id=${id}&statusId=3`)
					.then(() => {
						window.location.reload();
					})
			})
		}
	}

});