package com.rehoshi.model;

import java.util.UUID;

/**
 * 用户
 */
public class User {

    //角色
    public interface Role{
        int USER = 0 ; //用户
        int ADMINE = 1 ;//管理员
    }

    //UUID
    private String id ;
    //账号 账号是惟一的
    private String account ;
    //密码 数据库保存的密码都是md5加密过得
    private String password ;
    //名称
    private String name ;
    //权限
    private Integer role ;
    //登录时生成的凭证
    private String token ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    /**
     * 生成一个新的用户对象 会自动生成id
     * @return
     */
    public static User newUser(){
        return new User().newId() ;
    }

    /**
     * 新生成一个用户id
     * @return
     */
    public User newId(){
        setId(UUID.randomUUID().toString());
        return this ;
    }
}
