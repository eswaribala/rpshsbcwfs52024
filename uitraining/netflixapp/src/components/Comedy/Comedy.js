import React, {useEffect, useState} from 'react';

import styles from './Comedy.module.css';
import axios from "axios";
import {movieUrl} from "../../configurations/appconfig";
import {ImageList, ImageListItem, ImageListItemBar} from "@mui/material";

const Comedy = () => {

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

          let filteredData= res.data.filter(item=>(item.genre.includes('Fantasy')));
            console.log(filteredData)
            setResponse(filteredData);
        })
    }


    return(
  <div >
      {(response.length>0) &&(
              <div>
                  <ImageList sx={{ width: 1500, height: 800, marginLeft:20}}>
                      {response.map((item) => (
                          <ImageListItem key={item.id}>
                              <img
                                  srcSet={`${item.poster}?w=50&h=50`}
                                  src={`${item.poster}?w=50&h=50`}
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



export default Comedy;
