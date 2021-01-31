window.addEventListener("load",function(){
	const apply = document.querySelector(".apply");
	const popupForm = document.querySelector(".popup-form"); 
	
	apply.addEventListener("click",(e)=>{
		e.preventDefault();
		let submit = popupForm.submit();
		
		$.ajax(
		{
			success : function()
			{
						window.close();
					}
		});
		
		/*Promise.resolve(submit)
		.then(()=>{
			window.close();
		});*/
	});
	
	/*setInterval(()=>{
		if(comment.value=="" && cnt==undefined){
			cnt=1;
			return;
			}
			else if(comment.value!="" && cnt==1)
				//window.self.close();
	},1000);*/
});

