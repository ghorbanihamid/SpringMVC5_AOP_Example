package com.soshiant.service.users;


import com.soshiant.model.user.UserInfo;
import com.soshiant.repository.UserDao;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LogManager.getRootLogger();

    @Autowired
    private UserDao userDao;

    //==================================================================================================================
    public boolean login(String userName, String password) {

        logger.info("*************Login is processing");
        UserInfo userInfo = userDao.getUserInfo(userName);
        return userInfo != null && userInfo.getPassword().equals(password);
    }
    //======================================================================================================================
    public boolean addNewUser(UserInfo userInfo) {

        userDao.addNewUser(userInfo);
        return true;
    }

    //======================================================================================================================
    public List<UserInfo> getUsersList(){

        List<UserInfo> userInfoList = userDao.getAllUsers();
        return userInfoList;
    }
}

