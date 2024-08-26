import  react from 'react'
import {Button, InputLabel, MenuItem, Select, TextField} from "@mui/material";
import {useFormik} from "formik";
import * as yup from 'yup'
import styles from "../Login/Login.module.css";
import axios from "axios";
import {registrationUrl} from "../../configurations/appconfig";


 const Registration=({signupStatus})=>{

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

    const formik=useFormik({
        initialValues:{
            name:"Test",
            job:"Developer",
            dob:"2001-12-02"
        },
        validationSchema:validationSchema,
        onSubmit:(values)=>{
            alert(values.name+","+values.job+","+values.dob);
             let data={
                 "name":values.name,
                 "job":"leader"
             }
            axios.post(registrationUrl,data).then(response=>{
                alert(response.data.id);
                signupStatus(false);
            })

        }

    })



    return(
        <div>
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
                        value={formik.values.job}
                        label="Job"
                       onChange={formik.handleChange}
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
