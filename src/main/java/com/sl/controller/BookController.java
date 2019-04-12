package com.sl.controller;

import com.sl.entity.Book;
import com.sl.entity.PageBean;
import com.sl.entity.RestModel;
import com.sl.service.BookService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ShuLu
 */
@RestController
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    @RequiresPermissions("A")
    public RestModel<Book> saveBook(String name, Integer typeId, String isbn, String author, String press, Integer num) {
        Book book = bookService.saveBook(null, name, typeId, isbn, author, press, num);
        return new RestModel<>(200, "添加成功", book);
    }

    @PutMapping("/upBook")
    @RequiresPermissions("A")
    public RestModel<Book> modifyBook(Integer id, String name, Integer typeId, String isbn, String author, String press, Integer num) {
        bookService.modifyBook(id, name, typeId, isbn, author, press, num);
        Book book =bookService.findOneBook(id);
        return new RestModel<>(200, "修改成功", book);
    }

    @DeleteMapping("/delBook")
    @RequiresPermissions("A")
    public RestModel<Book> removeBook(Integer id) {
        bookService.removeBook(id);
        return new RestModel<>(200, "删除成功", null);
    }

    @GetMapping("/getBook")
    public RestModel<Book> findOneBook(Integer id) {
        Book book = bookService.findOneBook(id);
        return new RestModel<>(200, "查找成功", bookService.findOneBook(id));
    }

    @GetMapping("/getAllBook")
    public RestModel<PageBean<Book>> findAll(@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo, Integer pageSize, @RequestParam(value = "typeId", defaultValue = "-1") Integer typeId) {
        PageBean<Book> all = bookService.findAll(pageNo, pageSize, typeId);
        return new RestModel<>(200, "查询成功", all);
    }

    @GetMapping("/searchBook")
    public RestModel<PageBean<Book>> fuzzyQueryBook(@RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo, Integer pageSize, @RequestParam(value = "search") String search, @RequestParam(value = "typeId", defaultValue = "-1") Integer typeId) {
        PageBean<Book> pageBean = bookService.fuzzyQueryBook(search, pageNo, pageSize, typeId);
        return new RestModel<>(200, "查询成功", pageBean);
    }
}
