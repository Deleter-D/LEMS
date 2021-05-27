package edu.whpu.test.service;

import edu.whpu.pojo.User;
import edu.whpu.service.DeviceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class DeviceServiceTest {

    @Autowired
    DeviceService deviceService;

    @Test
    public void getAllAdminTest() {
        List<User> adminList = deviceService.getAllAdmin();
        for (User user : adminList) {
            System.out.println(user);
        }
    }

}
