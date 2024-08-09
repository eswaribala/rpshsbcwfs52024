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
    //console.log("render country details",countryData);
   let ulRef=document.querySelector("#countryItems");
    countryData.forEach(country=>{
       let liRef= document.createElement("li");
        let aRef= document.createElement("a");
         aRef.setAttribute("class","dropdown-item");
        aRef.setAttribute("href","#");
        let textRef=document.createTextNode(country.name);
       aRef.appendChild(textRef);
       liRef.appendChild(aRef);
       ulRef.appendChild(liRef);
    })

}
function onFailure(statusCode){
    console.log("failed with status",statusCode);
}