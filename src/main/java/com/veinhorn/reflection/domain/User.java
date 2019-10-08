package com.veinhorn.reflection.domain;

import com.veinhorn.reflection.annotation.JsonField;

import java.util.Arrays;
import java.util.List;

public class User {
    @JsonField
    public Integer id;
    public String username;
    public User parentUser;
    public List<Order> orders;

    public User(Integer id, String username) {
        this.id = id;
        this.username = username;

        this.orders = Arrays.asList(
                new Order(1234, 123232),
                new Order(345, 4567688)
        );
    }

    public User(Integer id, String username, User parentUser) {
        this.id = id;
        this.username = username;
        this.parentUser = parentUser;

        this.orders = Arrays.asList(
                new Order(1234, 123232),
                new Order(345, 4567688)
        );
    }
}
