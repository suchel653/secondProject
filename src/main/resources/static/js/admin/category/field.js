window.addEventListener("load", (e) => {

	const main = document.querySelector(".main");
	const addBtn = main.querySelector(".addBtn");
	const tbody = main.querySelector(".list-table tbody");

	// 추가 버튼 이벤트
	addBtn.onclick = () => {

		console.log("hh");
		let tr = `<td></td>
                  <td>
                    <input type="text" name="new-name">
                  </td>
                  <td></td>`;

		tbody.insertAdjacentHTML('afterbegin', tr);

	};
	
	// 저장 버튼 이벤트
	
	// 삭제 버튼 이벤트

});