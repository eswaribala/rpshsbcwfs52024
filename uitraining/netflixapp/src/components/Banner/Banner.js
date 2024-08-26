import React from 'react';
import styles from './Banner.module.css';
import BannerPath from '../../images/banner.jpg'
const Banner = () => (
  <div >
    <figure>
        <img src={BannerPath} className={styles.Banner}/>
    </figure>
  </div>
);



export default Banner;
