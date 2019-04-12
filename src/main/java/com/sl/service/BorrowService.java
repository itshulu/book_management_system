package com.sl.service;

import com.sl.entity.Borrow;

import java.util.List;

/**
 * @author ShuLu
 */
public interface BorrowService {



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

}
