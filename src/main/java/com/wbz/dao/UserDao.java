package com.wbz.dao;

import com.wbz.model.User;

import java.util.List;

public interface UserDao {
    int insert(User user);
    List<User> selectUsers();

}

