package com.example.huawei.formuser;

/**
 * Created by huawei on 20/09/16.
 */
public class User {

    private String name, email, birthDate, password;

    public User(String name, String email, String birthDAte, String password){
        this.name = name;
        this.email = email;
        this.birthDate = birthDAte;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
