package com.sl.service;

import com.sl.entity.Book;
import com.sl.entity.PageBean;

/**
 * @author ShuLu
 */
public interface BookService {
    /**
     * @param book
     */
    void  saveBook(Book book);

    /**
     * @param book
     */
    void modifyBook(Book  book);

    /**
     * @param id
     */
    void removeBook(Integer id);
    /**
     * @param id 书籍ID
     * @return 返回书籍对象
     */
    Book findOneBook(Integer id);

    /**
     * 获取所有书籍信息
     * @return list
     */
    PageBean<Book> findAll(Integer pageNo, Integer pageSize,Integer typeId);
    /**
     * 模糊搜索图书名
     * @return
     */
    PageBean<Book> fuzzyQueryBook(String search,Integer size,Integer page,Integer typeId);
}
