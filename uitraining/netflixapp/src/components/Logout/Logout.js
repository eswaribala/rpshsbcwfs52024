import React, {useEffect} from 'react';
import PropTypes from 'prop-types';
import styles from './Logout.module.css';
import {Navigate, useNavigate} from "react-router-dom";

const Logout = (signupStatus)  => {

 return(

     <Navigate to="/" replace={false} />
 )

};


export default Logout;
