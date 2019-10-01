package com.veinhorn.reflection;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        User user = new User(1, "test user", new User(0, "root user"));
        System.out.println(new JsonConverter().convert(user));
    }
}
