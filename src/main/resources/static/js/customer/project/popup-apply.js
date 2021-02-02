window.addEventListener("load",function(){
	const apply = document.querySelector(".apply");
	const popupForm = document.querySelector(".popup-form"); 
	const id = document.querySelector(".id").value;
	
	apply.addEventListener("click",(e)=>{
		//e.preventDefault();
		
		//popupForm.submit();
		fetch(`/customer/project/apply/check/${id}`,{
			method:"POST"
		})
		.then((response)=>{
			return response.json();
		})
		.then((data)=>{
			let result = data.checkResult;
			
			if(result==0){
				alert("지원되었습니다.")
				opener.location.reload();
				window.close();
			}else{
				alert("중복지원이 불가능합니다.")
				opener.location.reload();
				window.close();
			}
		})
	});
});

