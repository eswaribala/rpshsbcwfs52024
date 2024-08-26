import React, {useEffect, useState} from 'react';

import styles from './Login.module.css';
import {Box, Button, FormControl, Input, InputAdornment, InputLabel, TextField} from "@mui/material";
import AccountCircle from '@mui/icons-material/AccountCircle';
import {Email, Lock} from "@mui/icons-material";
import {useFormik} from "formik";
import * as yup from 'yup';
import axios from "axios";
import {Url} from '../../configurations/appconfig'
const Login=({signupStatus})=>{

  //define userInput State Hook
  //const[userInput, setUserInput]=useState('');
  const[value,setValue]=useState('');

    useEffect((value) => {
        setValue(value)
    }, [value]);


function handleSignUpStatus(){
    signupStatus(true);
}



 const validationSchema=yup.object({
    email:yup.string("Enter Email Address")
        .email("Required Valid Email Id")
        .required("Must give Email"),
    password: yup.string("Enter Password")
        .min(4,"Minimum 4 Characters")
        .max(10,"Maximum 10 Characters")
        .required("Must Enter Password")

 })


 const formik=useFormik({

     initialValues:{
         email:"eve.holt@reqres.in",
         password:"cityslicka"
     },

     validationSchema:validationSchema,

    onSubmit:(values)=>{
          console.log(values.email+","+values.password);
         let data={
              "email":values.email,
              "password":values.password
          }
          axios.post(Url,data).then(response=>{
              console.log(response.data.token);
          })

    }

 })



    return(
        <Box sx={{ '& > :not(style)': { m: 1 } }}>
            <form onSubmit={formik.handleSubmit}>
            <fieldset>
            <legend className={styles.legend}>Customer Login</legend>
            <TextField
                id="email"
                type="email"
                fullWidth
                label="Email"
                value={formik.values.email}
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                error={formik.errors.email && Boolean(formik.errors.email)}
                helperText={formik.touched.email && formik.errors.email}

                InputProps={{
                    startAdornment: (
                        <InputAdornment position="start">
                            <Email />
                        </InputAdornment>
                    ),
                }}
                variant="outlined"
                margin="dense"
            />

            <TextField
                id="password"
                type="password"
                fullWidth
                label="Password"
                value={formik.values.password}
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                error={formik.errors.password && Boolean(formik.errors.password)}
                helperText={formik.touched.password && formik.errors.password}
                InputProps={{
                    startAdornment: (
                        <InputAdornment position="start">
                            <Lock />
                        </InputAdornment>
                    ),
                }}
                variant="outlined"
                margin="dense"
            />

            <Button type="submit" variant="contained"  size="large" >
                Login
            </Button>
            </fieldset>
            </form>
           <p className={styles.p}> New User?
               <a href="#" onClick={handleSignUpStatus}>Signup</a>
           </p>
        </Box>
    )


}


export default Login;
