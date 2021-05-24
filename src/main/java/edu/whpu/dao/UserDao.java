package edu.whpu.dao;

import edu.whpu.pojo.User;

import java.util.List;

public interface UserDao {
    public List<User> getAllUser();

    public User getUserById(int u_ID);

    public int insertUser(User user);

    public int deleteUser(int u_ID);

    public int updateUser(User user);
}
