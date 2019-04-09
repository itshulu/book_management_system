package com.sl.service.impl;

import com.github.pagehelper.PageHelper;
import com.sl.dao.BookDao;
import com.sl.entity.Book;
import com.sl.entity.PageBean;
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
        Book oneBook = bookDao.findOneBookByIsbn(book.getIsbn());
        if (oneBook!=null){
            bookDao.modifyBookNum(book);
        }else {
            bookDao.saveBook(book);
        }

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

    @Override
    public PageBean<Book> findAll(Integer pageNo, Integer pageSize, Integer typeId) {
        PageHelper.startPage(pageNo, pageSize);
        PageBean<Book> pageBean = new PageBean<>(bookDao.findBooks(typeId));
        return pageBean;
    }

    @Override
    public PageBean<Book> fuzzyQueryBook(String search, Integer page, Integer size, Integer typeId) {
        PageHelper.startPage(page, size);
        PageBean<Book> pageBean = new PageBean<>(bookDao.fuzzyQueryBook(search, typeId));
        return pageBean;
    }

    @Override
    public void modifyBookReduceNum(Book book) {
        bookDao.modifyBookReduceNum(book);
    }

    @Override
    public void modifyBookAddNum(Book book) {
        bookDao.modifyBookAddNum(book);
    }


}
