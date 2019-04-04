package com.sl.service.impl;

import com.sl.dao.BookTypeDao;
import com.sl.entity.BookType;
import com.sl.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ShuLu
 */
@Service
public class BookTypeServiceImpl implements BookTypeService {
    private final BookTypeDao bookTypeDao;

    @Autowired
    public BookTypeServiceImpl(BookTypeDao bookTypeDao) {
        this.bookTypeDao = bookTypeDao;
    }

    @Override
    public List<BookType> getAll() {
        return  bookTypeDao.getAll();
    }


    @Override
    public void saveType(BookType bookType){
        bookTypeDao.saveType(bookType);
    }

    @Override
    public void removeType(Integer id) {
        bookTypeDao.removeType(id);
    }

    @Override
    public void modifyType(BookType bookType) {
        bookTypeDao.modifyType(bookType);
    }
}
