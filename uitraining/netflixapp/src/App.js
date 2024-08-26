import logo from './logo.svg';
import './App.css';
import Logo from "./components/Logo/Logo";
import TimerComponent from "./components/Timer/Timer";
import Banner from "./components/Banner/Banner";
import Login from './components/Login/Login'
import {useState} from "react";
import Registration from "./components/Registration/Registration";
function App() {
    {/* State */}
    const[signUpState,setSignUpState]=useState(false);

    {/*state change*/}
    function handleSignUpState(value){
        setSignUpState(value);
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
          <section className="Form-header">
              <Banner/>
              {/*props declaration*/}
              {(!signUpState)? <Login signupStatus={handleSignUpState} /> :<Registration signupStatus={handleSignUpState}/>}
          </section>

      </div>
  );
}

export default App;
