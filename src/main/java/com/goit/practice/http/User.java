package com.goit.practice.http;

public class User {
    private int id;
    private String name;
    private String surname;
    private int salary;
    private String gender;

    public User() {
    }

    public User(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.surname = builder.surname;
        this.salary = builder.salary;
        this.gender = builder.gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return name;
    }

    public static class Builder{
        private int id;
        private String name;
        private String surname;
        private int salary;
        private String gender;

        public Builder id (int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder surname(String surname) {
            surname = surname;
            return this;
        }

        public Builder salary(int salary) {
            salary = salary;
            return this;
        }

        public Builder gender(String gender) {
            gender = gender;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
