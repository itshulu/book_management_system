package com.sl.service;

import com.sl.entity.Book;

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
}
