package com.rehoshi.model;

import com.rehoshi.util.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 用户
 */
public class User extends BaseModel {

    //角色
    public interface Role {
        int USER = 0; //用户
        int ADMIN = 1;//管理员
        int SUPER_ADMIN = 2;//超级管理员
    }
    //UUID
    private String id;
    //账号 账号是惟一的
    private String account;
    //密码 数据库保存的密码都是md5加密过得
    private String password;
    //名称
    private String name;
    //权限
    private Integer role;

    private String roleName;
    //登录时生成的凭证
    private String token;

    private String rePassword;

    private String oldPassword ;

    @DateTimeFormat(pattern = DateUtil.DATETIME_FORMAT)
    private Date createTime ;

    private String createTimeStr ;

    @DateTimeFormat(pattern = DateUtil.DATETIME_FORMAT)
    private Date lastLoginTime ;

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
        switch (getRole()) {
            case Role.USER:
                setRoleName("用户");
                break;
            case Role.ADMIN:
                setRoleName("管理员");
                break;
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
        setCreateTimeStr(DateUtil.formatDate("yyyy-MM-dd HH:mm:ss", createTime));
    }

    public String getCreateTimeStr() {
        return createTimeStr;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public void setCreateTimeStr(String createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    /**
     * 生成一个新的用户对象 会自动生成id
     *
     * @return
     */
    public static User newUser() {
        User user = new User();
        user.newId();
        return user;
    }
}
