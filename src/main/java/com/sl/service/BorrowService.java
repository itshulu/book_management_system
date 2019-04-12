package com.sl.service;

import com.sl.entity.Book;
import com.sl.entity.Borrow;

import java.util.List;

/**
 * @author ShuLu
 */
public interface BorrowService {
    /**
     * 借阅书籍
     * @param book 要借阅的图书
     * @return 要借阅的书的信息
     */
    void borrowBook(Book book);

    /**
     * 归还图书
     * @param id 归还的书ID
     * @return 归还书籍的信息
     */
    Book remandBook(Integer id);
    /**
     * 获取某个图书的借阅信息
     * @param id 图书标识id
     * @return 某个图书借阅信息
     */
    List<Borrow> getBookBorrow(Integer id);

    /**
     * 获取用户借阅书籍
     * @return
     */
    List<Borrow> getUserBorrow();
    /**
     * @param id 书籍ID
     * @return 返回书籍对象
     */
    Book findOneBook(Integer id);
}
