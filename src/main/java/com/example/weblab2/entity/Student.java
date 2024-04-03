package com.example.weblab2.entity;


public class Student {
    private String sid;
    private String name;
    private String gender;
    private int age;
    private String birthday;

    public Student() {
    }

    public Student(String sid, String name, String gender, int age, String birthday) {
        this.sid = sid;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.birthday = birthday;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
