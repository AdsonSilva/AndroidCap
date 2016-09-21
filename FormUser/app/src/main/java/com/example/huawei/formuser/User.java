package com.example.huawei.formuser;

import java.io.Serializable;

/**
 * Created by huawei on 20/09/16.
 */
public class User implements Serializable {

    private String name, email, birthDate, password, login;

    public User(String name, String login, String email, String birthDAte, String password){
        this.name = name;
        this.email = email;
        this.birthDate = birthDAte;
        this.password = password;
        this.login = login;
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

    public String getLogin(){
        return login;
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
