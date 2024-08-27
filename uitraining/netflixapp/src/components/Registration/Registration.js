import react, {useState} from 'react'
import {Alert, Button, InputLabel, MenuItem, Select, Snackbar, TextField} from "@mui/material";
import {useFormik} from "formik";
import * as yup from 'yup'
import styles from "../Login/Login.module.css";
import axios from "axios";
import {registrationUrl} from "../../configurations/appconfig";


 const Registration=({signupStatus})=>{

     const [open,setOpen]=useState(false)

    const validationSchema=yup.object({
        name:yup.string("Enter Name")
            .matches(/[A-Za-z]{5,25}/,"Name should be in " +
                "alphabets between 5 to 25 characters")
            .required("Must enter name"),
        job:yup.string("Select Job")
            .required("Must Select the job"),
        dob:yup.string("Enter DOB")
            .required("Must enter dob")

    })

     const[jobValue,setJobValue]=useState('Developer');
     function handleChange(pointer){

        //alert(pointer.target.value);
         setJobValue(pointer.target.value);
     }


    const formik=useFormik({
        initialValues:{
            name:"Test",
            job:"Developer",
            dob:"2001-12-02"
        },
        validationSchema:validationSchema,
        onSubmit:(values)=>{
            console.log(values.name+","+values.job+","+values.dob);
             let data={
                 "name":values.name,
                 "job":jobValue
             }
            axios.post(registrationUrl,data).then(response=>{
                alert(response.data.id);
                setOpen(true);
                setTimeout(function() { //Start the timer
                    signupStatus(false); //After 1 second, set render to true
                }.bind(this), 5000)


            })

        }

    })




     const handleClose = () => {
         setOpen(false);
     };


     return(
        <div>
            <Snackbar
                open={open}
                autoHideDuration={5000}
                onClose={handleClose}
                sx={{
                    '&.MuiSnackbar-root': { top: '1%', left:'50%' }
                }}
            >
                <Alert
                    onClose={handleClose}
                    severity="success"
                    variant="filled"
                    sx={{

                        width: '100%'
                    }}

                > Registration Completed Successfully </Alert>
            </Snackbar>
            <form onSubmit={formik.handleSubmit}>
                <fieldset>
                <legend className={styles.legend}>Customer Registration</legend>
                <TextField
                id="name"
                label="Name"
                type="text"
                value={formik.values.name}
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                variant="outlined"
                fullWidth
                margin="dense"
                >

                </TextField>

                <Select

                        id="job"
                        fullWidth
                        value={jobValue}
                        label="Job"
                       onChange={handleChange}
                        onBlur={formik.handleBlur}
                    >
                        <MenuItem value="developer">Developer</MenuItem>
                        <MenuItem value="manager">Manager</MenuItem>
                        <MenuItem value="director">Director</MenuItem>
                        <MenuItem value="leader">Leader</MenuItem>
                </Select>

                <TextField
                id="dob"
                label="DOB"
                type="date"
                value={formik.values.dob}
                onBlur={formik.handleBlur}
                onChange={formik.handleChange}
                variant="outlined"
                fullWidth
                margin="dense"
                >

                </TextField>

                <Button type="submit" variant="contained">Signup</Button>
                </fieldset>
                </form>
        </div>

    )



}
export default Registration;
