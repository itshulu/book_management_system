package com.sl.service;

import com.sl.entity.BookType;
import com.sl.entity.RestModel;

import java.util.List;

/**
 * @author ShuLu
 */
public interface BookTypeService {
    /**
     * 获取所有类别
     * @return
     */
    public RestModel<List<BookType>> getAll();

    /**
     * 添加类别
     * @return
     */
    public RestModel<BookType> saveType(String name);

    /**
     * 删除类别
     * @param id 类别 id
     * @return
     */
    public RestModel<BookType> removeType(Integer id);

    /**
     * 修改类别名
     * @param id 类别id
     * @param name 新类别名
     * @return
     */
    public RestModel<BookType> modifyType(Integer id,String name);
}
