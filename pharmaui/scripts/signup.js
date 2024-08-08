window.addEventListener('load',function(){


    document.querySelector("#customerForm")
        .addEventListener('submit',function (){
        alert("Form submitted");
       let name= document.querySelector('#name').value;
       let dob=document.querySelector('#dob').value;
       let email=document.querySelector('#email').value;
       let password=document.querySelector('#password').value;
       let gender=document.querySelector('#gender').value;
       //create object
       let customer={
           "name":name,
           "dob":dob,
           "email":email,
           "password":password,
           "gender":gender
       }
       console.log(customer);
       window.localStorage.setItem("customer",customer);
    })
});