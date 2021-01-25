window.addEventListener("load", (e) => {

	const main = document.querySelector(".main");
	const addBtn = main.querySelector(".addBtn");
	const tbody = main.querySelector(".list-table tbody");
	let count = 0;

	// 추가 버튼 이벤트
	addBtn.onclick = () => {
		count++;
		if(count > 1)
			alert('두 개 이상은 안되지롱~!');
		else{
			let tr = `<tr>
						  <td></td>
		                  <td>
		                    <input type="text" name="newNames">
		                  </td>
						  <td><input type="file" name="file" /></td>
		                  <td></td>
					  </tr>`;
	
			tbody.insertAdjacentHTML('afterbegin', tr);			
		}
	};
	
	// 수정 이벤트 발생 시
	tbody.addEventListener("change", function(e) {
		if (e.target.name != "newNames" && e.target.name != "del" && e.target.name != "file") {
			e.target.name = "changedNames";
			e.target.previousElementSibling.name = "changedIds";
		}
	});
	
});