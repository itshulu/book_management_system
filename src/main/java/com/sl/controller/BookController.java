package com.sl.controller;

import com.sl.entity.Book;
import com.sl.entity.PageBean;
import com.sl.entity.RestModel;
import com.sl.pojo.BookPojo;
import com.sl.service.BookService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public RestModel<BookPojo> saveBook(String name, Integer typeId, String isbn, String author, String press, Integer num) {
        Book book = bookService.saveBook(null, name, typeId, isbn, author, press, num);
        BookPojo oneBook = bookService.findOneBook(book.getId());
        return new RestModel<>(200, " 添加成功", oneBook);
    }

    @PostMapping("/upBook")
    @RequiresPermissions("A")
    public RestModel<BookPojo> modifyBook(Integer id, String name, Integer typeId, String isbn, String author, String press, Integer num) {
        bookService.modifyBook(id, name, typeId, isbn, author, press, num);
        BookPojo bookPojo = bookService.findOneBook(id);
        return new RestModel<>(200, "修改成功", bookPojo);
    }

    @PostMapping("/delBook")
    @RequiresPermissions("A")
    public RestModel<Book> removeBook(Integer id) {
        bookService.removeBook(id);
        return new RestModel<>(200, "删除成功", null);
    }

    @GetMapping("/getBook")
    public RestModel<BookPojo> findOneBook(Integer id) {
        return new RestModel<>(200, "查找成功", bookService.findOneBook(id));
    }

    @GetMapping("/getAllBook")
    public RestModel<PageBean<BookPojo>> findAll(@RequestParam(defaultValue = "1", value = "page") Integer pageNo, @RequestParam(value = "size", defaultValue = "10") Integer pageSize, @RequestParam(value = "typeId", defaultValue = "-1") Integer typeId) {
        PageBean<BookPojo> all = bookService.findAll(pageNo, pageSize, typeId);
        return new RestModel<>(200, "查询成功", all);
    }

    @GetMapping("/searchBook")
    public RestModel<PageBean<BookPojo>> fuzzyQueryBook(@RequestParam(defaultValue = "1", value = "page") Integer pageNo,@RequestParam(value = "size", defaultValue = "10") Integer pageSize, @RequestParam(value = "search") String search, @RequestParam(value = "typeId", defaultValue = "-1") Integer typeId) {
        PageBean<BookPojo> pageBean = bookService.fuzzyQueryBook(search, pageNo, pageSize, typeId);
        return new RestModel<>(200, "查询成功", pageBean);
    }
}
