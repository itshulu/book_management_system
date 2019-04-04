package com.sl.controller;

import com.sl.entity.BookType;
import com.sl.entity.RestModel;
import com.sl.service.BookTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public RestModel<List<BookType>> getAll() {
        return new RestModel<>(200,"查询成功",bookTypeService.getAll());
    }

    @PostMapping("/addType")
    public RestModel<BookType> saveType(String name) {
        BookType bookType = new BookType();
        bookType.setName(name);
        bookTypeService.saveType(bookType);
        return new RestModel<>(200,"添加成功",bookType);
    }
    @DeleteMapping("/delType")
    public RestModel<BookType> removeType(Integer id){
        bookTypeService.removeType(id);
        return new RestModel<BookType>(200,"删除成功",null);
    }
    @PutMapping("/upType")
    public RestModel<BookType> modifyType(Integer id,String name){
        BookType bookType = new BookType();
        bookType.setId(id);
        bookType.setName(name);
        bookTypeService.modifyType(bookType);
        return new RestModel<>(200,"修改成功",bookType);
    }
}
