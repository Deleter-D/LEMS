package edu.whpu.test.dao;

import edu.whpu.dao.DeviceDao;
import edu.whpu.pojo.Device;
import edu.whpu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = {"classpath:applicationContext.xml"})
public class deviceDaoTest {
    @Autowired
    private DeviceDao deviceDao;

    @Test
    public void getAllDeviceTest() {
        List<Device> deviceList = deviceDao.getAllDevice();
        for (Device device : deviceList) {
            System.out.println(device);
        }
    }

    @Test
    public void getDeviceById() {
        Device device = deviceDao.getDeviceById(1);
        System.out.println(device);
    }

    @Test
    public void insertDeviceTest() {
        Device device = new Device("粒子对撞机", 10000000f, 1, new Date(), "XX科技", "10年", 1, 1, 0);
        int count = deviceDao.insertDevice(device);
        System.out.println(count);
    }

    @Test
    public void deleteDeviceTest() {
        int count = deviceDao.deleteDevice(4);
        System.out.println(count);
    }

    @Test
    public void updateDeviceTest() {
        Device device = deviceDao.getDeviceById(1);
        device.setD_price(8000000);
        int count = deviceDao.updateDevice(device);
        System.out.println(count);
    }

    @Test
    public void getDeviceListTest(){
        List<Device> deviceList = deviceDao.getDeviceList();
        for (Device device:deviceList){
            System.out.println(device);
        }
    }
}
