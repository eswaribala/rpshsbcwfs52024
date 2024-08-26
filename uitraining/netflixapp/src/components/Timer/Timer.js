import React, {Component, useEffect, useState} from 'react';
import styles from './Timer.module.css';

//functional component
function TimerComponent(){
    //step 1
    //state hook
    const[currentTime,setCurrentTime]=useState(new Date());

    //step2
    //Effect Hook
    useEffect(() => {
        setInterval(()=>{
            setCurrentTime(new Date())
        },1000)

    }, [currentTime]);
    //step 3
    return(
        <div>
            <h4>{currentTime.toLocaleTimeString()}</h4>
        </div>
    )

}

export  default  TimerComponent

/*
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
*/