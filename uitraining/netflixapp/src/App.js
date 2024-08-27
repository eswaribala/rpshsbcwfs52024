import logo from './logo.svg';
import './App.css';
import Logo from "./components/Logo/Logo";
import TimerComponent from "./components/Timer/Timer";
import Banner from "./components/Banner/Banner";
import Login from './components/Login/Login'
import {useState} from "react";
import Registration from "./components/Registration/Registration";
import HomeMenu from "./components/HomeMenu/HomeMenu";
function App() {
    {/* State */}
    const[signUpState,setSignUpState]=useState(false);
    const[loginState,setLoginState]=useState(false);
    {/*state change*/}
    function handleSignUpState(value){
        setSignUpState(value);
    }

    function handleLoginState(value){
        setLoginState(value);
    }

  return (
      <div className="App">
          <header className="App-header">
            {/* stateless component*/}
              <Logo/>
              <h1 className="multicolortext">Netflix  Over The Top</h1>
              {/* stateful component*/}
              <TimerComponent/>
          </header>
          {
              (!loginState)?
          <section className="Form-header">
              <Banner/>
              {/*props declaration*/}
              {(!signUpState)? <Login signupStatus={handleSignUpState} loginStatus={handleLoginState} /> :<Registration signupStatus={handleSignUpState}/>}
          </section>
           :
           <section>
               <HomeMenu/>
           </section>
          }
      </div>
  );
}

export default App;
