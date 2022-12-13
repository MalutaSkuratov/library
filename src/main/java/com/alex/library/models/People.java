package com.alex.library.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class People {

    private int id_people;
    private String surname;
    private String name;
    private int age;

    public People() {
    }

    public People(int id_people, String surname, String name, int age) {
        this.id_people = id_people;
        this.surname = surname;
        this.name = name;
        this.age = age;
    }

    public int getId_people() {
        return id_people;
    }
    public void setId_people(int id_people) {
        this.id_people = id_people;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
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
