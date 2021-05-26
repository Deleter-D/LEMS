package edu.whpu.service;

import edu.whpu.pojo.User;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;
import java.util.Map;

public interface UserService {
    public List<User> getUserList();

    public User getUserById(int u_ID);

    public int updateUser(User user);

    public int addUser(User user);

    public int deleteUser(int u_ID);
}
