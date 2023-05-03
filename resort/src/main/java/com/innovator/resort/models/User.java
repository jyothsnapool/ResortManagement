package com.innovator.resort.models;

import jakarta.persistence.*;

/**
 * User Model Class
 * Entity Class
 */
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "f_name")
    private String f_name;

    @Column(name = "l_name")
    private String l_name;

    @Column(name = "age")
    private int age;

    @Column(name = "sex")
    private String sex;

    @Column(name = "city")
    private String city;

    public User() {

    }

    public User(long id, String f_name, String l_name, int age, String sex, String city) {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.age = age;
        this.sex = sex;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", f_name='" + f_name + '\'' +
                ", l_name='" + l_name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
