package com.sl.controller;

import com.sl.entity.BookType;
import com.sl.entity.RestModel;
import com.sl.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author ShuLu
 */
@RestController
public class BookTypeController {
    private final BookTypeService bookTypeService;

    @Autowired
    public BookTypeController(BookTypeService bookTypeService) {
        this.bookTypeService = bookTypeService;
    }

    @GetMapping("/allType")
    public RestModel<List<BookType>> getAll(){
        return bookTypeService.getAll();
    }
}
