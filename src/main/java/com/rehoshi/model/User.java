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
    //账号
    private String account ;
    //密码
    private String password ;
    //名称
    private String name ;
    //权限
    private Integer role ;

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

    public static User newUser(){
        User user = new User() ;
        user.setId(UUID.randomUUID().toString());
        return user ;
    }
}
