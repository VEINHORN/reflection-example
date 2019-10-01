package com.veinhorn.reflection;

public class User {
    public Integer id;
    public String username;
    public User parentUser;
    public Order order;

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;
    }

    public User(Integer id, String username, User parentUser) {
        this.id = id;
        this.username = username;
        this.parentUser = parentUser;

        this.order = new Order(1234, 123232);
    }
}
