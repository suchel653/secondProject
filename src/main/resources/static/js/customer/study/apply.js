window.addEventListener("load",function(){
   const apply = document.querySelector(".btn");
   const checkId = document.querySelector(".checkId");
   
   let win;
   
   apply.addEventListener("click",(e)=>{
      
      if(!e.target.classList.contains("apply"))
            return;
e.preventDefault();
      let id = e.target.previousElementSibling.value;
      console.log(id);
      
      fetch("/customer/study/apply/check?id="+checkId.value,{
         method:"POST"
      })
      .then(res=>res.json())
      .then((data)=>{
         let result = data.checkResult;
         
         if(result ==0)
            win=open("/customer/study/apply/"+id,"_blank","width=500px,height=500px");
         else
            alert("이미 지원하셨습니다.");
      });
      
   });
   
});
/*   window.addEventListener("load",function(){
      const apply= document.querySelector(".applyBtn");
   
   apply.addEventListener("click",(e)=>{
      e.preventDefault();
      let comment = document.querySelector(".comment").value;
      let id = document.querySelector(".id").value;
      fetch("/customer/study/apply/"+id+"?comment="+comment,{
         method:"POST"
      })
      .then(()=>{
         window.close();
      });
   });
   
   
   
});
   */
window.addEventListener("load",function(){
   let checkId = document.querySelector(".id");
   let submitButton = document.querySelector(".applyBtn");
   
   submitButton.addEventListener("click",(e)=>{
      
      fetch("/customer/study/apply/"+checkId.value,{
         method:"POST"
      })
      .then(()=>{
         window.close();
      });
   
   });
});
   