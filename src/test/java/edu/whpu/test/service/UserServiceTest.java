package edu.whpu.test.service;

import edu.whpu.pojo.User;
import edu.whpu.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void getAllUserTest() {
        List<User> userList = userService.getUserList();
        for (User user:userList){
            System.out.println(user);
        }
    }
}
