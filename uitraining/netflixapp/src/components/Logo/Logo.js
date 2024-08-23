import React from 'react';
import styles from './Logo.module.css';
import LogoPath from '../../images/netflixlogo.png'
const Logo = () => (
  <div >
    <figure>
        <img src={LogoPath} className={styles.Logo} />
    </figure>
  </div>
);

export default Logo;
