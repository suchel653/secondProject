window.addEventListener("load", (e) => {

	const main = document.querySelector(".main");
	const addBtn = main.querySelector(".addBtn");
	const tbody = main.querySelector(".tbody");

	// 추가 버튼 이벤트
	addBtn.onclick = () => {

		let tr = `<tr>
					  <td></td>
	                  <td>
	                    <input type="text" name="newNames">
	                  </td>
					  <td><input type="file" name="files" /></td>
	                  <td></td>
				  </tr>`;

		tbody.insertAdjacentHTML('afterbegin', tr);

	};

	// 수정 이벤트 발생 시
	tbody.addEventListener("change", e => {
		if (e.target.name != "newNames" && e.target.name != "del" && e.target.type == "text") {
			// e.target.name != "file" && e.target.name != "changedFileIds"
			e.target.previousElementSibling.name = "changedIds";
			if (e.target.tagName != 'IMG' && e.target.tagName != 'INPUT') {
				e.target.name = "changedNames";
			}
		}

	});

	tbody.addEventListener("click", e => {
		console.log(e.target);

		if (e.target.tagName == 'IMG') {

			if (!confirm('이미지를 변경하시겠습니까?'))
				return;

			let changedId = e.target.previousElementSibling.value;
			let addNodes = `<td>
							</td>
								<td>
								<input hidden type="text" name="changedFileIds" value="${changedId}"/>
								<input multiple="multiple" type="file" name="chagedFile" />
							</td>`;
			e.target.parentElement.insertAdjacentHTML('afterend', addNodes);
			e.target.parentElement.nextElementSibling.remove();
			e.target.parentElement.remove();

		}

	});

});