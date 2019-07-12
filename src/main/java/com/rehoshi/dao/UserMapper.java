package com.rehoshi.dao;

import com.rehoshi.model.User;

import java.util.List;

public interface UserMapper {

    /**
     * 保存用户数据
     * @return 返回影响行数
     */
    int save(User user) ;


    /**
     * 根据用户ID 更新用户数据
     * @param user 需要更新的用户数据 需要包含ID
     * @return 返回影响行数
     */
    int update(User user) ;

    /**
     * 删除用户
     * @param id 用户id
     * @return 返回影响行数
     */
    int deleteById(String id) ;

    /**
     * 根据查询条件返回查数据行数
     * @param search
     * @return 返回影响行数
     */
    int countBySearch(String search) ;

    /**
     * 根据条件查找用户
     * @param search 查找内容
     * @return 查询到的用户列表
     */
    List<User> getBySearch(String search) ;

    /**
     * 查找用户
     * @param id 需要查找的用户id
     * @return 查找到的用户信息
     */
    User getById(String id) ;

    /**
     * 查找用户
     * @param account 需要查找的用户账号
     * @return
     */
    User getByAccount(String account) ;

}
