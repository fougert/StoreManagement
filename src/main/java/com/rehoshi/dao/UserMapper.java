package com.rehoshi.dao;

import com.rehoshi.model.User;

import java.util.List;

public interface UserMapper {

    int save(User user) ;

    int update(User user) ;

    int deleteById(String id) ;

    List<User> queryAll() ;

}
