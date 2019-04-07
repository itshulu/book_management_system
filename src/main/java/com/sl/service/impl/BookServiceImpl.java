package com.sl.service.impl;

import com.sl.dao.BookDao;
import com.sl.entity.Book;
import com.sl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ShuLu
 */
@Service
public class BookServiceImpl implements BookService {
    private final BookDao bookDao;

    @Autowired
    public BookServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public void saveBook(Book book) {
        bookDao.saveBook(book);
    }

    @Override
    public void modifyBook(Book book) {
        bookDao.modifyBook(book);
    }

    @Override
    public void removeBook(Integer id) {
        bookDao.removeBook(id);
    }

    @Override
    public Book findOneBook(Integer id) {
        return bookDao.findOneBook(id);
    }
}
