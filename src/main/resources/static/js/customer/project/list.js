window.addEventListener("load",(e)=>{
	const pager = document.querySelector(".pager");
	const notice = document.querySelector(".notice");
	const tbody = notice.querySelector("tbody");
	const searchForm = document.querySelector(".search-form");
	const queryInput = searchForm.querySelector("input[name=q]");
	
		e.preventDefault();
		
		let page = e.target.innerText;
		let query = queryInput.value;
		let field = "title";
		
		fetch(`/api/notice/list?p=${page}&f=${field}&q=${query}`)
		.then(response => response.json())
		.then(json => {
			tbody.innerHTML = "";
			
			for(let n of json){
			let tr = `<tr>
						<td>${n.id}</td>
						<td class="title indent text-align-left"><a href="${n.id }">${n.title}</a>[${n.cmtCount }]</td>
						<td>${n.writerId }</td>
						<td>
							${n.regdate }
						</td>
						<td>${n.hit }</td>
					</tr>`;
			tbody.insertAdjacentHTML("beforeend",tr);
			}
			
		});
	
	pager.addEventListener("click",(e)=>{
		e.preventDefault();
		
		let page = e.target.innerText;
		console.log(e.target.innerText);
		
		fetch(`/api/notice/list?p=${page}`)
		.then(response => response.json())
		.then(json => {
			tbody.innerHTML = "";
			
			for(let n of json){
			let tr = `<tr>
						<td>${n.id}</td>
						<td class="title indent text-align-left"><a href="${n.id }">${n.title}</a>[${n.cmtCount }]</td>
						<td>${n.writerId }</td>
						<td>
							${n.regdate }
						</td>
						<td>${n.hit }</td>
					</tr>`;
			tbody.insertAdjacentHTML("beforeend",tr);
			}
		});
	});
});