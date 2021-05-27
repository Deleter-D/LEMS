package edu.whpu.dao;

import edu.whpu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface UserDao {
    public List<User> getAllUser();

    public User getUserById(int u_ID);

    public int insertUser(User user);

    public int deleteUser(int u_ID);

    public int updateUser(User user);

    public User UserLogin(@Param("u_account") String loginname, @Param("u_password") String password, @Param("u_identity") String identity);

    public List<User> getUserList();

    public List<User> getAllAdmin();
}
