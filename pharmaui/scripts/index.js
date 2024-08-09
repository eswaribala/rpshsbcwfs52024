window.addEventListener('load',function(){

    getData("GET","https://restcountries.com/v2/all")
        .then(onSuccess, onFailure);




    document.querySelector('#signUp').addEventListener('click',
        function(){
       // alert("open signup");
       window.location.href="signup.html"
    })
    document.querySelector('#signIn').addEventListener('click',
        function(){
            // alert("open signup");
            window.location.href="signin.html"
        })

});

function onSuccess(countryData){
    console.log("render country details",countryData);
}
function onFailure(statusCode){
    console.log("failed with status",statusCode);
}