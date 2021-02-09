window.addEventListener('load',(e)=>{
	const audio = document.querySelector(".audio");
	const audioBtn = document.querySelector(".audio-btn");
	
	let stop = false;

	audio.volume  = 0.1;
	audioBtn.addEventListener("click",(e)=>{
		
		if(stop==false){
			
			audio.pause();
			stop = true;
			audioBtn.innerHTML="play";
			
		}else{
			
			audio.play();
			stop = false;
			audioBtn.innerHTML="stop";
			
		}
		
	});
	
});