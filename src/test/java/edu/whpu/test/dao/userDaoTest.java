package edu.whpu.test.dao;

import edu.whpu.dao.UserDao;
import edu.whpu.pojo.User;
import edu.whpu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class userDaoTest {

    @Autowired
    private UserDao userDao;

    @Test
    public void getAllUserTest() {
        List<User> userList = userDao.getAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void getUserByIdTest() {
        User user = userDao.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void insertUserTest() {
        User user = new User("18051102x1", "admin01", "张三", "18735803948", 1, "0");
        int count = userDao.insertUser(user);
        System.out.println(count);
    }

    @Test
    public void deleteUserTest() {
        int count = userDao.deleteUser(5);
        System.out.println(count);
    }

    @Test
    public void updateUserTest() {
        User user = userDao.getUserById(12);
        user.setU_password("admin123");
        int count = userDao.updateUser(user);
        System.out.println(count);
    }

    @Test
    public void getUserByAccountTest() {
        User user = userDao.userLogin("1805110274", "adminwyp", "1");
        System.out.println(user);
    }

    @Test
    public void getUserListTest() {
        List<User> userList = userDao.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void getAllAdminTest() {
        List<User> adminList = userDao.getAllAdmin();
        for (User user : adminList) {
            System.out.println(user);
        }
    }

    @Test
    public void userLoginTest() {
        User user = userDao.userLogin("1805110274", "adminwyp", "1");
        System.out.println(user);
    }

    @Test
    public void likeTest() {
        List<User> userList = userDao.quaryByAccount("09");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void likeTest2() {
        List<User> userList = userDao.quaryByName("王");
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
