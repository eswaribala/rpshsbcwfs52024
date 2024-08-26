import React from 'react';

import styles from './Login.module.css';
import {Box, Button, FormControl, Input, InputAdornment, InputLabel, TextField} from "@mui/material";
import AccountCircle from '@mui/icons-material/AccountCircle';
import {Email, Lock} from "@mui/icons-material";
import {useFormik} from "formik";
import * as yup from 'yup';
function Login(){

 const validationSchema=yup.object({
    email:yup.string("Enter Email Address")
        .email("Required Valid Email Id")
        .required("Must give Email"),
    password: yup.string("Enter Password")
        .min(4,"Minimum 4 Characters")
        .max(8,"Maximum 8 Characters")
        .required("Must Enter Password")

 })


 const formik=useFormik({

     initialValues:{
         email:"sample@gmail.com",
         password:"Test@123"
     },

     validationSchema:validationSchema,

    onSubmit:(values)=>{
          alert(values);
    }

 })



    return(
        <Box sx={{ '& > :not(style)': { m: 1 } }}>
            <form>
            <TextField
                id="email"
                type="email"
                fullWidth
                label="Email"
                value={formik.values.email}
                onBlur={formik.handleBlur}
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

            <Button variant="contained"  size="large" >
                Login
            </Button>
            </form>
        </Box>
    )


}


export default Login;
