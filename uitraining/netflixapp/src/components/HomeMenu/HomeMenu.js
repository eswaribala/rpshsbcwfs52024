import React, {useState} from 'react';
import styles from './HomeMenu.module.css';
import {Box, Link, Tab, Tabs} from "@mui/material";
import TabPanel from '@mui/lab/TabPanel';
import {TabContext, TabList} from "@mui/lab";
import {Route, Routes, useLocation} from "react-router-dom";
import Action from "../Action/Action";
import Comedy from "../Comedy/Comedy";
import ScienceFiction from "../ScienceFiction/ScienceFiction";

const HomeMenu = () => {

   /* const [value,setValue]=useState('1');


    function handleChange(event,value){
        setValue(value);
    }*/
    const pathName=useLocation();

    return(
        <div className={styles.HomeMenu}>
            <Box sx={{ color:'black', marginLeft:'30%', fontWeight:'bold', justifyContent:'center',width: 1000 }}>
            <TabContext value={pathName} >
                    <Tabs value={pathName}
                          TabIndicatorProps={{
                              sx: {
                                  backgroundColor: 'red',
                              },
                          }} centered>
                        <Tab label="Comedy"  component={Link} to="/comedy" value="/comedy" />
                        <Tab label="Action" component={Link} to="/action" value="/action" />
                        <Tab label="Science Fiction" component={Link} to="/sciencefiction" value="/sciencefiction" />
                    </Tabs>


            </TabContext>
            </Box>
            <Routes>
                <Route path={"/action"} element={<Action/>}/>
                <Route path={"/comedy"} element={<Comedy/>}/>
                <Route path={"/sciencefiction"} element={<ScienceFiction/>}/>

            </Routes>

        </div>
    )
};


export default HomeMenu;
