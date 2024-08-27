import React, {useState} from 'react';
import styles from './HomeMenu.module.css';
import {Tab, Tabs} from "@mui/material";
import TabPanel from '@mui/lab/TabPanel';
import {TabContext, TabList} from "@mui/lab";
const HomeMenu = () => {

    const [value,setValue]=useState('1');
    function handleChange(event,value){
        setValue(value);
    }

    return(
        <div className={styles.HomeMenu}>
            <TabContext value={value}>

                    <TabList onChange={handleChange} aria-label="lab API tabs example">
                        <Tab label="Item One" value="1" />
                        <Tab label="Item Two" value="2" />
                        <Tab label="Item Three" value="3" />
                    </TabList>

                <TabPanel value="1">Item One</TabPanel>
                <TabPanel value="2">Item Two</TabPanel>
                <TabPanel value="3">Item Three</TabPanel>
            </TabContext>
        </div>
    )
};


export default HomeMenu;
