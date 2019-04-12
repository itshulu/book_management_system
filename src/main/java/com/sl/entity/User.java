package com.sl.entity;

import java.io.Serializable;

/**
 * @author ShuLu
 */
public class User implements Serializable {
    private Integer id;
    private String name;
    private String password;
    private String percode;

    public User() {
    }

    public User(Integer id, String name, String password, String percode) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.percode = percode;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPercode() {
        return percode;
    }

    public void setPercode(String percode) {
        this.percode = percode;
    }
}
