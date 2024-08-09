window.addEventListener('load',function(){
    document.querySelector('#signUp').addEventListener('click',
        function(){
            // alert("open signup");
            window.location.href="signup.html"
        })
    document.querySelector("#customerForm")
        .addEventListener('submit',function (){
      //  alert("Form submitted");

       let email=document.querySelector('#email').value;
       let password=document.querySelector('#password').value;

      if(window.localStorage.getItem("customer")!=undefined){
          let customer=window.localStorage.getItem("customer");
          let customerObject=JSON.parse(customer);
          console.log(customerObject);
          if((customerObject.email === email) && (customerObject.password === password)){
              alert("login success");
          }else{
              alert('login failed');
          }
      }


    })
});