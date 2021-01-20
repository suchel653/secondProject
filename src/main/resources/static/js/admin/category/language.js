window.addEventListener("load", (e) => {

	const main = document.querySelector(".main");
	const addBtn = main.querySelector(".addBtn");
	const tbody = main.querySelector(".list-table tbody");

	addBtn.onclick = () => {
		console.log("hh");
		let tr = `<td></td>
                  <td>
                    <input type="text" name="new-name">
                  </td>
                  <td></td>`;

		tbody.insertAdjacentHTML('afterbegin', tr);

	};

});