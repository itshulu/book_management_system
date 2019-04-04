package com.sl.service.impl;

import com.sl.dao.BookTypeDao;
import com.sl.entity.BookType;
import com.sl.entity.RestModel;
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
    public RestModel<List<BookType>> getAll() {
        return new RestModel<>(200,"查询成功",bookTypeDao.getAll());
    }

    @Override
    public RestModel<BookType> saveType(String name) {
        return new RestModel<>(200,"添加成功",bookTypeDao.saveType(name));
    }

    @Override
    public RestModel<BookType> removeType(Integer id) {
        return new RestModel<>(200,"删除成功",bookTypeDao.removeType(id));
    }

    @Override
    public RestModel<BookType> modifyType(Integer id, String name) {
        return new RestModel<>(200,"修改成功",bookTypeDao.modifyType(id,name));
    }
}
