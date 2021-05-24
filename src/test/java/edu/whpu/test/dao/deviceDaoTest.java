package edu.whpu.test.dao;

import edu.whpu.dao.DeviceDao;
import edu.whpu.pojo.Device;
import edu.whpu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class deviceDaoTest {
    @Autowired
    DeviceDao deviceDao;

    @Test
    public void getAllDeviceTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        deviceDao = sqlSession.getMapper(DeviceDao.class);
        List<Device> deviceList = deviceDao.getAllDevice();
        for (Device device : deviceList) {
            System.out.println(device);
        }
        sqlSession.close();
    }

    @Test
    public void getDeviceById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        deviceDao = sqlSession.getMapper(DeviceDao.class);
        Device device = deviceDao.getDeviceById(1);
        System.out.println(device);
        sqlSession.close();
    }

    @Test
    public void insertDeviceTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        deviceDao = sqlSession.getMapper(DeviceDao.class);
        Device device = new Device("粒子对撞机", 10000000f, 1, new Date(), "XX科技", "10年", 1, 1, 0);
        int count = deviceDao.insertDevice(device);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void deleteDeviceTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        deviceDao = sqlSession.getMapper(DeviceDao.class);
        int count = deviceDao.deleteDevice(4);
        System.out.println(count);
        sqlSession.commit();
    }

    @Test
    public void updateDeviceTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        deviceDao = sqlSession.getMapper(DeviceDao.class);
        Device device = deviceDao.getDeviceById(1);
        device.setD_price(8000000);
        int count = deviceDao.updateDevice(device);
        System.out.println(count);
        sqlSession.commit();
    }
}
