package com.sl.entity;

import java.io.Serializable;

/**
 * @author ShuLu
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private Integer password;

    public User() {
    }

    public User(Integer id, String name, Integer password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
}
