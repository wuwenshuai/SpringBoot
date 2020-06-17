package com.carry.mybatis.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StuProxy implements InvocationHandler {

    private Student student;

    public StuProxy(Student student) {
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName());
        Object invoke = method.invoke(student, args);
        System.out.println("代理结束");
        return invoke;
    }
}
