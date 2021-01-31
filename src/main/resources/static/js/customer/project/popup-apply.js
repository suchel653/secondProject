window.addEventListener("load",function(){
	const apply = document.querySelector(".apply");
	const popupForm = document.querySelector(".popup-form"); 
	
	apply.addEventListener("click",(e)=>{
		e.preventDefault();
		popupForm.submit();
		
		$.ajax(
		{
			success : function()
					{									
						window.close();
					}
		});
	});
	
	/*setInterval(()=>{
		if(comment.value=="" && cnt==undefine){
			cnt=1;
			return;
			}
			else if(comment.value!="" && cnt==1)
			cnt=2;
				//window.self.close();
	},1000);*/
});

