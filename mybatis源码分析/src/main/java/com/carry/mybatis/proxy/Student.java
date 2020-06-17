package com.carry.mybatis.proxy;

public class Student implements Person {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(this.name+"上交班费50元");
    }
}
