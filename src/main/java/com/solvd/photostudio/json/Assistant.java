package com.solvd.photostudio.json;

public class Assistant {
    private String name;
    private int age;
    private String position;
    private int salary;

    public Assistant() {
    }

    public Assistant (String name, int age, String position, int salary) {
        this.setName(name);
        this.setAge(age);
        this.setPosition(position);
        this.setSalary(salary);
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}