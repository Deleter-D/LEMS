package edu.whpu.service.Impl;

import edu.whpu.dao.UserDao;
import edu.whpu.pojo.User;
import edu.whpu.service.LoginServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginServie {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String loginname, String password) {
        return userDao.getUserById(1);
//        return userDao.UserLogin(loginname, password);
    }
}
