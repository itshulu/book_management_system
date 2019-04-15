package com.sl.pojo;

import java.io.Serializable;

/**
 * @author ShuLu
 */
public class UserPojo implements Serializable {
    private Integer id;
    private String name;

    public UserPojo() {
    }

    public UserPojo(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public void setName(String userName) {
        this.name = userName;
    }
}
