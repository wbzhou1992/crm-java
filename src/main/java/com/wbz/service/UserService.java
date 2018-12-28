package com.wbz.service;

import com.github.pagehelper.PageInfo;
import com.wbz.model.User;

public interface UserService {
    int addUser(User user);
    PageInfo<User> findAllUser(int pageNum,int pageSize);

}
