package com.sl.dao;

import com.sl.entity.Borrow;

import java.util.List;

/**
 * @author ShuLu
 */
public interface BorrowDao {

    /**
     * 获取某个图书的借阅信息
     * @param id 图书标识id
     * @return 某个图书借阅信息
     */
    List<Borrow> getBookBorrow(Integer id);

    /**
     * 获取某个用户借阅信息
     * @param id 用户id
     * @return
     */
    List<Borrow> getUserBorrow(Integer id);

}
