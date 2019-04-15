package com.sl.dao;

import com.sl.entity.Book;
import com.sl.pojo.BookPojo;

import java.util.List;

/**
 * @author ShuLu
 */
public interface BookDao {
    /**
     * 查询所有
     * @param typeId 类型id
     * @return
     */
    List<BookPojo> findBooks(Integer typeId);

    /**
     *添加书本
     * @param book
     */
    void  saveBook(Book book);

    /**
     * 修改书本信息
     * @param book
     */
    void modifyBook(Book  book);

    /**
     * 根据书籍ID删除书本
     * @param id
     */
    void removeBook(Integer id);

    /**
     * 模糊搜索图书名
     * @return
     */
    List<BookPojo> fuzzyQueryBook(String search,Integer typeId);

    /**
     *根据id查询书籍具体信息
     * @param id 书籍ID
     * @return 返回书籍对象
     */
    BookPojo findOneBook(Integer id);

    /**
     * 添加图书时已存在图书信息，添加数量即可
     * @param book
     */
    void modifyBookNum(Book book);
    /**
     *根据id查询书籍编码具体信息
     * @param isbn 书籍ISBN
     * @return 返回书籍对象
     */
    Book findOneBookByIsbn(String isbn);

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

    /**
     * 根据id查找book
     * @param id
     * @return
     */
    Book findBook(Integer id);
}
