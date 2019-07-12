package com.rehoshi.service;

import com.rehoshi.dto.PageData;
import com.rehoshi.dto.RespData;
import com.rehoshi.model.User;

public interface UserService {
    /**
     * 登录业务
     * 先将密码进行md5加密再查询数据库
     * @param user
     * @return 成功登录返回true 失败返回false
     */
    RespData<Boolean> login(User user) ;

    /**
     * 用户分页数据
     * @param search 查询的输入框的内容
     * @param pageIndex 页码
     * @param pageSize 每页数据量
     * @return
     */
    RespData<PageData<User>> usersInPage(String search, int pageIndex, int pageSize) ;

    /**
     * 根据id 查找用户
     * @param id 需要查找的用户id
     * @return
     */
    RespData<User> getById(String id) ;

    /**
     * 保存检查账号唯一性
     * 检查完账号之后 重新设置用户UUID
     * @param user 需要保存的用户信息
     * @return 保存成功返回用户id 失败返回null
     */
    RespData<String> save(User user) ;

    /**
     * 根据用户id 修改用户数据
     * @param user
     * @return 成功返回true 失败返回false
     */
    RespData<Boolean> update(User user) ;

    /**
     * 删除用户数据
     * @param id 用户id
     * @return 成功返回true  失败返回 false
     */
    RespData<Boolean> deleteById(String id) ;


}
