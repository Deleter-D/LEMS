package edu.whpu.test.dao;

import edu.whpu.dao.UserDao;
import edu.whpu.pojo.User;
import edu.whpu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class userDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void getAllUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getAllUser();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    @Test
    public void getUserByIdTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserById(1);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void insertUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userDao = sqlSession.getMapper(UserDao.class);
        User user = new User("18051102x1", "admin01", "张三", "18735803948", 1, 0);
        int count = userDao.insertUser(user);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void deleteUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userDao = sqlSession.getMapper(UserDao.class);
        int count = userDao.deleteUser(3);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void updateUserTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserById(4);
        user.setU_password("adminwyp");
        int count = userDao.updateUser(user);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void getUserByAccountTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.UserLogin("1805110274","adminwyp");
        System.out.println(user);
        sqlSession.close();
    }
}
