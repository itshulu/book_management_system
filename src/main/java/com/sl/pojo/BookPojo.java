package com.sl.pojo;

public class BookPojo {
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
     * 类别名
     */
    private String typeName;
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

    public BookPojo() {
    }

    public BookPojo(Integer id, String name, Integer typeId, String typeName, String isbn, String author, String press, Integer num) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.typeName = typeName;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    @Override
    public String toString() {
        return "BookPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", press='" + press + '\'' +
                ", num=" + num +
                '}';
    }
}
