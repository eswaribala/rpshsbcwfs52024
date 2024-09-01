import React, {useEffect, useState} from 'react';

import styles from './Action.module.css';
import axios from "axios";
import {movieUrl} from "../../configurations/appconfig";
import {ImageList, ImageListItem, ImageListItemBar} from "@mui/material";

const Action = () => {

    const[response,setResponse]=useState([]);
    useEffect(() => {
        //only once
        fetchMovies();
        //console.log(response)
    }, []);

    function fetchMovies(){
        //alert("Invoking....")
        axios.get(movieUrl).then(res=>{
            //  alert("received response....");

            let filteredData= res.data.filter(item=>(item.genre.includes('Action')));
            console.log(filteredData)
            setResponse(filteredData);
        })
    }


    return(
        <div >
            {(response.length>0) &&(
                <div>
                    <ImageList sx={{ width: '90%', height: '100%', padding:'5%'}}
                               cols={4}
                               gap={20}>
                        {response.map((item) => (
                            <ImageListItem key={item.id} >
                                <img
                                    srcSet={`${item.poster}?w=150&fit=crop&auto=format&dpr=2 2x`}
                                    src={`${item.poster}?w=150&fit=crop&auto=format`}
                                    alt={item.title}
                                    loading="lazy"
                                />
                                <ImageListItemBar
                                    title={item.title}
                                    subtitle={<span>by: {item.director}</span>}
                                    position="below"
                                />
                            </ImageListItem>
                        ))}
                    </ImageList>
                </div>
            )
            }
        </div>
    )}



export default Action;