window.addEventListener('load',function(){
    document.querySelector('#signIn').addEventListener('click',
        function(){
            // alert("open signup");
            window.location.href="signin.html"
        })

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
      // window.localStorage.setItem("customer",JSON.stringify(customer));
       sendCustomerDataAJAX(customer);
    })
});


function sendCustomerDataAJAX(customer){
    let ajaxObject;
    try{
        ajaxObject=new XMLHttpRequest()
    }catch (e){
        try {
            ajaxObject = new ActiveXObject("");
        }catch (e){
            console.log("AJAX not supported....")
        }
    }
    //open the connection

    ajaxObject.open("POST",
        "http://localhost:7070/pharmaappjee_war_exploded/signup-servlet",
        true);
    //servlet call
    ajaxObject.setRequestHeader('X-Requested-With', 'XMLHttpRequest');
    ajaxObject.setRequestHeader('Access-Control-Allow-Origin', '*');
    ajaxObject.setRequestHeader("Access-Control-Allow-Methods", "POST");
    ajaxObject.setRequestHeader("Access-Control-Allow-Headers", "Content-Type");
    ajaxObject.setRequestHeader('Content-type', 'application/json')
    ajaxObject.setRequestHeader("Access-Control-Max-Age", "86400");

    ajaxObject.send(JSON.stringify(customer));

    //check request status
    ajaxObject.onreadystatechange=function (){
        if((ajaxObject.readyState==4) && (ajaxObject.status==200)){
            console.log(ajaxObject.responseText);
        }
    }


}