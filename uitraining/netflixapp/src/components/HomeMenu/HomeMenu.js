import React, {useState} from 'react';
import styles from './HomeMenu.module.css';
import {Tab, Tabs} from "@mui/material";

const HomeMenu = () => {

    const [value,setValue]=useState('');
    function handleChange(value){
        setValue(value);
    }

    return(
        <div className={styles.HomeMenu}>
            <Tabs
                value={value}
                onChange={handleChange}
                textColor="secondary"
                indicatorColor="secondary"
                aria-label="secondary tabs example"
            >
                <Tab value="one" label="Item One" />
                <Tab value="two" label="Item Two" />
                <Tab value="three" label="Item Three" />
            </Tabs>
        </div>
    )
};


export default HomeMenu;
