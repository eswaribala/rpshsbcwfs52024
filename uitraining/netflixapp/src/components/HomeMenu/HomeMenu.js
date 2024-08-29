import React, {useState} from 'react';
import styles from './HomeMenu.module.css';
import {Box, createTheme, Tab, Tabs, ThemeProvider} from "@mui/material";
import TabPanel from '@mui/lab/TabPanel';
import {TabContext, TabList} from "@mui/lab";
import {Route, Routes, useLocation,Link} from "react-router-dom";
import Action from "../Action/Action";
import Comedy from "../Comedy/Comedy";
import ScienceFiction from "../ScienceFiction/ScienceFiction";
import App from "../../App";
import Logout from "../Logout/Logout";
import Login from "../Login/Login";
const theme = createTheme({
    components: {
        // Name of the component ⚛️
       MuiTab:{
           styleOverrides:{
               textColorSecondary:{
                   backgroundColor: "blueviolet"
               }
           }
       }
    },
});
const HomeMenu = () => {

   /* const [value,setValue]=useState('1');


    function handleChange(event,value){
        setValue(value);
    }*/
    const pathName=useLocation();

    return(
        <div className={styles.HomeMenu}>

            <Box sx={{ color:'black', marginLeft:'25%', fontWeight:'bold', justifyContent:'center',width: 1000 }}>
            <TabContext value={pathName}>
                    <Tabs value={pathName}
                          TabIndicatorProps={{
                              sx: {
                                  backgroundColor:'coral'
                              },
                          }}  centered>
                        <Tab sx={{color:'black',bgcolor:'red', fontSize:'large',fontWeight:'bold' }} label="Comedy"  component={Link} to="/comedy" value="/comedy" />
                        <Tab sx={{color:'black',bgcolor:'red', fontSize:'large',fontWeight:'bold' }} label="Action" component={Link} to="/action" value="/action" />
                        <Tab sx={{color:'black',bgcolor:'red', fontSize:'large',fontWeight:'bold' }} label="Science Fiction" component={Link} to="/sciencefiction" value="/sciencefiction" />
                        <Tab sx={{color:'black',bgcolor:'red', fontSize:'large',fontWeight:'bold' }} label="Logout" component={Link} to="/logout" value="/logout" />
                    </Tabs>


            </TabContext>
            </Box>
            <Routes>
                <Route path={"/action"} element={<Action/>}/>
                <Route path={"/comedy"} element={<Comedy/>}/>
                <Route path={"/sciencefiction"} element={<ScienceFiction/>}/>
                <Route path={"/logout"} element={<Logout/>}/>
            </Routes>

        </div>
    )
};


export default HomeMenu;
