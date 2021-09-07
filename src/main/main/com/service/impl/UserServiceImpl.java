package com.qiao.service.impl;


import com.qiao.dao.UserDao;
import com.qiao.domain.User;
import com.qiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 *
 * @author igaozp
 * @version 1.0
 * @since 2016
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        if (user != null) {
            userDao.addUser(user);
        }
    }

    @Override
    public void updateUserByUserName(User user) {
        if (user != null) {
            userDao.updateUserByUserName(user);
        }
    }

    @Override
    public void updateUserByUserId(Integer userId) {
        if(userId != null){
            userDao.updateUserByUserId(userId);
        }
    }



    @Override
    public User getUserByUserName(String userName) {
        if (userName == null) {
            return null;
        }
        return userDao.findUserByUserName(userName);
    }

    @Override
    public String getPassword(String userName) {
        if (userName == null) {
            return null;
        }
        return userDao.getUserPasswordByUserName(userName);
    }

    @Override
    public void deleteUserByUserName(String userName) { }

    @Override
    public int deleteUserByUserId(Integer userId) {
        int res = userDao.deleteUserByUserId(userId);
        return res;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUserInfo();
    }
}
