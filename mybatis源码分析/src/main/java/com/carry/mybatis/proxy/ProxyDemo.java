package com.carry.mybatis.proxy;

import java.lang.reflect.Proxy;

public class ProxyDemo {

    public static void main(String[] args) {

        Student student = new Student("张三");
        StuProxy stuProxy = new StuProxy(student);
        Person person = (Person) Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[]{Person.class}, stuProxy);
        person.giveMoney();
    }
}



