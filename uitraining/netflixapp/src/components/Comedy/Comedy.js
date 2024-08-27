import React, {useEffect, useState} from 'react';

import styles from './Comedy.module.css';
import axios from "axios";
import {movieUrl} from "../../configurations/appconfig";
import {ImageList, ImageListItem, ImageListItemBar} from "@mui/material";

const Comedy = () => {

    const[response,setResponse]=useState([]);
    useEffect(() => {
          fetchMovies();
        //console.log(response)
    }, []);

    function fetchMovies(){
        //alert("Invoking....")
        axios.get(movieUrl).then(res=>{
         //  alert("received response....");

            res.data.map((obj)=>{
                console.log(obj.title);
            })
            setResponse(res.data);
        })
    }


    return(
  <div >
      {(response.length>0) &&(
              <div>
                  <ImageList sx={{ width: 500, height: 450 }}>
                      {response.map((item) => (
                          <ImageListItem key={item.id}>
                              <img
                                  srcSet={`${item.poster}?w=248&fit=crop&auto=format&dpr=2 2x`}
                                  src={`${item.poster}?w=248&fit=crop&auto=format`}
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
