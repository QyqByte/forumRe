package com.qiao.service.impl;


import com.qiao.dao.UserLoginLogDao;
import com.qiao.domain.UserLoginLog;
import com.qiao.service.LoginLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * LoginLogServiceImpl
 *
 * @author igaozp
 * @version 1.0
 * @since 2016
 */
@Service
public class LoginLogServiceImpl implements LoginLogService {
    private final UserLoginLogDao userLoginLogDao;

    @Autowired
    public LoginLogServiceImpl(UserLoginLogDao userLoginLogDao) {
        this.userLoginLogDao = userLoginLogDao;
    }

    @Override
    public void listAllUserLoginLog() { }

    @Override
    public void addUserLoginLog(UserLoginLog userLoginLog) {
        userLoginLogDao.addUserLoginLog(userLoginLog);
    }

}
