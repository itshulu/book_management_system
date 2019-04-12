package com.sl.service.impl;

import com.sl.dao.BookTypeDao;
import com.sl.entity.BookType;
import com.sl.exception.NoFindBookType;
import com.sl.exception.NotNameException;
import com.sl.exception.NullIdException;
import com.sl.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return bookTypeDao.getAll();
    }


    @Override
    public void saveType(BookType bookType) {
        bookTypeDao.saveType(bookType);
    }

    @Override
    public void removeType(Integer id) {
        if (id == null) {
            throw new NullIdException("输入有误！", HttpStatus.NOT_ACCEPTABLE);
        }
        BookType one = bookTypeDao.findOne(id);
        if (one == null) {
            throw new NoFindBookType("要删除的类型不存在",HttpStatus.NOT_FOUND);
        }
        bookTypeDao.removeType(id);
    }

    @Override
    public void modifyType(BookType bookType) {
        if (bookType.getName()!=null){
            bookTypeDao.modifyType(bookType);
        }
        throw new NotNameException("修改类型名为空",HttpStatus.NOT_ACCEPTABLE);
    }
}
