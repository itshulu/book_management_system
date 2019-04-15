package com.sl.service;

import com.sl.entity.Book;
import com.sl.entity.PageBean;
import com.sl.exception.NullIdException;

/**
 * @author ShuLu
 */
public interface BookService {
    /**
     *
     * @param id
     * @param name
     * @param typeId
     * @param typeName
     * @param isbn
     * @param author
     * @param press
     * @param num
     * @return
     */
    Book  saveBook(Integer id, String name, Integer typeId,String typeName, String isbn, String author, String press, Integer num);

    /**
     * @param id
     * @param name
     * @param typeId
     * @param typeName
     * @param isbn
     * @param author
     * @param press
     * @param num
     */
    void modifyBook(Integer id, String name, Integer typeId,String typeName, String isbn, String author, String press, Integer num);

    /**
     * @param id
     */
    void removeBook(Integer id) throws NullIdException;
    /**
     * @param id 书籍ID
     * @return 返回书籍对象
     */
    Book findOneBook(Integer id);

    /**
     * 获取所有书籍信息
     * @return list
     */
    PageBean<Book> findAll(Integer pageNo, Integer pageSize,Integer typeId);
    /**
     * 模糊搜索图书名
     * @return
     */
    PageBean<Book> fuzzyQueryBook(String search,Integer size,Integer page,Integer typeId);
    /**
     * 借阅图书时已存在图书信息，减少数量即可
     * @param book 借阅的书籍信息
     * @return 返回书籍信息
     */
    void modifyBookReduceNum(Book book);
    /**
     * 归还图书时已存在图书信息，增加数量即可
     * @param book 借阅的书籍信息
     * @return 返回书籍信息
     */
    void modifyBookAddNum(Book book);
}
