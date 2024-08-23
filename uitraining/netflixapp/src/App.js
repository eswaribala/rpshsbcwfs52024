import logo from './logo.svg';
import './App.css';
import Logo from "./components/Logo/Logo";
import {TimerComponent} from "./components/Timer/Timer";

function App() {
  return (
      <div className="App">
          <header className="App-header">
            {/* stateless component*/}
              <Logo/>
              <h1 className="multicolortext">Netflix</h1>
              {/* stateful component*/}
              <TimerComponent/>
          </header>

      </div>
  );
}

export default App;
