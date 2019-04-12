package com.sl.controller;

import com.sl.entity.BookType;
import com.sl.entity.RestModel;
import com.sl.service.BookTypeService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
        return new RestModel<>(200, "查询成功", bookTypeService.getAll());
    }

    @PostMapping("/addType")
    @RequiresPermissions("A")
    public RestModel<BookType> saveType(String name) {
        BookType bookType = new BookType();
        bookType.setName(name);
        bookTypeService.saveType(bookType);
        return new RestModel<>(200, "添加成功", bookType);
    }

    @DeleteMapping("/delType")
    @RequiresPermissions("A")
    public RestModel<BookType> removeType(Integer id) {
        bookTypeService.removeType(id);
        return new RestModel<>(200, "删除成功", null);
    }

    @PutMapping("/upType")
    @RequiresPermissions("A")
    public RestModel<BookType> modifyType(Integer id, String name) {
        BookType bookType = new BookType(id, name);
        bookTypeService.modifyType(bookType);
        return new RestModel<>(200, "修改成功", bookType);
    }
}
