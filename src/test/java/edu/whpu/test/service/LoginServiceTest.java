package edu.whpu.test.service;

import edu.whpu.pojo.User;
import edu.whpu.service.Impl.LoginServiceImpl;
import edu.whpu.service.LoginServie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceTest {
    @Autowired
    private LoginServie loginServie;

    @Test
    public void loginTest() {
        User user = loginServie.login("1805110274", "adminwyp");
        System.out.println(user);
    }
}
