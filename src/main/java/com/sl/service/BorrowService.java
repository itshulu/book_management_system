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
     * @param id 要借阅的图书ID
     * @return 要借阅的书的信息
     */
    Book borrowBook(Integer id);

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
     * 获取某个用户借阅信息
     * @return 某个用户借阅信息
     */
    List<Borrow> getUserBorrow();
}
