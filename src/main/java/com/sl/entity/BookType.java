package com.sl.entity;

import java.io.Serializable;

/**
 * @author ShuLu
 */
public class BookType implements Serializable {
    /**
     * 类别ID
     */
    private Integer id;
    /**
     * 类别名
     */

    private String name;

    public BookType() {
    }

    public BookType(Integer id, String name) {
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

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BookType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
