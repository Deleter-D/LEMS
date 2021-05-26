package edu.whpu.service.Impl;

import edu.whpu.dao.UserDao;
import edu.whpu.pojo.User;
import edu.whpu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getUserList() {
        return userDao.getUserList();
    }

    @Override
    public int addUser(User user) {
        return userDao.insertUser(user);
    }

    @Override
    public User getUserById(int u_ID) {
        return userDao.getUserById(u_ID);
    }

    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public int deleteUser(int u_ID) {
        return userDao.deleteUser(u_ID);
    }
}
