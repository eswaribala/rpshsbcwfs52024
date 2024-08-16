package com.hsbc.models;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(DiagnosisConfig.class)
public class Diagnosis implements InitializingBean,BeanFactoryAware{
        //{


    //converting java object to bean
    @Bean
    public Treatment recommenedTreatment(){
        return new Treatment();
    }

          @Override
          public void afterPropertiesSet() throws Exception {
               System.out.println("Bean Sets properties.....");
          }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println(beanFactory.getBean("diagnosis"));
    }


}
