package org.example;

public class Person {
    public String name;
    public int age;
    public String gender;
    public String email;

    public Person(String name, int age, String gender, String email) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    @Override
    public String toString(){
        return "name :" + name + " age :" + age + " gender :" + gender + " email :" + email;
    }


}


