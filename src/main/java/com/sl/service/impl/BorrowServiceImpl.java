package com.sl.service.impl;

import com.sl.dao.BorrowDao;
import com.sl.entity.Borrow;
import com.sl.entity.User;
import com.sl.pojo.BorrowPojo;
import com.sl.service.BorrowService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ShuLu
 */
@Service
public class BorrowServiceImpl implements BorrowService {
    private final BorrowDao borrowDao;

    @Autowired
    public BorrowServiceImpl(BorrowDao borrowDao) {
        this.borrowDao = borrowDao;
    }



    @Override
    public List<Borrow> getBookBorrow(Integer id) {
        return borrowDao.getBookBorrow(id);
    }

    @Override
    public List<BorrowPojo> getUserBorrow() {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        List<BorrowPojo> userBorrow = borrowDao.getUserBorrow(user.getId());
        return userBorrow;
    }

}
