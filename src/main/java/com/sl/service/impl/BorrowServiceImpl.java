package com.sl.service.impl;

import com.sl.dao.BorrowDao;
import com.sl.entity.Book;
import com.sl.entity.Borrow;
import com.sl.entity.User;
import com.sl.service.BorrowService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ShuLu
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    private final BorrowDao borrowDao;

    @Autowired
    public BorrowServiceImpl(BorrowDao borrowDao) {
        this.borrowDao = borrowDao;
    }

    @Override
    public void borrowBook(Book book) {
        borrowDao.borrowBook(book);
    }

    @Override
    public Book remandBook(Integer id) {
        return borrowDao.remandBook(id);
    }

    @Override
    public List<Borrow> getBookBorrow(Integer id) {
        return borrowDao.getBookBorrow(id);
    }

    @Override
    public List<Borrow> getUserBorrow() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<Borrow> userBorrow = borrowDao.getUserBorrow(user.getId());
        return userBorrow;
    }
    @Override
    public Book findOneBook(Integer id) {
        return borrowDao.findOneBook(id);
    }
}
