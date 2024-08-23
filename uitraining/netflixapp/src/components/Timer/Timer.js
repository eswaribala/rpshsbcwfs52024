import React, {Component} from 'react';
import styles from './Timer.module.css';

export class TimerComponent extends Component{
    constructor(props, context) {
        super(props, context);
    //step1
        this.state={
            currentTime:new Date()
        }
    }
    //step2
    timerEvent=()=>{
        this.setState({
            currentTime:new Date()
        })
    }

  //step4
    componentDidMount() {
        setInterval(this.timerEvent,1000);
    }

    render() {
        return(
            <div>
                <h4 >{this.state.currentTime.toLocaleTimeString()}</h4>
            </div>
        )
    }
}
