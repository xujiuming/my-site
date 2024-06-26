package com.ming.core.utils;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;
import java.util.Set;

/**
 * spring 工具类
 *
 * @author ming
 * @date 2024-05-06 11:53:30
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class SpringUtils implements ApplicationContextAware, DisposableBean {


    /**
     * 手动注册的bean 名称列表  必须保证 每个使用它的地方 是一样的
     *
     * @author ming
     * @date 2017-11-10 15:54
     */
    private static final Map<String, Class<?>> MANUAL_REGISTER_BEAN_MAP = Maps.newConcurrentMap();
    /**
     * spring bean上下文
     *
     * @author ming
     * @date 11:00
     */
    private static ApplicationContext APPLICATION_CONTEXT;
    /**
     * 获取BeanFactory  进行动态注册bean 删除bean
     *
     * @author ming
     * @date 2017-11-10 15:51
     */
    private static DefaultListableBeanFactory DEFAULT_LISTABLE_BEAN_FACTORY;


    public static void publishEvent(Object event) {
        checkApplicationContext();
        APPLICATION_CONTEXT.publishEvent(event);
    }

    public static void publishEvent(ApplicationEvent event) {
        checkApplicationContext();
        APPLICATION_CONTEXT.publishEvent(event);
    }

    /**
     * 获取 手动注入的 bean名称
     *
     * @return Set<String>
     * @author ming
     * @date 2017-12-12 13:46
     */
    public static Set<String> getManualRegisterBeanNameSet() {
        return MANUAL_REGISTER_BEAN_MAP.keySet();
    }

    /**
     * 动态注入bean
     *
     * @param beanName
     * @param beanClazz
     * @author ming
     * @date 2017-11-09 16:50
     */
    public static void registerBean(String beanName, Class<?> beanClazz) {
        assert StringUtils.isNotEmpty(beanName);
        assert beanClazz != null;
        checkDefaultListableBeanFactory();
        //创建beanBuilder
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(beanClazz);
        //注册bean
        DEFAULT_LISTABLE_BEAN_FACTORY.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        //添加手工注册的beanName 到集合
        MANUAL_REGISTER_BEAN_MAP.put(beanName, beanClazz);
    }

    /**
     * 删除bean
     *
     * @param beanName
     * @author ming
     * @date 2017-11-10 15:45
     */
    public static void removeBean(String beanName) {
        assert StringUtils.isNotEmpty(beanName);
        //当试图删除 非手动注册的bean的时候
        if (!MANUAL_REGISTER_BEAN_MAP.containsKey(beanName)) {
            throw new UnsupportedOperationException("不能删除非手动注册的bean");
        }
        checkDefaultListableBeanFactory();
        DEFAULT_LISTABLE_BEAN_FACTORY.removeBeanDefinition(beanName);
        MANUAL_REGISTER_BEAN_MAP.remove(beanName);
    }

    /**
     * 根据名称 获取bean
     *
     * @param name 注册的bean名称
     * @return T
     * @author ming
     * @date 11:19
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) {
        checkApplicationContext();
        return (T) APPLICATION_CONTEXT.getBean(name);
    }

    /**
     * 根据类型 获取bean
     *
     * @param clazz 注册bean的类型
     * @return T
     * @author ming
     * @date 11:20
     */
    public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        return APPLICATION_CONTEXT.getBean(clazz);
    }

    public static <T> T getBean(String beanName, Class<T> clazz) {
        checkApplicationContext();
        return APPLICATION_CONTEXT.getBean(beanName, clazz);
    }

    /**
     * 获取application中所有注册的bean 列表
     *
     * @return String[]
     * @author ming
     * @date 2017-08-28 16点
     */
    public static String[] getBeanDefinitionNames() {
        checkApplicationContext();
        return APPLICATION_CONTEXT.getBeanDefinitionNames();
    }

    /**
     * 统计application中所有bean的数量
     *
     * @return Integer
     * @author ming
     * @date 2017-08-28 17点
     */
    public static Integer getBeanDefinitionCount() {
        checkApplicationContext();
        return APPLICATION_CONTEXT.getBeanDefinitionCount();
    }

    /**
     * 根据注解获取 beanNameList
     *
     * @param annotation
     * @return String[]
     * @author ming
     * @date 2017-08-28 16点
     */
    public static String[] getBeanNameListByAnnotation(Class<? extends Annotation> annotation) {
        checkApplicationContext();
        return APPLICATION_CONTEXT.getBeanNamesForAnnotation(annotation);
    }

    /**
     * 根据bean类型获取所有的bean
     *
     * @param clazz
     * @return String[]
     * @author ming
     * @date 2017-08-28 16点
     */
    public static String[] getBeanNamesForType(Class clazz) {
        checkApplicationContext();
        return APPLICATION_CONTEXT.getBeanNamesForType(clazz);
    }

    /**
     * 根据类型 获取 所有这个类型的bean  map 键为bean名字  值为注册的bean
     *
     * @param clazz
     * @return Map
     * @author ming
     * @date 2017-08-28 16点
     */
    public static <T> Map<String, T> getBeansOfType(Class<T> clazz) {
        checkApplicationContext();
        return APPLICATION_CONTEXT.getBeansOfType(clazz);
    }

    /**
     * 检测applicationcontext是否可用
     *
     * @author ming
     * @date 2017-08-28 17点
     */
    private static void checkApplicationContext() {
        if (APPLICATION_CONTEXT == null) {
            throw new NullPointerException("spring applicationContext is null !!!");
        }
    }

    /**
     * 检测 defaultListableBeanFactory
     *
     * @author ming
     * @date 2017-11-10 15:47
     */
    private static void checkDefaultListableBeanFactory() {
        if (DEFAULT_LISTABLE_BEAN_FACTORY == null) {
            throw new NullPointerException(" spring defaultListableBeanFactory is null !!!");
        }
    }

    private static void updateApplicationContext(ApplicationContext applicationContext) {
        SpringUtils.APPLICATION_CONTEXT = applicationContext;
    }

    private static void updateDefaultListableBeanFactory(DefaultListableBeanFactory defaultListableBeanFactory) {
        SpringUtils.DEFAULT_LISTABLE_BEAN_FACTORY = defaultListableBeanFactory;
    }

    /**
     * 销毁方法
     *
     * @author ming
     * @date 2017-08-28 17点
     */
    @Override
    public void destroy() throws Exception {
        updateApplicationContext(null);
        updateDefaultListableBeanFactory(null);
    }

    /**
     * 设置上下文
     *
     * @author ming
     * @date 11:17
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        updateApplicationContext(applicationContext);
        //获取 bean factory
        updateDefaultListableBeanFactory((DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory());
    }
}
