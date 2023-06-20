package com.phonbook.tests;

public class User {
    public String email;
    public String password;

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {

        return email;
    }

    public String getPassword() {

        return password;
    }
}
