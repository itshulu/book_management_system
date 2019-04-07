package com.sl.controller;

import com.sl.entity.Book;
import com.sl.entity.RestModel;
import com.sl.service.BookService;
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
    public RestModel<Book> saveBook(String name,Integer typeId,String isbn,String author,String press,Integer num) {
        Book book = new Book(null, name, typeId, isbn, author, press, num);
        bookService.saveBook(book);
        return new RestModel<>(200,"添加成功",book);
    }
    @PutMapping("/upBook")
    public RestModel<Book> modifyBook(Integer id, String name, Integer typeId, String isbn, String author, String press, Integer num){
        Book book = new Book(id, name, typeId, isbn, author, press, num);
        bookService.modifyBook(book);
        return new RestModel<>(200,"修改成功",book);
    }
    @DeleteMapping("/delBook")
    public RestModel<Book> removeBook(Integer id){
        bookService.removeBook(id);
        return new RestModel<>(200,"删除成功",null);
    }
    @GetMapping("getBook")
    public RestModel<Book> findOneBook(Integer id){
        return new RestModel<>(200,"查找成功",bookService.findOneBook(id));
    }
}
