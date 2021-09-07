package com.qiao.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * User 用户的实体类
 */
public class User implements Serializable {
    /**
     * 0代表管理员,  1代表普通用户
     */
    private static final int USER_ADMIN = 0;
    private static final int USER_NORMAL = 1;
    /**
     * 0代表用户未被锁定, 1代表用户锁定
     */
    private static final int USER_UNLOCK = 0;
    private static final int USER_LOCK = 1;
    /**
     * 用户的基本属性
     */
    private Integer userId;
    private String userName;
    private String password;
    private Integer userPhone;
    private String userEmail;
    private String userSex;
    private Timestamp createTime;
    private Integer userType;
    private Integer userState;
    private Integer credit;
    private Timestamp lastLoginTime;
    private String lastIp;

    public User() {
    }

    public User(Integer userId, String userName, String password,
                Integer userPhone, String userEmail, String userSex, Timestamp createTime,
                Integer userType, Integer userState, Integer credit, Timestamp lastLoginTime, String lastIp) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userPhone = userPhone;
        this.userEmail = userEmail;
        this.userSex = userSex;
        this.createTime = createTime;
        this.userType = userType;
        this.userState = userState;
        this.credit = credit;
        this.lastLoginTime = lastLoginTime;
        this.lastIp = lastIp;
    }

    public static int getUserAdmin() {
        return USER_ADMIN;
    }

    public static int getUserNormal() {
        return USER_NORMAL;
    }

    public static int getUserUnlock() {
        return USER_UNLOCK;
    }

    public static int getUserLock() {
        return USER_LOCK;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(Integer userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public Integer getUserState() {
        return userState;
    }

    public void setUserState(Integer userState) {
        this.userState = userState;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Timestamp getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Timestamp lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    @Override
    public String toString() {
        return "User {" +
                "userId =  " + userId +
                ", userName = " + userName +
                ", password = " + password +
                ", userPhone = " + userPhone +
                ", userEmail = " + userEmail +
                ", userSex = " + userSex +
                ", createTime = " + createTime +
                ", userType = " + userType +
                ", userState = " + userState +
                ", lastLoginTime = " + lastLoginTime +
                ", lastIp = " + lastIp + "}";
    }
}
