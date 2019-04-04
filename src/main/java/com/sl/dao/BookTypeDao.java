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
    void saveType(BookType bookType);

    /**
     * 删除类别
     * @param id 类别 id
     * @return
     */
    void removeType(Integer id);

    /**
     * 修改类别名
     * @param id 类别id
     * @param name 新类别名
     * @return
     */
    void modifyType(BookType bookType);
}
