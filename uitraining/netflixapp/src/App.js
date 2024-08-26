import logo from './logo.svg';
import './App.css';
import Logo from "./components/Logo/Logo";
import TimerComponent from "./components/Timer/Timer";
import Banner from "./components/Banner/Banner";
import Login from './components/Login/Login'
function App() {
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
              <Login/>
          </section>

      </div>
  );
}

export default App;
