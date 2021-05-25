package edu.whpu.test.service;

import edu.whpu.pojo.User;
import edu.whpu.service.LoginServie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class LoginServiceTest {
    @Autowired
    private LoginServie loginServie;

    @Test
    public void loginTest() {
        User user = loginServie.login("1805110274", "adminwyp", "1");
        System.out.println(user);
    }
}
