package com.kodilla.user;

public class SimpleUser {
    private String username;
    private String realname;

    public SimpleUser(String username, String realname) {
        this.username = username;
        this.realname = realname;
    }

    public SimpleUser(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public String getUsername() {
        return username;
    }
}
