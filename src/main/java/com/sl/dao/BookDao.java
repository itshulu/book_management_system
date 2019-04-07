package com.sl.dao;

import com.sl.entity.Book;

import java.util.List;

/**
 * @author ShuLu
 */
public interface BookDao {
    /**
     * 查询所有
     * @return
     */
    List<Book> findBooks();

    /**
     *添加书本
     * @param book
     */
    void  saveBook(Book book);

    /**
     * 修改书本信息
     * @param book
     */
    void modifyBook(Book  book);

    /**
     * 根据书籍ID删除书本
     * @param id
     */
    void removeBook(Integer id);

    /**
     * 模糊搜索图书名
     * @return
     */
    List<Book> fuzzyQueryBook();

    /**
     *根据id查询书籍具体信息
     * @param id 书籍ID
     * @return 返回书籍对象
     */
    Book findOneBook(Integer id);
}
