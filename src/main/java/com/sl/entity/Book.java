package com.sl.entity;

import java.io.Serializable;

public class Book implements Serializable {
    /**
     * 书ID
     */
    private  Integer id;
    /**
     * 书名
     */
    private String name;
    /**
     * 类别ID
     */
    private Integer typeId;
    /**
     * ISBN编码
     */
    private String isbn;
    /**
     * 作者
     */
    private String author;
    /**
     * 出版社
     */
    private String press;
    /**
     * 数量
     */
    private Integer num;

    public Book() {
    }

    public Book(Integer id, String name, Integer typeId, String isbn, String author, String press, Integer num) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.isbn = isbn;
        this.author = author;
        this.press = press;
        this.num = num;
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

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
