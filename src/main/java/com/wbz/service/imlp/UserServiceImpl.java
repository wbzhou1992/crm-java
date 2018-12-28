package com.wbz.service.imlp;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wbz.dao.UserDao;
import com.wbz.model.User;
import com.wbz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user){
        return  userDao.insert(user);
    }

    @Override
    public PageInfo<User> findAllUser(int pageNum,int pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<User> user = userDao.selectUsers();
        PageInfo result = new PageInfo(user);
        return result;
    }
}
