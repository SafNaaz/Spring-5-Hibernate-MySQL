package com.spring.demo.config;


import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.EnableLoadTimeWeaving.AspectJWeaving;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.aspectj.AnnotationTransactionAspect;

import com.spring.demo.model.Customer;
import com.spring.demo.model.CustomerLog;

@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScans(value = {@ComponentScan("com.spring.demo")})
public class HibernateConfig {
 
    @Autowired
    private ApplicationContext context;
 
    @Bean(value="sessionFactory")
    public LocalSessionFactoryBean getSessionFactory() {
    	System.out.println("Hibernate configuration called");
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
        factoryBean.setAnnotatedClasses(Customer.class,CustomerLog.class);
        return factoryBean;
    }
 
    @Bean
    public HibernateTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }

}