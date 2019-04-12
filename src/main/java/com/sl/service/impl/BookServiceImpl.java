package com.sl.service.impl;

import com.github.pagehelper.PageHelper;
import com.sl.dao.BookDao;
import com.sl.entity.Book;
import com.sl.entity.PageBean;
import com.sl.exception.BookNumNullException;
import com.sl.exception.NullFindBookException;
import com.sl.exception.NullIdException;
import com.sl.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public Book saveBook(Integer id, String name, Integer typeId, String isbn, String author, String press, Integer num) {
        Book book = new Book(null, name, typeId, isbn, author, press, num);
        Book oneBook = bookDao.findOneBookByIsbn(book.getIsbn());
        if (oneBook != null) {
            bookDao.modifyBookNum(book);
        } else {
            bookDao.saveBook(book);
        }
        return book;
    }

    @Override
    public void modifyBook(Integer id, String name, Integer typeId, String isbn, String author, String press, Integer num) {
        Book book = new Book(id, name, typeId, isbn, author, press, num);
        bookDao.modifyBook(book);
    }

    @Override
    public void removeBook(Integer id) {
        if (id != null) {
            bookDao.removeBook(id);
        }
        throw new NullIdException("未找到要删除的ID", HttpStatus.NOT_FOUND);
    }

    @Override
    public Book findOneBook(Integer id) {
        if (id != null) {
            return bookDao.findOneBook(id);
        }
        throw new NullIdException("未找到要删除的ID", HttpStatus.NOT_FOUND);
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
        if (book == null) {
            throw new NullFindBookException("未找到借阅图书", HttpStatus.NOT_FOUND);
        } else if (book.getNum() <= 0) {
            throw new BookNumNullException("该书籍已借完！请借阅其它书籍！", HttpStatus.CONFLICT);
        }
        bookDao.modifyBookReduceNum(book);
    }

    @Override
    public void modifyBookAddNum(Book book) {
        if (book == null) {
            throw new NullFindBookException("未找到要归还的图书，请重新输入", HttpStatus.NOT_FOUND);
        }
        bookDao.modifyBookAddNum(book);
    }


}
