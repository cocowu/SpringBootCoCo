package com.coco.spring.ioc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import org.springframework.beans.factory.DisposableBean;

@Component
public class BussinessPerson implements Person, BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

	// 加 @Autowired 时，当Animal接口只有一个实现类时，Spring会自动注入，当由两个实现类时报错。
	// 这时，如果把变量名，改为 dog，Spring很聪明，也能自动注入。
	// 加 (required=false) 表示 Spring 不一定要注入，不能决定时不注入。
	// @Autowired 也能加在 set 方法上。
	//@Autowired(required=false)
    private Animal animal = null;

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    @Autowired
    @Qualifier("dog")  // 指定实现类注入
    public void setAnimal(Animal animal) {
        System.out.println("延迟依赖注入");
        this.animal = animal;
    }

    @Override
    public void setBeanName(String beanName) {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】调用BeanNameAware的setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】调用BeanFactoryAware的setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】调用ApplicationContextAware的setApplicationContext");

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】调用InitializingBean的afterPropertiesSet方法");
    }

    @PostConstruct
    public void init() {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】注解@PostConstruct定义的自定义初始化方法");
    }

    @PreDestroy
    public void destroy1() {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】注解@PreDestroy定义的自定义销毁方法");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("【" + this.getClass().getSimpleName()
                + "】 DisposableBean方法");

    }

}
