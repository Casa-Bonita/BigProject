package ru.study.homework.atomic.task2;

public class User {
    private String login;
    private String password;
    private String number;

    public User() {
    }

    public User(String login, String password, String number){
        this.login = login;
        this.password = password;
        this.number = number;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getNumber() {
        return number;
    }
}
