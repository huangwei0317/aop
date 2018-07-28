package com.hww.aop;

public class User {
    private Integer age = 10;

    private String name;
    private String time;

    public User() {
    }

    public User(Integer age, String name, String time) {
        this.age = age;
        this.name = name;
        this.time = time;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
