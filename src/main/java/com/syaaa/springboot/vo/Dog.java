package com.syaaa.springboot.vo;

/**
 * @ClassName Dog
 * @Description TODO
 * @Author APPO
 * @Date 13:04   2018-9-12
 * @Version 1.0
 **/
public class Dog {

    /***
     * 姓名
     */
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
