package org.shuaihu.vip.iodemo;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int age;
    public Person(String name,int age){
        this.age=age;
        this.name=name;
    }

    @Override
    public String toString() {
        return "姓名："+this.name+"年龄："+this.age;
    }
}
