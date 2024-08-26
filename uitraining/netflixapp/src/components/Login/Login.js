import React from 'react';

import styles from './Login.module.css';
import {Box, Button, FormControl, Input, InputAdornment, InputLabel, TextField} from "@mui/material";
import AccountCircle from '@mui/icons-material/AccountCircle';
function Login(){


    return(
        <Box sx={{ '& > :not(style)': { m: 1 } }}>
            <TextField
                id="input-with-icon-textfield"
                fullWidth={true}
                label="TextField"
                InputProps={{
                    startAdornment: (
                        <InputAdornment position="start">
                            <AccountCircle />
                        </InputAdornment>
                    ),
                }}
                variant="standard"
            />

        </Box>
    )


}


export default Login;
