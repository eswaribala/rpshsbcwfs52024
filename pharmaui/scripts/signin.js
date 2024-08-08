window.addEventListener('load',function(){

    document.querySelector("#customerForm")
        .addEventListener('submit',function (){
        alert("Form submitted");

       let email=document.querySelector('#email').value;
       let password=document.querySelector('#password').value;

      if(window.localStorage.getItem("customer")!=undefined){
          let customer=window.localStorage.getItem("customer");
          if((customer.email === email) && (customer.password === password)){
              alert("login success");
          }else{
              alert('login failed');
          }
      }


    })
});