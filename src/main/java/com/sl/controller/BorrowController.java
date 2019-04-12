package com.sl.controller;

import com.sl.entity.Book;
import com.sl.entity.Borrow;
import com.sl.entity.RestModel;
import com.sl.service.BookService;
import com.sl.service.BorrowService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ShuLu
 */
@RestController
public class BorrowController {
    private final BorrowService borrowService;
    private final BookService bookService;

    @Autowired
    public BorrowController(BorrowService borrowService, BookService bookService) {
        this.borrowService = borrowService;
        this.bookService = bookService;
    }

    @GetMapping("/getBookBorrow")
    public RestModel<List<Borrow>> getBookBorrow(Integer id) {
        List<Borrow> bookBorrow = borrowService.getBookBorrow(id);
        return new RestModel<>(200, "查询成功", bookBorrow);
    }

    @PostMapping("/borrow")
    @RequiresPermissions("U")
    public RestModel<Book> borrowBook(Integer id) {
        Book book = bookService.findOneBook(id);
        bookService.modifyBookReduceNum(book);
        Book oneBook = bookService.findOneBook(id);
        return new RestModel<>(200, "借阅成功", oneBook);
    }

    @PostMapping("/remand")
    @RequiresPermissions("U")
    public RestModel<Book> remandBook(Integer id) {
        bookService.modifyBookAddNum(bookService.findOneBook(id));
        Book oneBook = bookService.findOneBook(id);
        return new RestModel<>(200, "归还成功", oneBook);
    }

    @GetMapping("/getUserBorrow")
    @RequiresPermissions("U")
    public RestModel<List<Borrow>> getUserBorrow() {
        List<Borrow> userBorrow = borrowService.getUserBorrow();
        return new RestModel<>(200, "查找成功", userBorrow);
    }
}
