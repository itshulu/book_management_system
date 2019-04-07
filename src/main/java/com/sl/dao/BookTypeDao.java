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
     * @param bookType 类别对象
     */
    void saveType(BookType bookType);

    /**
     * 删除类别
     * @param id 类别 id
     * @return
     */
    void removeType(Integer id);

    /**
     * 添加修改后的类别对象
     * @param bookType 类别对象
     */
    void modifyType(BookType bookType);
}
