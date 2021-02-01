window.addEventListener("load",function(){
	const apply = document.querySelector(".apply");
	const popupForm = document.querySelector(".popup-form"); 
	
	apply.addEventListener("click",(e)=>{
		e.preventDefault();
		
		popupForm.submit();
		
		$.ajax(
		{
			success : ()=>{ window.close(); }
		});
		
		
	});
	
});

