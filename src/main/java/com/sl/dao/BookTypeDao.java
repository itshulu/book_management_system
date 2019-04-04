package com.sl.dao;

import com.sl.entity.BookType;

import java.util.List;

/**
 * @author ShuLu
 */
public interface BookTypeDao {
    /**
     * 获取所有类别
     * @return
     */
    List<BookType> getAll();

    /**
     * 添加类别
     * @return
     */
    BookType saveType(String name);

    /**
     * 删除类别
     * @param id 类别 id
     * @return
     */
    BookType removeType(Integer id);

    /**
     * 修改类别名
     * @param id 类别id
     * @param name 新类别名
     * @return
     */
    BookType modifyType(Integer id,String name);
}
