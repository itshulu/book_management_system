package com.sl.service.impl;

import com.sl.dao.BorrowDao;
import com.sl.entity.Book;
import com.sl.entity.Borrow;
import com.sl.service.BorrowService;
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
    public Book borrowBook(Integer id) {
        return null;
    }

    @Override
    public Book remandBook(Integer id) {
        return null;
    }

    @Override
    public List<Borrow> getBookBorrow(Integer id) {
        return borrowDao.getBookBorrow(id);
    }

    @Override
    public List<Borrow> getUserBorrow() {
        return null;
    }
}
