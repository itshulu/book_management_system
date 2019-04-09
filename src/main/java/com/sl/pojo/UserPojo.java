package com.sl.pojo;

/**
 * @author ShuLu
 */
public class UserPojo {
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
