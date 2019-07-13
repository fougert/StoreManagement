package com.rehoshi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rehoshi.dao.UserMapper;
import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.model.User;
import com.rehoshi.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper ;

    @Override
    public RespData<Boolean> login(User user) {
        return null;
    }

    @Override
    public PageData<User> usersInPage(String search, int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex - 1, pageSize) ;
        List<User> bySearch = userMapper.getBySearch("%"+search+"%");
        PageInfo<User> userPageInfo = new PageInfo<>(bySearch);
        return new PageData<>(userPageInfo) ;
    }

    @Override
    public RespData<User> getById(String id) {
        return null;
    }

    @Override
    public RespData<String> save(User user) {
        return null;
    }

    @Override
    public RespData<Boolean> update(User user) {
        return null;
    }

    @Override
    public RespData<Boolean> deleteById(String id) {
        return null;
    }
}
